package com.example.data.book.content

import com.example.data.model.Chapter
import com.example.data.model.ChapterExercise
import com.example.data.model.ChapterSection
import com.example.data.model.StepItem

object Chapters13to14Content {

    val chapter13 = Chapter(
        id = 13,
        numberLabel = "Capítulo 13",
        title = "Projeto Prático: Criando Algo do Zero",
        subtitle = "Um estudo de caso completo: do rascunho de uma ideia até a entrega pronta",
        estimatedMinutes = 12,
        sections = listOf(
            ChapterSection.Paragraph(
                "Chegou o momento de juntar todas as peças do quebra-cabeça que aprendemos até aqui. Em vez de estudar a teoria de forma isolada, vamos acompanhar a criação de um projeto completo do início ao fim usando a inteligência artificial como parceira de cocriação."
            ),
            ChapterSection.Paragraph(
                "Vamos usar um caso muito comum: o planejamento e lançamento de um minicurso ou workshop prático (mas o mesmo modelo se aplica ao lançamento de um produto físico, um serviço de consultoria ou um evento da sua comunidade)."
            ),
            ChapterSection.Subheading("O Roteiro da Execução em 5 Etapas"),
            ChapterSection.StepByStep(
                title = "O ciclo de desenvolvimento com IA",
                steps = listOf(
                    StepItem(
                        stepNumber = 1,
                        title = "Etapa 1: Definição do Problema e Posicionamento",
                        description = "Descobrir para quem é o projeto, qual dor urgente ele resolve e qual é a promessa central."
                    ),
                    StepItem(
                        stepNumber = 2,
                        title = "Etapa 2: Estruturação da Ementa ou Escopo",
                        description = "Criar o esqueleto do conteúdo dividido em módulos ou fases lógicas de aprendizagem."
                    ),
                    StepItem(
                        stepNumber = 3,
                        title = "Etapa 3: Redação do Material e Exemplos Práticos",
                        description = "Escrever o conteúdo das aulas, exercícios e materiais de apoio com prompts dedicados."
                    ),
                    StepItem(
                        stepNumber = 4,
                        title = "Etapa 4: Página de Apresentação e Mensagens de Divulgação",
                        description = "Produzir a comunicação de divulgação, texto de convite para WhatsApp e e-mail de boas-vindas."
                    ),
                    StepItem(
                        stepNumber = 5,
                        title = "Etapa 5: Validação Crítica e Ajuste Final",
                        description = "Pedir para a IA auditar o projeto em busca de furos conceituais antes de colocar na rua."
                    )
                )
            ),
            ChapterSection.ExampleCallout(
                title = "Estudo de Caso Real: O Workshop de Organização Financeira",
                context = "Uma consultora que desejava criar um workshop de 2 horas para jovens profissionais:",
                beforeExample = "Sem IA: 3 semanas procrastinando na montagem de slides e na redação dos textos de divulgação.",
                afterExample = "Com fluxo de IA: 1 tarde de trabalho. Em 4 horas, com 5 prompts sequenciais bem calibrados, ela definiu o tema exato, estruturou os 4 blocos de 30 minutos, criou a planilha de exercícios práticos, redigiu o texto de vendas do Instagram e o script de WhatsApp para os primeiros inscritos.",
                takeaway = "A velocidade da execução transforma ideias estagnadas em realizações concretas no mundo real."
            ),
            ChapterSection.PromptBox(
                title = "Prompt 1 do Projeto: Definição de Escopo e Público",
                description = "O primeiro disparo para dar vida a qualquer projeto:",
                promptText = "Quero criar um [workshop / minicurso / serviço / produto] sobre [assunto principal]. Meu público ideal são [descrever público].\nAja como um estrategista de negócios experiente. Me ajude a definir:\n1. O nome provisório atraente e claro;\n2. A grande promessa central (o que a pessoa será capaz de fazer ao final);\n3. Os 3 maiores erros que concorrentes cometem ao ensinar isso e como podemos fazer diferente.",
                expectedOutcome = "Fundamentos sólidos e posicionamento claro para o seu projeto."
            ),
            ChapterSection.PromptBox(
                title = "Prompt 2 do Projeto: A Página de Apresentação (Landing Page)",
                description = "Crie o texto de divulgação persuasivo e honesto:",
                promptText = "Com base no posicionamento acima, escreva a estrutura de uma página de apresentação (ou texto de divulgação longo) contendo:\n- Título principal com gancho claro;\n- Seção 'Para quem é' e 'Para quem NÃO é';\n- O cronograma das 4 etapas/módulos principais;\n- Respostas para as 3 dúvidas mais comuns;\n- Chamada para ação final motivadora.",
                expectedOutcome = "Uma estrutura completa de comunicação de vendas pronta para uso."
            ),
            ChapterSection.TipCallout(
                title = "A regra de ouro da execução rápida",
                tip = "Não espere o projeto ficar perfeito para validar com as primeiras pessoas. Lance uma versão inicial enxuta (MVP), colha feedback real de usuários e use a IA para refinar os pontos fracos com base nas críticas recebidas."
            )
        ),
        summaryPoints = listOf(
            "Divida qualquer grande empreitada em 5 etapas lógicas e sequenciais.",
            "Use a IA para destravar desde o conceito inicial até a comunicação de vendas.",
            "Valide cedo: lance uma versão inicial para aprender com o feedback real.",
            "A maior vantagem competitiva hoje é a velocidade entre ter uma ideia e colocá-la no mundo."
        ),
        exercise = ChapterExercise(
            id = "ex_cap13",
            title = "Dê o primeiro passo no seu projeto dos sonhos",
            instructions = "Pense naquele projeto que você está adiando há meses (uma aula, um produto artesanal, uma consultoria, um canal de vídeos). Execute a Etapa 1 com o prompt acima.",
            suggestedPrompt = "Quero criar [descrever a ideia]. Me dê 3 opções de nomes e a estrutura em 4 passos práticos para começar.",
            practicalTask = "Escolha a melhor proposta de nome e anote no bloco de respostas abaixo.",
            reflectionQuestions = listOf(
                "O que parecia complicado ficou mais simples quando quebrado em partes?",
                "Qual é o primeiro compromisso prático que você pode assumir esta semana para tirar isso do papel?"
            )
        )
    )

