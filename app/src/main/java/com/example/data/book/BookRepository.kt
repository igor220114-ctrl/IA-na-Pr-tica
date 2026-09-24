package com.example.data.book

import com.example.data.model.Book
import com.example.data.model.Chapter
import com.example.data.model.ChapterSection
import com.example.data.model.ChecklistItem
import com.example.data.model.GlossaryItem
import com.example.data.model.PromptItem

data class SearchResult(
    val chapterId: Int,
    val chapterTitle: String,
    val chapterNumber: String,
    val snippet: String,
    val matchedTerm: String
)

interface BookRepository {
    fun getBook(): Book
    fun getChapter(chapterId: Int): Chapter?
    fun getPreviousChapter(currentChapterId: Int): Chapter?
    fun getNextChapter(currentChapterId: Int): Chapter?
    fun searchContent(query: String): List<SearchResult>
    fun getPrompts(categoryFilter: String? = null): List<PromptItem>
    fun getGlossary(): List<GlossaryItem>
    fun getChecklist(): List<ChecklistItem>
}

class DefaultBookRepository(
    private val book: Book = IaNaPraticaBook.instance
) : BookRepository {

    override fun getBook(): Book = book

    override fun getChapter(chapterId: Int): Chapter? {
        return book.chapters.find { it.id == chapterId }
    }

    override fun getPreviousChapter(currentChapterId: Int): Chapter? {
        val index = book.chapters.indexOfFirst { it.id == currentChapterId }
        return if (index > 0) book.chapters[index - 1] else null
    }

    override fun getNextChapter(currentChapterId: Int): Chapter? {
        val index = book.chapters.indexOfFirst { it.id == currentChapterId }
        return if (index >= 0 && index < book.chapters.size - 1) book.chapters[index + 1] else null
    }

    override fun searchContent(query: String): List<SearchResult> {
        val cleanQuery = query.trim()
        if (cleanQuery.length < 2) return emptyList()

        val results = mutableListOf<SearchResult>()

        for (chapter in book.chapters) {
            // Check title and subtitle
            if (chapter.title.contains(cleanQuery, ignoreCase = true) ||
                chapter.subtitle.contains(cleanQuery, ignoreCase = true)
            ) {
                results.add(
                    SearchResult(
                        chapterId = chapter.id,
                        chapterTitle = chapter.title,
                        chapterNumber = chapter.numberLabel,
                        snippet = chapter.subtitle,
                        matchedTerm = cleanQuery
                    )
                )
            }

            // Check sections
            for (section in chapter.sections) {
                val textToSearch = when (section) {
                    is ChapterSection.Paragraph -> section.text
                    is ChapterSection.Subheading -> section.title
                    is ChapterSection.ExampleCallout -> "${section.title} ${section.beforeExample ?: ""} ${section.afterExample} ${section.takeaway}"
                    is ChapterSection.TipCallout -> "${section.title} ${section.tip}"
                    is ChapterSection.WarningCallout -> "${section.title} ${section.warning}"
                    is ChapterSection.PromptBox -> "${section.title} ${section.promptText} ${section.description}"
                    is ChapterSection.BulletList -> section.items.joinToString(" ")
                    is ChapterSection.StepByStep -> section.steps.joinToString(" ") { "${it.title}: ${it.description}" }
                }

                val matchIndex = textToSearch.indexOf(cleanQuery, ignoreCase = true)
                if (matchIndex >= 0) {
                    val start = (matchIndex - 40).coerceAtLeast(0)
                    val end = (matchIndex + cleanQuery.length + 60).coerceAtMost(textToSearch.length)
                    val snippetText = (if (start > 0) "..." else "") +
                            textToSearch.substring(start, end).replace("\n", " ") +
                            (if (end < textToSearch.length) "..." else "")

                    results.add(
                        SearchResult(
                            chapterId = chapter.id,
                            chapterTitle = chapter.title,
                            chapterNumber = chapter.numberLabel,
                            snippet = snippetText,
                            matchedTerm = cleanQuery
                        )
                    )
                }
            }
        }

        return results.distinctBy { "${it.chapterId}_${it.snippet}" }.take(30)
    }

    override fun getPrompts(categoryFilter: String?): List<PromptItem> {
        return if (categoryFilter.isNullOrBlank() || categoryFilter == "Todos") {
            book.promptVault
        } else {
            book.promptVault.filter { it.category.equals(categoryFilter, ignoreCase = true) }
        }
    }

    override fun getGlossary(): List<GlossaryItem> = book.glossary

    override fun getChecklist(): List<ChecklistItem> = book.checklist
}
