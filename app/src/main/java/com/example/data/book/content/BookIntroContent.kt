package com.example.data.book.content

import com.example.data.model.Chapter
import com.example.data.model.ChapterExercise
import com.example.data.model.ChapterSection

object BookIntroContent {
    val chapter = Chapter(
        id = 0,
        numberLabel = "Introdução Geral",
        title = "O Novo Superpoder Cotidiano",
        subtitle = "Por que a inteligência artificial não é sobre robôs do futuro, mas sobre o seu tempo hoje",
        estimatedMinutes = 6,
        sections = listOf(
            ChapterSection.Paragraph(
                "Durante muito tempo, quando alguém mencionava a palavra \"inteligência artificial\", o imaginário popular desenhava robôs metálicos, cientistas de laboratório ou histórias de ficção científica em que computadores decidiam o destino da humanidade. Se você tinha essa impressão, saiba que ela é perfeitamente compreensível — o cinema passou décadas vendendo essa imagem."
            ),
            ChapterSection.Paragraph(
                "No entanto, a revolução da inteligência artificial que bateu à nossa porta nos últimos anos tem uma face muito diferente e muito mais prática. Ela não está em robôs humanoides que andam pela sala; ela está na tela do seu celular e do seu computador. Ela se parece mais com um assistente silencioso, incrivelmente paciente e ágil, pronto para ajudá-lo a redigir um e-mail difícil, decifrar um boleto confuso, resumir uma reunião de três horas ou planejar o cardápio da semana com o que sobrou na geladeira."
            ),
            ChapterSection.Subheading("O objetivo deste livro"),
            ChapterSection.Paragraph(
                "Este livro foi escrito especificamente para você que não é programador, não entende de equações matemáticas e não quer perder tempo com jargões difíceis. O objetivo aqui é um só: ensinar você a usar a inteligência artificial como uma ferramenta prática para resolver problemas reais da sua rotina."
            ),
            ChapterSection.Paragraph(
                "Aqui, você aprenderá a se comunicar com modelos de IA de forma clara, obtendo respostas úteis logo na primeira tentativa. Você descobrirá como economizar horas de trabalho burocrático, acelerar seu aprendizado em qualquer matéria, produzir textos melhores e organizar sua vida pessoal e profissional sem complicações."
            ),
            ChapterSection.TipCallout(
                title = "A mentalidade correta",
                tip = "Não encare a IA como um oráculo infalível e nem como um substituto do seu raciocínio. Encare-a como um estagiário brilhante, que leu milhões de livros, digita a mil palavras por minuto, mas ainda precisa de um bom orientador para entregar exatamente o que você precisa."
            ),
            ChapterSection.Subheading("Como aproveitar este livro ao máximo"),
            ChapterSection.Paragraph(
                "Cada capítulo deste livro foi desenhado com um formato direto e sem enrolação:"
            ),
            ChapterSection.BulletList(
                intro = "O que você encontrará em cada capítulo:",
                items = listOf(
                    "Conceitos explicados em linguagem simples e cotidiana.",
                    "Exemplos reais comparando o jeito fraco e o jeito eficaz de pedir ajuda à IA.",
                    "Prompts prontos para copiar e usar imediatamente com um único toque.",
                    "Dicas práticas e alertas de erros comuns para você não cair em armadilhas.",
                    "Um resumo rápido para fixar os pontos principais.",
                    "Um exercício prático interativo para você aplicar no mesmo instante."
                )
            ),
            ChapterSection.Paragraph(
                "Você pode ler este livro do início ao fim ou usá-lo como um guia de consulta rápida sempre que tiver uma tarefa específica para realizar. A melhor maneira de aprender a usar inteligência artificial é praticando. Por isso, tenha sempre em mente: o conhecimento só se torna superpoder quando vira ação."
            )
        ),
        summaryPoints = listOf(
            "A IA moderna não é ficção científica: é uma ferramenta prática de produtividade pessoal.",
            "Você não precisa saber programação para tirar proveito imediato da IA.",
            "Pense na IA como um assistente ágil que precisa de orientações claras e contexto.",
            "O aprendizado real vem da experimentação diária com tarefas concretas."
        ),
        exercise = ChapterExercise(
            id = "ex_intro",
            title = "Seu primeiro contato prático",
            instructions = "Abra sua ferramenta de IA favorita (como Gemini ou ChatGPT) e faça seu primeiro teste com o prompt abaixo. Repare como fornecer contexto muda completamente a qualidade da resposta.",
            suggestedPrompt = "Você é um consultor de produtividade pessoal. Quero aprender a usar inteligência artificial para economizar tempo no meu dia a dia. Minha rotina envolve trabalho administrativo e estudos à noite. Quais são 3 tarefas simples do meu cotidiano que eu já posso começar a delegar para a IA a partir de hoje?",
            practicalTask = "Envie o prompt, leia a resposta com atenção e anote abaixo qual das 3 sugestões você considerou mais útil para a sua rotina atual.",
            reflectionQuestions = listOf(
                "A resposta foi genérica ou específica?",
                "Como você poderia adicionar mais detalhes sobre seu trabalho para a resposta ficar ainda melhor?"
            )
        )
    )
}