    val chapter14 = Chapter(
        id = 14,
        numberLabel = "Capítulo 14",
        title = "Conclusão e Próximos Passos",
        subtitle = "Ética, futuro do trabalho e como transformar o uso da IA em um hábito duradouro",
        estimatedMinutes = 8,
        sections = listOf(
            ChapterSection.Paragraph(
                "Parabéns por ter chegado até aqui! Ao concluir a leitura deste livro, você já acumulou mais conhecimento prático sobre inteligência artificial do que 95% das pessoas que apenas ouvem falar do assunto pelas notícias superficiais da televisão ou pelas redes sociais."
            ),
            ChapterSection.Paragraph(
                "Você agora entende o mecanismo por trás dos modelos de linguagem, domina o método C.O.R.P. para criar prompts certeiros, sabe como aplicar a ferramenta em estudos, escrita, trabalho, rotinas e pequenos negócios, e conhece as armadilhas das alucinações e como se proteger delas."
            ),
            ChapterSection.Subheading("O Futuro do Trabalho: Substituição ou Ampliação?"),
            ChapterSection.Paragraph(
                "Há uma frase célebre no mercado de tecnologia que resume perfeitamente o momento histórico em que vivemos: 'A inteligência artificial não vai substituir os humanos, mas os humanos que sabem usar inteligência artificial vão substituir os que não sabem'."
            ),
            ChapterSection.Paragraph(
                "A sua capacidade de ter empatia, julgar contextos éticos, tomar decisões difíceis sob pressão e construir relações de confiança com outras pessoas continua sendo insubstituível. A IA entra não para roubar a sua humanidade, mas para assumir a carga mecânica e repetitiva que até então roubava o seu tempo de ser plenamente humano."
            ),
            ChapterSection.Subheading("Os 3 Hábitos Diários para se Manter Atualizado"),
            ChapterSection.BulletList(
                intro = "Como consolidar o uso da IA na sua rotina daqui para frente:",
                items = listOf(
                    "1. A Regra do Primeiro Instinto: Diante de qualquer tarefa chata ou repetitiva do dia, pergunte-se: 'A IA poderia me ajudar a fazer o primeiro rascunho disso?'.",
                    "2. Manter uma Biblioteca Pessoal de Prompts: Vá salvando os comandos que deram certo em um local de fácil acesso para reutilizá-los sempre.",
                    "3. Curiosidade Sem Medo: Experimente novos recursos conforme forem lançados. A melhor maneira de perder o receio da tecnologia é brincando com ela."
                )
            ),
            ChapterSection.TipCallout(
                title = "O verdadeiro ganho de produtividade",
                tip = "Economizar 2 horas por dia com IA não serve para você trabalhar mais 2 horas até o esgotamento. O objetivo final é ter mais tempo livre de qualidade: para a sua família, para sua saúde, para ler livros, descansar e viver com menos estresse."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Encerramento e Plano Pessoal de Ação",
                description = "Trace suas metas para os próximos 30 dias com base no que você aprendeu:",
                promptText = "Aja como um mentor de desenvolvimento pessoal. Acabei de ler um livro prático sobre inteligência artificial. Minha rotina principal é [descrever seu trabalho e vida diária]. Crie um plano de ação para os próximos 30 dias com apenas UMA nova micro-habilidade de IA para eu praticar a cada semana, garantindo que eu crie o hábito sem me sobrecarregar.",
                expectedOutcome = "Um roteiro leve e realista de 4 semanas para internalizar os aprendizados."
            )
        ),
        summaryPoints = listOf(
            "A IA amplia a capacidade humana ao assumir o trabalho burocrático e repetitivo.",
            "O discernimento ético, a empatia e o julgamento crítico continuam exclusivamente seus.",
            "Adote a pergunta reflexiva: 'A IA pode me ajudar no primeiro rascunho dessa tarefa?'.",
            "Use o tempo economizado para cuidar do que realmente tem valor na sua vida."
        ),
        exercise = ChapterExercise(
            id = "ex_cap14",
            title = "Seu pacto de produtividade",
            instructions = "Defina a meta mais importante de economia de tempo que você pretende alcançar no próximo mês usando o que aprendeu neste livro.",
            suggestedPrompt = "Gere um compromisso de 3 metas práticas de produtividade pessoal para as próximas 4 semanas usando IA.",
            practicalTask = "Escreva abaixo qual hábito ou tarefa você vai transformar primeiro a partir de hoje.",
            reflectionQuestions = listOf(
                "Qual foi o capítulo que gerou a maior 'virada de chave' no seu modo de pensar?",
                "Quem do seu círculo de amizades ou trabalho mais se beneficiaria de ler este livro?"
            )
        )
    )
}
