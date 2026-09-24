package com.example.data.book.content

import com.example.data.model.Chapter
import com.example.data.model.ChapterExercise
import com.example.data.model.ChapterSection
import com.example.data.model.StepItem

object Chapters4to6Content {

    val chapter4 = Chapter(
        id = 4,
        numberLabel = "Capítulo 4",
        title = "IA para Escrever e Revisar Textos",
        subtitle = "Aprenda a aprimorar sua comunicação sem soar robótico ou artificial",
        estimatedMinutes = 10,
        sections = listOf(
            ChapterSection.Paragraph(
                "O maior perigo de usar IA para escrever é a homogeneização: se todo mundo apertar o mesmo botão com pedidos genéricos, todos os textos da internet soarão iguais — com palavras como \"delve\", \"mergulhar\", \"crucial\", \"no cenário atual\" e adjetivos grandiloquentes que ninguém usa numa conversa real."
            ),
            ChapterSection.Paragraph(
                "A escrita eficiente com inteligência artificial não consiste em terceirizar o pensamento; consiste em usar a máquina como um copiloto editorial. A ideia original e o tom vêm de você; a lapidação, a gramática e a clareza vêm do modelo."
            ),
            ChapterSection.Subheading("O Processo dos 3 Passos para Escrita Autêntica"),
            ChapterSection.StepByStep(
                title = "Como escrever com IA mantendo a sua voz",
                steps = listOf(
                    StepItem(
                        stepNumber = 1,
                        title = "O Rascunho Bruto Humano (Braindump)",
                        description = "Digite suas ideias sem se preocupar com gramática, concordância ou pontuação. Pode ser em tópicos desorganizados, transcrição de áudio ou um fluxo contínuo de pensamento."
                    ),
                    StepItem(
                        stepNumber = 2,
                        title = "A Lapidação com Instrução de Estilo",
                        description = "Peça para a IA organizar o rascunho mantendo as suas opiniões, mas corrigindo a gramática e melhorando o ritmo dos parágrafos."
                    ),
                    StepItem(
                        stepNumber = 3,
                        title = "O Toque Final Humano",
                        description = "Leia o texto em voz alta. Troque palavras que você não usaria normalmente e corte qualquer adjetivo exagerado gerado pelo robô."
                    )
                )
            ),
            ChapterSection.ExampleCallout(
                title = "Exemplo Prático: Antes e Depois da Revisão",
                context = "Uma mensagem interna de atualização de projeto:",
                beforeExample = "Rascunho bagunçado: 'Gente então o cliente atrasou os dados entao nao vai da pra entregar amanha a apresentacao precisamos remarcar pra quinta se todo mundo concordar me avisem'",
                afterExample = "Texto lapidado: 'Olá time! Como o cliente enviou os dados complementares apenas hoje pela manhã, proponho remanejarmos nossa apresentação para quinta-feira às 14h. Assim mantemos o padrão de qualidade da entrega. Todos de acordo?'",
                takeaway = "A IA manteve a mensagem original, mas adicionou clareza, profissionalismo e polidez."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Revisão e Auditoria de Tom",
                description = "Use este prompt para revisar qualquer texto mantendo naturalidade:",
                promptText = "Aja como um revisor editorial experiente. Revise o texto abaixo com três objetivos: 1. Corrigir eventuais deslizes de ortografia e pontuação; 2. Eliminar repetições e enrolações, tornando o texto mais conciso; 3. Manter um tom humano, caloroso e profissional, sem clichês como 'em suma' ou 'no mundo dinâmico de hoje'. Aqui está o texto:\n\n\"[cole seu texto aqui]\"",
                expectedOutcome = "Um texto polido, dinâmico e pronto para envio."
            ),
            ChapterSection.PromptBox(
                title = "Prompt 'Encontre as Fraquezas do Meu Argumento'",
                description = "Peça para a IA bancar o advogado do diabo antes de enviar um relatório importante:",
                promptText = "Leia a proposta/artigo abaixo. Aponte os 3 pontos onde minha argumentação é mais frágil, quais perguntas difíceis um leitor cético me faria e como posso fortalecer essas passagens antes de publicar:\n\n\"[cole seu texto ou proposta]\"",
                expectedOutcome = "Feedback construtivo com visão crítica independente."
            ),
            ChapterSection.TipCallout(
                title = "Corte os clichês da IA",
                tip = "Sempre inclua no seu comando: 'Escreva em português brasileiro coloquial, com frases curtas e diretas. Evite adjetivos rebuscados e fórmulas prontas'."
            )
        ),
        summaryPoints = listOf(
            "Nunca entregue a escrita 100% para a IA; forneça seu rascunho inicial de ideias.",
            "Use a máquina para corrigir gramática, melhorar o ritmo e sugerir sinônimos.",
            "Elimine clichês robóticos lendo o resultado em voz alta.",
            "A IA é excelente para fazer o papel de 'leitor crítico' e apontar falhas na sua argumentação."
        ),
        exercise = ChapterExercise(
            id = "ex_cap4",
            title = "Revitalize um texto antigo",
            instructions = "Pegue um e-mail ou mensagem antiga que você escreveu às pressas e achei confusa. Aplique o prompt de Revisão e Auditoria de Tom.",
            suggestedPrompt = "Revise o seguinte rascunho para que fique 50% mais conciso e com tom agradável e seguro: [coloque o texto aqui]",
            practicalTask = "Compare o tamanho do texto original com a versão nova e marque quanto tempo de leitura foi poupado.",
            reflectionQuestions = listOf(
                "A essência da sua mensagem continuou preservada?",
                "Quais termos você precisou ajustar manualmente para soar como você?"
            )
        )
    )

