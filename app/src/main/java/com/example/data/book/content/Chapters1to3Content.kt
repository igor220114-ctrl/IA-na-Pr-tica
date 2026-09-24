package com.example.data.book.content

import com.example.data.model.Chapter
import com.example.data.model.ChapterExercise
import com.example.data.model.ChapterSection
import com.example.data.model.StepItem

object Chapters1to3Content {

    val chapter1 = Chapter(
        id = 1,
        numberLabel = "Capítulo 1",
        title = "O Que É Inteligência Artificial",
        subtitle = "Entenda como ela funciona na prática, sem termos técnicos ou equações",
        estimatedMinutes = 8,
        sections = listOf(
            ChapterSection.Paragraph(
                "Para usar uma ferramenta com eficiência, você não precisa saber construir o motor, mas precisa saber como dirigi-la. Com a inteligência artificial acontece a mesma coisa. Você não precisa entender álgebra linear, mas compreender o básico de como ela processa informações evitará que você se frustre ou espere milagres impossíveis."
            ),
            ChapterSection.Subheading("O autocompletar mais avançado do mundo"),
            ChapterSection.Paragraph(
                "A forma mais simples e precisa de entender os modelos de linguagem atuais (como Gemini, Claude ou ChatGPT) é compará-los com o recurso de autocompletar do teclado do seu celular — só que elevado a uma potência astronômica."
            ),
            ChapterSection.Paragraph(
                "Quando você digita \"Bom\" no teclado do smartphone, ele sugere \"dia\" ou \"trabalho\". Ele faz isso porque observou milhões de conversas humanas e calculou qual palavra tem maior probabilidade estatística de vir em seguida. Os modelos de IA generativa fazem exatamente isso, porém considerando parágrafos inteiros, tons de voz, estruturas lógicas e bilhões de conexões de sentido."
            ),
            ChapterSection.Paragraph(
                "Isso significa que a IA não \"sente\", não tem consciência e não possui intenções próprias. Ela calcula a sequência de palavras mais coerente e provável com base nas instruções e no contexto que você forneceu."
            ),
            ChapterSection.ExampleCallout(
                title = "Analogia do Cozinheiro e da Despensa",
                context = "Imagine que a IA é um cozinheiro veloz e com técnica impecável:",
                beforeExample = "Se você pedir: 'Faça comida boa', ele vai olhar para uma despensa gigante e fazer algo genérico (provavelmente arroz e feijão básico).",
                afterExample = "Se você disser: 'Use os 3 ovos, a cenoura ralada e o queijo que estão na geladeira para fazer uma refeição leve de 15 minutos sem fritura', ele entregará um prato exato e saboroso.",
                takeaway = "A IA responde à precisão dos ingredientes que você entrega no seu pedido."
            ),
            ChapterSection.Subheading("O que a IA faz muito bem"),
            ChapterSection.BulletList(
                intro = "As forças naturais dos modelos de linguagem:",
                items = listOf(
                    "Sintetizar grandes volumes de texto em tópicos essenciais.",
                    "Reescrever conteúdos em diferentes estilos e tons (formal, simples, persuasivo).",
                    "Explicar conceitos difíceis através de analogias e exemplos simples.",
                    "Fazer tempestade de ideias (brainstorming) e sugerir alternativas criativas.",
                    "Organizar dados bagunçados em tabelas, listas e cronogramas estruturados."
                )
            ),
            ChapterSection.Subheading("O que a IA NÃO faz bem por conta própria"),
            ChapterSection.WarningCallout(
                title = "Cuidado com a 'Alucinação'",
                warning = "A IA foi treinada para ser plausível, não necessariamente verdadeira. Quando ela não sabe uma informação específica, em vez de dizer 'não sei', ela pode inventar um fato com aparência extremamente convincente. Nunca confie cegamente em dados numéricos, citações jurídicas ou fatos históricos sem conferência prévia."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Diagnóstico Inicial",
                description = "Use este prompt para entender o nível de conhecimento da IA sobre a sua área profissional:",
                promptText = "Explique como a inteligência artificial generativa pode ser aplicada no dia a dia de um [sua profissão ou área]. Destaque 3 tarefas rotineiras que podem ser otimizadas e 2 tarefas que ainda exigem 100% de supervisão humana.",
                expectedOutcome = "Uma análise equilibrada e realista adaptada exatamente ao seu setor de atuação."
            )
        ),
        summaryPoints = listOf(
            "A IA generativa funciona prevendo a próxima palavra mais provável com base no contexto.",
            "Ela não tem consciência ou sentimentos; é um processador sofisticado de padrões linguísticos.",
            "Ela é excelente para resumir, traduzir, estruturar e sugerir alternativas.",
            "Ela pode 'alucinar' se não tiver contexto suficiente ou for forçada a inventar fatos."
        ),
        exercise = ChapterExercise(
            id = "ex_cap1",
            title = "Descobrindo sua rotina com IA",
            instructions = "Copie o prompt do capítulo e substitua '[sua profissão ou área]' pela sua ocupação atual (por exemplo: professor do ensino fundamental, vendedor de loja, estudante de direito, arquiteto).",
            suggestedPrompt = "Explique como a inteligência artificial generativa pode ser aplicada no dia a dia de um [sua profissão ou área]. Destaque 3 tarefas rotineiras que podem ser otimizadas e 2 tarefas que ainda exigem 100% de supervisão humana.",
            practicalTask = "Cole a resposta recebida e anote qual tarefa indicada chamou mais a sua atenção.",
            reflectionQuestions = listOf(
                "A IA acertou os desafios do seu trabalho?",
                "Alguma das tarefas automatizáveis nunca havia passado pela sua cabeça?"
            )
        )
    )

