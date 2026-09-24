package com.example.data.book.content

import com.example.data.model.Chapter
import com.example.data.model.ChapterExercise
import com.example.data.model.ChapterSection
import com.example.data.model.StepItem

object Chapters10to12Content {

    val chapter10 = Chapter(
        id = 10,
        numberLabel = "Capítulo 10",
        title = "Erros Comuns ao Utilizar IA",
        subtitle = "Os 7 tropeços mais frequentes e como escapar de armadilhas bobas",
        estimatedMinutes = 8,
        sections = listOf(
            ChapterSection.Paragraph(
                "Assim como qualquer pessoa que compra uma ferramenta nova e tenta usá-la sem ler o manual básico, a maioria dos usuários de inteligência artificial comete erros previsíveis que levam à frustração precoce. Ao conhecer essas armadilhas de antemão, você economiza semanas de tentativas inúteis."
            ),
            ChapterSection.Subheading("Os 7 Pecados Capitais do Usuário de IA"),
            ChapterSection.BulletList(
                intro = "Evite estes deslizes clássicos:",
                items = listOf(
                    "1. Confiar na primeira resposta sem questionar ou pedir refinamentos.",
                    "2. Fazer pedidos gigantescos em um único comando em vez de dividir por etapas.",
                    "3. Deixar de fornecer contexto e esperar que a IA adivinhe sua intenção.",
                    "4. Copiar e colar respostas diretamente para chefes ou clientes sem ler tudo.",
                    "5. Pedir cálculos matemáticos complexos para modelos de linguagem pura sem checagem.",
                    "6. Tratar a IA como se ela fosse humana, com sentimentos ou opiniões fixas.",
                    "7. Enviar dados confidenciais ou senhas pessoais em ferramentas abertas."
                )
            ),
            ChapterSection.ExampleCallout(
                title = "O Erro do 'Supercomando Tudo-em-Um'",
                context = "Tentar fazer tudo de uma vez costuma gerar respostas rasas:",
                beforeExample = "Supercomando desastroso: 'Escreva um plano de negócios completo de 20 páginas, com projeção financeira, análise de concorrência e estratégias de marketing para uma pizzaria vegana.' (Resultado: Uma resposta de 300 palavras superficial e genérica).",
                afterExample = "Abordagem em etapas: Passo 1: 'Vamos planejar uma pizzaria vegana. Primeiro, liste 5 diferenciais competitivos possíveis no mercado atual.' Passo 2 (após escolher um diferencial): 'Agora vamos estruturar o cardápio principal com base nesse diferencial.'",
                takeaway = "Dividir tarefas grandes em pequenas conversas sequenciais multiplica a profundidade da resposta por dez."
            ),
            ChapterSection.WarningCallout(
                title = "O Risco do 'Piloto Automático'",
                warning = "A responsabilidade final por qualquer documento, e-mail, código ou decisão é sempre sua. Dizer 'foi a IA que errou' não protege sua credibilidade profissional diante de clientes e superiores."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Calibragem e Desafio",
                description = "Peça para a própria IA avaliar se ela tem informações suficientes para responder bem:",
                promptText = "Quero que você me ajude com a seguinte tarefa: [descrever a tarefa]. Antes de começar a escrever a resposta, me faça de 3 a 5 perguntas específicas para entender melhor o meu cenário e entregar o melhor resultado possível.",
                expectedOutcome = "A IA fará perguntas pontuais que revelarão detalhes cruciais que você esqueceu de mencionar."
            ),
            ChapterSection.TipCallout(
                title = "A regra de ouro da revisão",
                tip = "Nunca aperte 'enviar' ou 'publicar' sem ler cada palavra gerada. Se houver alguma frase que faça você franzir a testa em dúvida, reformule-a imediatamente."
            )
        ),
        summaryPoints = listOf(
            "Não aceite a primeira resposta passivamente: refine e ajuste o resultado.",
            "Divida projetos grandes em etapas curtas e progressivas.",
            "Faça a IA perguntar o que ela precisa saber antes de começar.",
            "A assinatura e a responsabilidade pelo que é produzido continuam sendo 100% suas."
        ),
        exercise = ChapterExercise(
            id = "ex_cap10",
            title = "O teste do diálogo em duas etapas",
            instructions = "Pegue um objetivo que você acha complexo e use o 'Prompt de Calibragem e Desafio' acima.",
            suggestedPrompt = "Quero reestruturar a organização da minha equipe de trabalho. Antes de me dar sugestões, faça 3 perguntas sobre nossos maiores gargalos atuais.",
            practicalTask = "Responda às 3 perguntas feitas pela IA e repare na qualidade da solução que ela vai propor em seguida.",
            reflectionQuestions = listOf(
                "As perguntas feitas pela IA ajudaram você a esclarecer seus próprios pensamentos?",
                "A resposta final foi mais customizada do que se você tivesse pedido tudo de uma vez?"
            )
        )
    )