    val chapter5 = Chapter(
        id = 5,
        numberLabel = "Capítulo 5",
        title = "IA para Organizar Tarefas e Rotinas",
        subtitle = "Do caos mental à execução: como planejar semanas, rotinas e decisões difíceis",
        estimatedMinutes = 8,
        sections = listOf(
            ChapterSection.Paragraph(
                "Muitas vezes, o que nos impede de ser produtivos não é a falta de vontade de trabalhar, mas a chamada \"fadiga de decisão\": acordar de manhã com vinte tarefas misturadas na cabeça e não saber por onde começar. A paralisia diante do caos consome mais energia do que a execução em si."
            ),
            ChapterSection.Paragraph(
                "A inteligência artificial é uma aliada espetacular para organizar o raciocínio porque ela consegue processar uma lista desordenada de pendências e transformá-la em uma sequência lógica, priorizada por urgência, impacto e tempo disponível."
            ),
            ChapterSection.Subheading("O Método do Esvaziamento Mental"),
            ChapterSection.Paragraph(
                "Em vez de tentar organizar suas tarefas mentalmente, jogue todas as pendências da sua semana em uma única mensagem para a IA. Pode misturar tarefas de casa, compromissos de trabalho, compras do supermercado e contas a pagar."
            ),
            ChapterSection.ExampleCallout(
                title = "Exemplo Prático: Organizando uma Segunda-Feira Caótica",
                context = "Você despeja tudo o que precisa fazer:",
                beforeExample = "Lista caótica: 'Preciso levar o cachorro no petshop, pagar o condomínio, fazer a planilha de vendas, ligar pro João pra cobrar o relatório, comprar frutas, fazer academia e responder 40 e-mails acumulados.'",
                afterExample = "Plano estruturado pela IA: Bloco Manhã (Foco e Decisão): 1. Pagar condomínio (5 min); 2. Ligar para o João (10 min); 3. Planilha de vendas (bloco de 90 min de foco). Bloco Almoço: Levar cachorro e comprar frutas. Bloco Tarde: 1h de resposta de e-mails em lote. Noite: Academia como recompensa.",
                takeaway = "A IA converteu ansiedade dispersa em blocos de tempo acionáveis e realistas."
            ),
            ChapterSection.PromptBox(
                title = "Prompt da Matriz de Priorização Diária",
                description = "Transforme suas pendências em um plano de ação:",
                promptText = "Aqui está a lista de tudo que tenho para fazer hoje:\n[cole sua lista de afazeres desordenada]\n\nTenho [X] horas disponíveis no total. Aja como um especialista em produtividade e organize essa lista em 3 blocos: 1. 'Essencial e inegociável' (fazer primeiro); 2. 'Importante com bloco de tempo definido'; 3. 'Rápido (menos de 5 minutos cada)'. Distribua tudo em uma grade de horários sugerida.",
                expectedOutcome = "Um cronograma equilibrado com pausas e foco nas prioridades reais."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Resolução de Dilemas e Decisões",
                description = "Quando você estiver em dúvida entre duas ou mais opções:",
                promptText = "Estou indeciso entre [Opção A] e [Opção B]. Meu objetivo principal é [descrever meta] e minha principal preocupação é [descrever receio]. Crie uma tabela comparativa com: Prós, Contras, Custo de oportunidade e Risco de cada opção. No final, elabore 3 perguntas de reflexão que vão me ajudar a bater o martelo com clareza.",
                expectedOutcome = "Uma análise neutra e racional para destravar sua tomada de decisão."
            ),
            ChapterSection.TipCallout(
                title = "Não planeje dias perfeitos demais",
                tip = "Sempre inclua no prompt uma margem para imprevistos: 'Considere que terei 20% do meu tempo reservado para imprevistos e urgências não planejadas'."
            )
        ),
        summaryPoints = listOf(
            "Use a IA para fazer o 'esvaziamento mental' das pendências acumuladas.",
            "Ela estrutura listas caóticas em blocos de tempo priorizados por impacto.",
            "Tabelas comparativas de prós e contras aceleram decisões sem viés emocional.",
            "Deixe margem para imprevistos no cronograma gerado."
        ),
        exercise = ChapterExercise(
            id = "ex_cap5",
            title = "Planejando as próximas 24 horas",
            instructions = "Liste de 5 a 10 coisas que estão pesando na sua cabeça neste momento e passe pelo prompt da Matriz de Priorização Diária.",
            suggestedPrompt = "Tenho 6 horas úteis de trabalho e preciso fazer: [listar tarefas]. Organize por ordem lógica de execução matutina e vespertina.",
            practicalTask = "Anote a primeira tarefa que você vai executar hoje e cumpra-a antes de continuar a leitura.",
            reflectionQuestions = listOf(
                "A ordem sugerida aliviou a sensação de sobrecarga?",
                "Qual tarefa da lista poderia ter sido delegada ou eliminada?"
            )
        )
    )