    val chapter2 = Chapter(
        id = 2,
        numberLabel = "Capítulo 2",
        title = "Como Conversar com uma IA",
        subtitle = "O método C.O.R.P. para criar instruções claras e obter respostas certeiras",
        estimatedMinutes = 10,
        sections = listOf(
            ChapterSection.Paragraph(
                "A maioria das pessoas que se decepciona com a inteligência artificial comete sempre o mesmo erro: fala com a máquina como se estivesse buscando algo no Google. No Google você digita palavras-chave isoladas (\"modelo contrato aluguel simples\"). Com a IA, você precisa dar instruções estruturadas."
            ),
            ChapterSection.Paragraph(
                "Um \"prompt\" nada mais é do que o texto de instrução que você envia para a IA. Quanto mais rico e bem direcionado for o seu prompt, melhor será o resultado obtido. Para garantir que você nunca mais receba respostas vagas, criamos a fórmula prática C.O.R.P."
            ),
            ChapterSection.Subheading("O Método C.O.R.P."),
            ChapterSection.StepByStep(
                title = "Os 4 Pilares de um Prompt Perfeito",
                steps = listOf(
                    StepItem(
                        stepNumber = 1,
                        title = "C - Contexto (Quem você é e qual é o cenário)",
                        description = "Explique a situação de fundo. Exemplo: 'Sou gerente de uma pequena loja de roupas e preciso avisar os clientes sobre a mudança de endereço da loja.'"
                    ),
                    StepItem(
                        stepNumber = 2,
                        title = "O - Objetivo (O que exatamente você quer que ela faça)",
                        description = "Defina a ação com um verbo claro. Exemplo: 'Escreva uma mensagem de WhatsApp carinhosa e direta convidando para a reinauguração no novo ponto.'"
                    ),
                    StepItem(
                        stepNumber = 3,
                        title = "R - Regras e Restrições (O que deve e não deve ter)",
                        description = "Estipule limites. Exemplo: 'Máximo de 3 parágrafos curtos, inclua emojis moderados, mencione que haverá um café de boas-vindas e não use palavras excessivamente formais.'"
                    ),
                    StepItem(
                        stepNumber = 4,
                        title = "P - Persona ou Papel (Como a IA deve se comportar)",
                        description = "Dê uma postura à IA. Exemplo: 'Aja como um redator publicitário experiente em marcas de moda acessível e acolhedora.'"
                    )
                )
            ),
            ChapterSection.ExampleCallout(
                title = "Comparação Prática: Fraco vs. C.O.R.P.",
                context = "Situação: Redigir um e-mail cobrando uma resposta de proposta comercial.",
                beforeExample = "Prompt fraco: 'Escreva um e-mail cobrando um cliente.' -> Resultado: Um texto engessado, impessoal ou agressivo.",
                afterExample = "Prompt C.O.R.P.: 'Aja como um consultor comercial cordial. Enviei uma proposta de assessoria financeira há 5 dias para um cliente que demonstrou interesse, mas ainda não tive retorno. Escreva um e-mail de acompanhamento breve (máximo 120 palavras), educado, sem parecer desesperado, perguntando se ele teve tempo de analisar e se ficou alguma dúvida técnica.'",
                takeaway = "Instruções específicas eliminam adivinhações e poupam seu tempo de edição posterior."
            ),
            ChapterSection.TipCallout(
                title = "Dica de Ouro: O diálogo contínuo",
                tip = "Nunca descarte uma resposta na primeira tentativa. Se ficou longa demais, responda: 'Reduza pela metade'. Se ficou muito séria, diga: 'Deixe mais amigável'. Converse com a IA como se estivesse ajustando um trabalho em equipe."
            ),
            ChapterSection.PromptBox(
                title = "Template Universal C.O.R.P.",
                description = "Guarde este modelo base e use para qualquer tarefa:",
                promptText = "[PAPEL]: Você é um especialista em [área desejada].\n[CONTEXTO]: Meu objetivo atual é [explicar o cenário brevemente]. Meu público-alvo são [descrever para quem é].\n[OBJETIVO]: Crie [o formato desejado: texto, plano, lista, tabela] para [meta específica].\n[RESTRIÇÕES]: Mantenha o tom [tom: descontraído/formal], tamanho máximo de [número de palavras/linhas] e evite [o que não quer que apareça].",
                expectedOutcome = "Uma resposta afinada de primeira, sem rodeios desnecessários."
            )
        ),
        summaryPoints = listOf(
            "Não pesquise na IA como no Google; dê instruções completas.",
            "Use o método C.O.R.P.: Contexto, Objetivo, Regras e Papel.",
            "Trate a interação como uma conversa contínua de refinamento.",
            "Definir restrições de tamanho e tom evita textos longos e burocráticos."
        ),
        exercise = ChapterExercise(
            id = "ex_cap2",
            title = "Aplicando o método C.O.R.P.",
            instructions = "Escolha um problema real da sua semana (um e-mail que você está adiando, uma explicação para um colega ou um recado importante) e monte um prompt usando as 4 letras do C.O.R.P.",
            suggestedPrompt = "Você é um mediador de comunicação profissional. Preciso pedir educadamente para o meu colega de equipe entregar a planilha que está com 2 dias de atraso, sem criar atrito. Escreva uma mensagem de Slack de no máximo 4 linhas, amigável mas firme.",
            practicalTask = "Escreva abaixo as 4 linhas do seu prompt personalizado e teste em seguida.",
            reflectionQuestions = listOf(
                "Qual dos 4 elementos (C, O, R ou P) você costumava esquecer?",
                "O resultado gerado economizou quanto tempo de digitação?"
            )
        )
    )