    val chapter11 = Chapter(
        id = 11,
        numberLabel = "Capítulo 11",
        title = "Como Checar Fatos e Evitar Alucinações",
        subtitle = "O manual de sobrevivência contra informações falsas e dados inventados",
        estimatedMinutes = 9,
        sections = listOf(
            ChapterSection.Paragraph(
                "Uma das experiências mais perturbadoras para quem começa a usar IA é descobrir que o robô pode inventar dados inexistentes com a firmeza de um professor doutor. Ele é capaz de citar artigos científicos com autores, datas e páginas que nunca existiram, criar números de leis fictícias ou atribuir frases famosas a pessoas que jamais as pronunciaram."
            ),
            ChapterSection.Paragraph(
                "Isso não acontece porque a IA é \"mentirosa\" por maldade, mas porque sua arquitetura é baseada na verossimilhança estatística: ela gera o texto que parece mais convincente e bem estruturado para responder ao seu pedido, mesmo que a base factual seja nula."
            ),
            ChapterSection.Subheading("O Método dos Três Filtros de Verificação"),
            ChapterSection.StepByStep(
                title = "Como blindar seu trabalho contra erros factuais",
                steps = listOf(
                    StepItem(
                        stepNumber = 1,
                        title = "Filtro da Fonte Primária",
                        description = "Sempre que a IA citar uma lei, estatística ou estudo, vá ao Google e procure a fonte oficial (ex: site do IBGE, Diário Oficial, site da revista científica). Se não encontrar em 2 minutos, desconfie fortemente."
                    ),
                    StepItem(
                        stepNumber = 2,
                        title = "Filtro da Inquisição Reversa",
                        description = "Pergunte diretamente para a IA: 'Você tem certeza factual desse dado? Qual é a fonte exata disso? Se você não tiver certeza absoluta, aponte onde há incerteza'."
                    ),
                    StepItem(
                        stepNumber = 3,
                        title = "Filtro do Contexto Fechado (RAG manual)",
                        description = "Em vez de pedir para a IA buscar na memória dela, copie e cole o texto ou relatório de onde você quer que ela tire a resposta e ordene: 'Responda APENAS com base no texto fornecido'."
                    )
                )
            ),
            ChapterSection.ExampleCallout(
                title = "Exemplo Prático: Como Forçar Respostas Baseadas em Fatos",
                context = "Analisando um contrato de prestação de serviços:",
                beforeExample = "Pergunta aberta e arriscada: 'O que o contrato X diz sobre multa por rescisão?' (Se a IA não tiver o contrato, ela pode inventar uma cláusula típica de 10%).",
                afterExample = "Pergunta com contexto fechado: 'Aqui está o texto integral da Cláusula 7 do contrato: [colar texto]. Com base EXCLUSIVAMENTE nesse parágrafo, qual é a penalidade prevista se o contrato for encerrado nos primeiros 6 meses? Não acrescente nenhuma suposição externa.'",
                takeaway = "Ao alimentar o documento diretamente, o índice de alucinação despenca para quase zero."
            ),
            ChapterSection.PromptBox(
                title = "Prompt do Auditor Implacável de Fatos",
                description = "Submeta seus rascunhos ou respostas a uma checagem rigorosa:",
                promptText = "Analise o texto abaixo com olhar crítico de um checador de fatos profissional. Destaque em tópicos:\n1. Quais afirmações contêm dados, números ou datas que exigem comprovação em fontes externas antes de publicação;\n2. Quais trechos expressam opiniões subjetivas apresentadas como verdades absolutas;\n3. Onde pode haver viés ou generalização apressada.\n\nAqui está o texto:\n\"[cole o texto aqui]\"",
                expectedOutcome = "Uma varredura completa dos pontos frágeis que merecem sua atenção."
            ),
            ChapterSection.TipCallout(
                title = "Para contas, use calculadoras",
                tip = "Nunca confie em cálculos aritméticos longos feitos por modelos puramente textuais. Use a IA para gerar a lógica ou a fórmula, mas deixe a execução matemática para uma planilha ou calculadora."
            )
        ),
        summaryPoints = listOf(
            "Alucinação é a geração de informações plausíveis, mas completamente falsas.",
            "Sempre confira fontes primárias para leis, dados médicos, históricos e numéricos.",
            "O método mais seguro é o do 'contexto fechado': forneça você mesmo o texto de referência.",
            "Use a inquisição reversa para testar a confiança da própria IA sobre a resposta dada."
        ),
        exercise = ChapterExercise(
            id = "ex_cap11",
            title = "Caçando uma alucinação",
            instructions = "Peça para a IA citar 3 livros sobre um assunto muito específico da sua área, incluindo o ano de publicação e a editora. Depois, faça uma busca rápida no Google por um deles para verificar se ele realmente existe com esses dados.",
            suggestedPrompt = "Cite 3 referências bibliográficas em português sobre [seu tema específico] com autor, título e editora.",
            practicalTask = "Confirme se as referências existem de verdade e registre sua constatação abaixo.",
            reflectionQuestions = listOf(
                "Os livros citados são reais ou foram combinações inventadas?",
                "Como essa verificação muda sua relação de confiança com as ferramentas?"
            )
        )
    )

