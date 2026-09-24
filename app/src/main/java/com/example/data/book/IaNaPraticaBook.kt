package com.example.data.book

import com.example.R
import com.example.data.book.content.BookAppendicesContent
import com.example.data.book.content.BookIntroContent
import com.example.data.book.content.Chapters10to12Content
import com.example.data.book.content.Chapters13to14Content
import com.example.data.book.content.Chapters1to3Content
import com.example.data.book.content.Chapters4to6Content
import com.example.data.book.content.Chapters7to9Content
import com.example.data.model.Book

object IaNaPraticaBook {

    val instance: Book by lazy {
        Book(
            id = "ia_na_pratica_v1",
            title = "IA na Prática",
            subtitle = "Um Guia Simples para Usar Inteligência Artificial no Dia a Dia",
            author = "Equipe IA na Prática",
            edition = "1ª Edição Digital • 2026",
            description = "O guia definitivo em português para estudantes, profissionais e empreendedores que desejam dominar a inteligência artificial generativa no cotidiano sem complicações técnicas.",
            coverResId = R.drawable.img_book_cover,
            chapters = listOf(
                BookIntroContent.chapter,
                Chapters1to3Content.chapter1,
                Chapters1to3Content.chapter2,
                Chapters1to3Content.chapter3,
                Chapters4to6Content.chapter4,
                Chapters4to6Content.chapter5,
                Chapters4to6Content.chapter6,
                Chapters7to9Content.chapter7,
                Chapters7to9Content.chapter8,
                Chapters7to9Content.chapter9,
                Chapters10to12Content.chapter10,
                Chapters10to12Content.chapter11,
                Chapters10to12Content.chapter12,
                Chapters13to14Content.chapter13,
                Chapters13to14Content.chapter14
            ),
            promptVault = BookAppendicesContent.promptVault,
            glossary = BookAppendicesContent.glossary,
            checklist = BookAppendicesContent.checklist,
            aboutAuthor = BookAppendicesContent.aboutAuthor,
            disclaimer = BookAppendicesContent.disclaimer
        )
    }
}