    val chapter3 = Chapter(
        id = 3,
        numberLabel = "Capítulo 3",
        title = "IA para Estudar",
        subtitle = "Transforme a IA no tutor particular mais paciente que você já conheceu",
        estimatedMinutes = 9,
        sections = listOf(
            ChapterSection.Paragraph(
                "Se você já tentou aprender algo novo lendo apostilas densas ou artigos acadêmicos impenetráveis, sabe o quanto isso pode ser desanimador. O cérebro cansa, a atenção se dispersa e muitas vezes você desiste antes de entender o básico."
            ),
            ChapterSection.Paragraph(
                "A inteligência artificial revolucionou o ato de estudar porque ela tem uma característica que nenhum professor humano em uma sala de 40 alunos consegue oferecer: paciência infinita e capacidade de personalização instantânea."
            ),
            ChapterSection.Subheading("As 4 Melhores Estratégias de Estudo com IA"),
            ChapterSection.BulletList(
                intro = "Como usar a IA para aprender o dobro no mesmo tempo:",
                items = listOf(
                    "Técnica Feynman: Peça para a IA explicar o conceito como se você tivesse 10 anos de idade, sem termos técnicos.",
                    "Simulador de Perguntas (Quiz): Peça para a IA fazer perguntas sobre o tema e avaliar suas respostas uma a uma.",
                    "Analogias do Cotidiano: Peça para ela relacionar o assunto difícil com algo que você já domina (ex: futebol, culinária, trânsito).",
                    "Mapa de Conceitos: Solicite uma lista hierárquica do mais simples ao mais avançado para você estudar na ordem certa."
                )
            ),
            ChapterSection.ExampleCallout(
                title = "Exemplo Prático: Desmistificando a Inflação",
                context = "Em vez de ler definições macroeconômicas áridas:",
                beforeExample = "Pergunta comum: 'O que é inflação?' -> Resposta da IA: Um parágrafo técnico sobre liquidez monetária e índice de preços.",
                afterExample = "Pergunta guiada: 'Explique o que é inflação usando uma metáfora simples com figurinhas de álbum na hora do recreio da escola.' -> Resposta: Se você e seus colegas têm poucas figurinhas, 1 figurinha vale um lanche. Se o diretor der 100 figurinhas de graça para cada aluno, ninguém mais aceitará dar um lanche por apenas uma; todos exigirão 10 figurinhas. A figurinha não mudou, mas o excesso delas fez o lanche parecer mais caro.",
                takeaway = "A analogia cria uma imagem mental instantânea que fixa o conceito na memória."
            ),
            ChapterSection.PromptBox(
                title = "Prompt do Professor Socrático",
                description = "Este prompt faz com que a IA não dê a resposta pronta, mas ajude você a pensar:",
                promptText = "Quero aprender sobre [tema que você quer aprender]. Aja como um tutor particular paciente que usa o método socrático. Em vez de me dar um resumo longo, explique o conceito fundamental em 3 frases e depois me faça UMA pergunta para testar se eu compreendi. Aguarde minha resposta antes de avançar.",
                expectedOutcome = "Uma sessão interativa de estudo guiado, passo a passo."
            ),
            ChapterSection.PromptBox(
                title = "Prompt Gerador de Simulado",
                description = "Crie seus próprios testes para concursos, faculdade ou certificações:",
                promptText = "Crie um simulado rápido de 3 questões de múltipla escolha sobre [tema de estudo]. Dificuldade: intermediária. Não mostre o gabarito agora. Aguarde eu responder para depois corrigir e explicar o erro de cada alternativa incorreta.",
                expectedOutcome = "Exercícios sob medida para validar sua retenção do conteúdo."
            ),
            ChapterSection.TipCallout(
                title = "Dica: Transforme áudios e anotações em fichas de estudo",
                tip = "Copie e cole suas anotações desorganizadas da aula ou reunião e peça: 'Organize estas anotações em 5 tópicos principais com marcadores e uma lista de 3 perguntas-chave para revisão'."
            )
        ),
        summaryPoints = listOf(
            "A IA é um tutor paciente que se adapta ao seu ritmo individual de aprendizagem.",
            "Use metáforas e a técnica Feynman para desbloquear assuntos complexos.",
            "O método socrático e os simulados geram aprendizado ativo, muito superior à leitura passiva.",
            "Peça para ela testar seu conhecimento em vez de apenas entregar respostas prontas."
        ),
        exercise = ChapterExercise(
            id = "ex_cap3",
            title = "Aprenda algo difícil em 5 minutos",
            instructions = "Pense em um assunto que você sempre achou confuso (ex: como funciona a nuvem, juros compostos, a tabela periódica ou a teoria da relatividade). Use o prompt do Professor Socrático com ele.",
            suggestedPrompt = "Explique como funciona o conceito de [assunto confuso] usando uma analogia simples do dia a dia, como se eu tivesse 12 anos. Finalize com uma pergunta prática.",
            practicalTask = "Anote a metáfora que a IA usou e avalie se agora o conceito fez sentido para você.",
            reflectionQuestions = listOf(
                "A explicação ficou clara na primeira tentativa?",
                "Como essa abordagem pode ser usada para ajudar seus filhos ou colegas de estudo?"
            )
        )
    )
}