    val chapter12 = Chapter(
        id = 12,
        numberLabel = "Capítulo 12",
        title = "Como Criar Fluxos de Trabalho com IA",
        subtitle = "Conecte etapas isoladas e crie esteiras repetíveis para economizar horas toda semana",
        estimatedMinutes = 10,
        sections = listOf(
            ChapterSection.Paragraph(
                "Usar a inteligência artificial para responder a perguntas avulsas é interessante, mas criar fluxos de trabalho (workflows) estruturados é o que realmente transforma a produtividade de uma pessoa ou empresa. Um fluxo de trabalho nada mais é do que uma receita de bolo repetível onde a saída de uma etapa serve de entrada para a próxima."
            ),
            ChapterSection.Paragraph(
                "Quando você tem um fluxo bem desenhado, uma tarefa que antes exigia cinco horas de desgaste mental pode ser concluída com alta qualidade em 40 minutos."
            ),
            ChapterSection.Subheading("Anatomia de um Fluxo de Trabalho Eficaz"),
            ChapterSection.Paragraph(
                "Todo bom fluxo com IA é dividido em 4 fases sequenciais:"
            ),
            ChapterSection.StepByStep(
                title = "As 4 Fases do Fluxo de Trabalho",
                steps = listOf(
                    StepItem(
                        stepNumber = 1,
                        title = "Coleta e Entrada (Input)",
                        description = "Reunir o material bruto: anotações, links, transcrições de áudios, rascunhos ou dados da semana."
                    ),
                    StepItem(
                        stepNumber = 2,
                        title = "Estruturação e Síntese",
                        description = "Usar a IA para organizar as informações brutas em uma estrutura lógica (esboço, tópicos ou tabela)."
                    ),
                    StepItem(
                        stepNumber = 3,
                        title = "Expansão e Redação",
                        description = "Desenvolver cada parte com prompts específicos, mantendo o tom e as diretrizes do projeto."
                    ),
                    StepItem(
                        stepNumber = 4,
                        title = "Revisão e Formatação Final",
                        description = "Passar pelo crivo humano de clareza, checagem de fatos e formatação para o destino final."
                    )
                )
            ),
            ChapterSection.ExampleCallout(
                title = "Exemplo Prático: Fluxo Semanal de Produção de Newsletter",
                context = "Como produzir uma edição semanal em menos de 1 hora:",
                beforeExample = "Sem fluxo estruturado: Sentar na sexta-feira à tarde sem ideias, caçar links aleatórios, escrever cansado, cometer erros de digitação e gastar 4 horas sofridas.",
                afterExample = "Com fluxo de 4 etapas: Segunda a quinta: Salvar 5 links em um bloco de notas (10 min). Sexta: Passo 1 - IA resume os 5 links em tópicos-chave (5 min). Passo 2 - Você escreve a introdução com sua opinião pessoal (15 min). Passo 3 - IA revisa a coesão geral e gera 3 sugestões de assunto de e-mail (5 min). Passo 4 - Leitura final e envio (10 min).",
                takeaway = "A divisão de papéis clara poupa a mente de alternar entre criar, organizar e revisar ao mesmo tempo."
            ),
            ChapterSection.PromptBox(
                title = "Prompt Arquiteto de Fluxos de Trabalho",
                description = "Peça para a IA desenhar uma esteira sob medida para uma tarefa repetitiva sua:",
                promptText = "Toda semana eu preciso fazer a seguinte tarefa repetitiva: [descrever a tarefa, ex: preparar relatórios de vendas semanais com gráficos e enviar por e-mail para 5 gerentes].\n\nAja como um especialista em design de processos e produtividade. Desenhe um fluxo de trabalho em 4 passos lógicos, indicando exatamente:\n1. O que eu devo preparar;\n2. Onde e qual prompt exato usar na IA em cada etapa;\n3. Onde deve haver validação humana obrigatória;\n4. Quanto tempo estimo gastar em cada etapa.",
                expectedOutcome = "Um manual operacional padrão (SOP) pronto para ser seguido toda semana."
            ),
            ChapterSection.TipCallout(
                title = "Salve seus prompts em um bloco de notas",
                tip = "Crie uma pasta de 'Prompts Favoritos' no seu computador ou no aplicativo de notas do celular. Quando encontrar um comando que funciona perfeitamente, nunca mais digite-o do zero."
            )
        ),
        summaryPoints = listOf(
            "Fluxos de trabalho transformam tarefas isoladas em processos repetíveis e eficientes.",
            "Separe claramente a fase de coleta, de estruturação, de redação e de revisão.",
            "Não alterne entre criar e revisar: faça uma coisa de cada vez.",
            "Documente seus prompts testados em uma biblioteca pessoal de comandos reutilizáveis."
        ),
        exercise = ChapterExercise(
            id = "ex_cap12",
            title = "Desenhando seu primeiro fluxo",
            instructions = "Identifique uma tarefa que você é obrigado a fazer com frequência (semanal ou mensalmente) e use o 'Prompt Arquiteto de Fluxos de Trabalho' para ela.",
            suggestedPrompt = "Desenhe um fluxo de trabalho passo a passo para otimizar minha rotina de [descrever tarefa repetitiva].",
            practicalTask = "Anote as 4 etapas do seu novo fluxo e teste na próxima vez que a tarefa surgir.",
            reflectionQuestions = listOf(
                "Quantas horas por semana esse fluxo pode economizar?",
                "Qual etapa humana exige mais atenção da sua parte?"
            )
        )
    )
}