    val chapter6 = Chapter(
        id = 6,
        numberLabel = "Capítulo 6",
        title = "IA para Pesquisar e Aprender Novos Assuntos",
        subtitle = "Como encontrar respostas aprofundadas sem se afogar em links irrelevantes",
        estimatedMinutes = 9,
        sections = listOf(
            ChapterSection.Paragraph(
                "Pesquisar na internet moderna tornou-se uma maratona de obstáculos. Você digita uma dúvida simples e precisa desviar de cinco anúncios patrocinados, três banners piscando, vídeos em reprodução automática e artigos cheios de introduções repetitivas escritos apenas para agradar aos robôs de busca."
            ),
            ChapterSection.Paragraph(
                "A inteligência artificial devolve à pesquisa a sua essência mais agradável: a conversa direta com uma fonte de síntese. Você pode fazer perguntas complexas, pedir comparações imediatas e solicitar explicações sob medida."
            ),
            ChapterSection.Subheading("Como Fazer Perguntas de Pesquisa Inteligentes"),
            ChapterSection.BulletList(
                intro = "Os quatro mandamentos da pesquisa com IA:",
                items = listOf(
                    "Seja específico quanto à finalidade: 'Preciso escolher uma furadeira para uso doméstico esporádico' é muito melhor do que 'Qual a melhor furadeira?'.",
                    "Peça prós e contras balanceados para evitar visões unilaterais.",
                    "Peça fontes de consulta e critérios de decisão, para você mesmo poder conferir os pontos cruciais.",
                    "Peça para ela comparar dois conceitos lado a lado em uma tabela explicativa."
                )
            ),
            ChapterSection.ExampleCallout(
                title = "Exemplo Prático: Pesquisa de Compra Consciente",
                context = "Comprando um fone de ouvido para reuniões e academia:",
                beforeExample = "Busca tradicional no Google: 'melhores fones bluetooth 2026' -> 20 páginas de listas de afiliados cheias de jargões técnicos sem contexto.",
                afterExample = "Pesquisa com IA: 'Quero comprar um fone sem fio até R$ 250. Meu foco principal é conforto para 4 horas diárias de reuniões e resistência a suor para caminhadas leves. Não me importo com graves potentes. Quais são os 3 modelos mais recomendados no mercado brasileiro e quais são os pontos negativos de cada um?'",
                takeaway = "Você recebe um resumo direto, com os pontos fracos que as propagandas tentam esconder."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Síntese de Livro ou Tema Denso",
                description = "Extraia as principais teses práticas de qualquer tema ou obra clássica:",
                promptText = "Apresente um resumo executivo sobre as ideias centrais de [Nome do livro ou Assunto]. Estruture em:\n1. A tese principal em 2 frases;\n2. Os 3 conceitos mais valiosos e práticos;\n3. Como aplicar isso hoje em uma rotina comum;\n4. Uma crítica comum ou limitação dessa teoria.",
                expectedOutcome = "Um panorama completo, equilibrado e direto ao ponto."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Decodificação de Textos Jurídicos ou Burocráticos",
                description = "Traduza 'juridiquês' e manuais incompreensíveis para o português claro:",
                promptText = "Traduza o seguinte trecho de contrato/comunicado oficial para uma linguagem simples e direta, como se estivesse explicando para uma pessoa leiga:\n- O que isso significa na prática?\n- Quais são minhas obrigações?\n- Quais são meus riscos ou prazos?\n\n\"[cole o trecho burocrático aqui]\"",
                expectedOutcome = "Clareza absoluta sobre direitos, deveres e prazos."
            ),
            ChapterSection.WarningCallout(
                title = "Atenção ao corte temporal das ferramentas",
                warning = "Lembre-se de que alguns modelos possuem datas de corte de treinamento ou dependem de acesso à web para saber eventos recentes. Para notícias de última hora, preços em tempo real ou cotações do dia, utilize modelos com busca em tempo real ativada ou confira em fontes diretas."
            )
        ),
        summaryPoints = listOf(
            "A IA resume e compara informações poupando você de páginas infestadas de anúncios.",
            "Defina seu perfil e limites de orçamento ao fazer pesquisas de produtos ou serviços.",
            "Use prompts estruturados para decifrar contratos, regras e termos técnicos.",
            "Sempre verifique informações de última hora que dependem de acontecimentos recentes."
        ),
        exercise = ChapterExercise(
            id = "ex_cap6",
            title = "Decifrando uma dúvida antiga",
            instructions = "Escolha um tema sobre o qual você sempre teve curiosidade, mas nunca teve paciência para ler páginas inteiras (ex: como funciona a previdência privada, por que o céu é azul, o que é computação quântica).",
            suggestedPrompt = "Explique [seu tema] em 4 tópicos fáceis, usando analogias simples, e termine com uma curiosidade fascinante pouco conhecida.",
            practicalTask = "Cole a resposta gerada e marque qual curiosidade você achou mais surpreendente.",
            reflectionQuestions = listOf(
                "O tempo para entender o tema foi menor que uma busca convencional?",
                "Ficou alguma dúvida que você gostaria de aprofundar?"
            )
        )
    )
}
