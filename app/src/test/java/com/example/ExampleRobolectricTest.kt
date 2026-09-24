package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.book.DefaultBookRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

    @Test
    fun `read app name string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("IA na Prática", appName)
    }

    @Test
    fun `verify book structure and chapters completeness`() {
        val repository = DefaultBookRepository()
        val book = repository.getBook()

        assertEquals("ia_na_pratica_v1", book.id)
        assertEquals("IA na Prática", book.title)
        assertEquals(15, book.chapters.size) // Intro + 14 chapters

        // Verify chapter navigation
        val firstChapter = repository.getChapter(0)
        assertNotNull(firstChapter)
        assertEquals("O Novo Superpoder Cotidiano", firstChapter?.title)
        assertEquals("Introdução Geral", firstChapter?.numberLabel)

        val nextChapter = repository.getNextChapter(0)
        assertNotNull(nextChapter)
        assertEquals(1, nextChapter?.id)

        val prevChapter = repository.getPreviousChapter(1)
        assertNotNull(prevChapter)
        assertEquals(0, prevChapter?.id)
    }

    @Test
    fun `verify book search engine returns accurate results`() {
        val repository = DefaultBookRepository()
        val results = repository.searchContent("Feynman")
        assertTrue("Expected search results for Feynman", results.isNotEmpty())

        val promptResults = repository.searchContent("prompt")
        assertTrue("Expected search results for prompt", promptResults.isNotEmpty())
    }

    @Test
    fun `verify prompt vault and checklist are fully populated`() {
        val repository = DefaultBookRepository()
        val book = repository.getBook()

        assertTrue("Expected prompts in vault", book.promptVault.isNotEmpty())
        assertTrue("Expected checklist items", book.checklist.isNotEmpty())
        assertTrue("Expected glossary items", book.glossary.isNotEmpty())
    }
}
