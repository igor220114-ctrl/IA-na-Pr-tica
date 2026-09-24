package com.example.data.model

data class Book(
    val id: String,
    val title: String,
    val subtitle: String,
    val author: String,
    val edition: String,
    val description: String,
    val coverResId: Int,
    val chapters: List<Chapter>,
    val promptVault: List<PromptItem>,
    val glossary: List<GlossaryItem>,
    val checklist: List<ChecklistItem>,
    val aboutAuthor: AboutAuthor,
    val disclaimer: String
)

data class Chapter(
    val id: Int,
    val numberLabel: String, // e.g. "Introdução", "Capítulo 1", "Apêndice"
    val title: String,
    val subtitle: String,
    val estimatedMinutes: Int,
    val sections: List<ChapterSection>,
    val summaryPoints: List<String>,
    val exercise: ChapterExercise? = null
)

sealed class ChapterSection {
    data class Paragraph(val text: String) : ChapterSection()
    data class Subheading(val title: String) : ChapterSection()
    data class ExampleCallout(
        val title: String,
        val context: String,
        val beforeExample: String? = null,
        val afterExample: String,
        val takeaway: String
    ) : ChapterSection()
    data class TipCallout(
        val title: String,
        val tip: String
    ) : ChapterSection()
    data class WarningCallout(
        val title: String,
        val warning: String
    ) : ChapterSection()
    data class PromptBox(
        val title: String,
        val description: String,
        val promptText: String,
        val expectedOutcome: String
    ) : ChapterSection()
    data class BulletList(
        val intro: String? = null,
        val items: List<String>
    ) : ChapterSection()
    data class StepByStep(
        val title: String,
        val steps: List<StepItem>
    ) : ChapterSection()
}

data class StepItem(
    val stepNumber: Int,
    val title: String,
    val description: String
)

data class ChapterExercise(
    val id: String,
    val title: String,
    val instructions: String,
    val suggestedPrompt: String? = null,
    val reflectionQuestions: List<String> = emptyList(),
    val practicalTask: String
)

data class PromptItem(
    val id: String,
    val category: String, // e.g., "Estudos", "Escrita", "Produtividade", "Trabalho", "Negócios", "Conteúdo"
    val title: String,
    val prompt: String,
    val explanation: String,
    val tags: List<String> = emptyList()
)

data class GlossaryItem(
    val term: String,
    val simpleDefinition: String,
    val practicalExample: String
)

data class ChecklistItem(
    val id: String,
    val stepOrder: Int,
    val title: String,
    val description: String,
    val whyItMatters: String
)

data class AboutAuthor(
    val name: String,
    val bio: String,
    val note: String,
    val contactOrEditableNote: String
)
