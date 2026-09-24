package com.example.data.book.content

import com.example.data.model.Chapter
import com.example.data.model.ChapterExercise
import com.example.data.model.ChapterSection
import com.example.data.model.StepItem

object Chapters7to9Content {

    val chapter7 = Chapter(
        id = 7,
        numberLabel = "Capítulo 7",
        title = "IA no Trabalho",
        subtitle = "Automação prática de relatórios, atas de reunião e comunicação profissional",
        estimatedMinutes = 10,
        sections = listOf(
            ChapterSection.Paragraph(
                "O local de trabalho moderno está repleto de tarefas que consomem horas preciosas mas agregam pouquíssimo valor cognitivo: transformar anotações rabiscadas em atas formais, resumir conversas intermináveis em tópicos acionáveis, criar apresentações do zero e responder dezenas de mensagens burocráticas."
            ),
            ChapterSection.Paragraph(
                "Profissionais que aprendem a usar a IA como uma extensão de suas habilidades conseguem cumprir essas etapas em uma fração do tempo, liberando horas do dia para o que realmente importa: relacionamento interpessoal, pensamento estratégico e tomada de decisões."
            ),
            ChapterSection.Subheading("Transformando Reuniões em Planos de Ação"),
            ChapterSection.Paragraph(
                "Um dos maiores buracos negros de produtividade em qualquer empresa são as atas de reunião. Quase ninguém quer fazê-las e quase ninguém lê quando ficam longas demais. Com a IA, você pode colar suas anotações brutas e obter uma ata impecável em 10 segundos."
            ),
            ChapterSection.ExampleCallout(
                title = "Exemplo Prático: Da Reunião Caótica ao Alinhamento",
                context = "Transformando anotações rápidas de uma reunião de projeto:",
                beforeExample = "Notas brutas: 'reuniao projeto x, juliana falou q o prazo do design vai ate dia 12, marcos precisa fechar orcamento com fornecedor ate sexta, cliente pediu pra tirar a cor verde do logo, proxima reuniao terca 10h'",
                afterExample = "Ata Executiva: 'Ata da Reunião - Projeto X\n\nDecisões:\n• Identidade Visual: Removida a cor verde da proposta de logotipo a pedido do cliente.\n\nPróximas Entregas (Responsável e Prazo):\n1. Marcos: Fechamento do orçamento com fornecedor (Prazo: Sexta-feira)\n2. Juliana: Conclusão das telas de design (Prazo: 12/Mês)\n\nPróximo Alinhamento: Terça-feira, às 10h00.'",
                takeaway = "Informações claras evitam desencontros e garantem que todos saibam exatamente o que fazer."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Resumo Executivo para a Diretoria",
                description = "Transforme dados dispersos em um relatório conciso de uma página:",
                promptText = "Você é um assessor de comunicação corporativa. A partir dos dados e notas abaixo, elabore um resumo executivo para ser lido em 2 minutos pela diretoria:\n\n[cole seus números, notas ou acontecimentos]\n\nEstruture em:\n1. Destaques principais (o que deu certo);\n2. Pontos de atenção / gargalos identificados;\n3. Ações recomendadas e próximos passos.",
                expectedOutcome = "Um relatório limpo, profissional e com foco em decisões."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Fórmulas e Automação de Planilhas",
                description = "Quando você não souber qual fórmula do Excel ou Google Sheets usar:",
                promptText = "Estou no [Excel / Google Sheets] e tenho uma tabela onde a coluna A tem o [nome do cliente], a coluna B tem a [data da compra] e a coluna C tem o [valor]. Preciso de uma fórmula que calcule a soma apenas das compras feitas em março com valor acima de R$ 500. Escreva a fórmula exata em português e explique passo a passo como colar na minha planilha.",
                expectedOutcome = "A fórmula pronta (ex: SOMASE/SOMASES) com explicação didática de cada argumento."
            ),
            ChapterSection.TipCallout(
                title = "Privacidade e Segurança no Trabalho",
                tip = "NUNCA cole em ferramentas públicas de IA dados confidenciais da sua empresa, senhas, códigos de clientes ou informações financeiras sigilosas. Anonimize sempre: troque 'João da Silva Silva CPF 123' por 'Cliente A'."
            )
        ),
        summaryPoints = listOf(
            "Use a IA para transformar anotações rápidas em atas executivas com responsáveis e prazos.",
            "Gere fórmulas de planilhas complexas apenas descrevendo o que você precisa em português.",
            "Elabore resumos executivos focados em decisões para lideranças e clientes.",
            "Proteja dados confidenciais: sempre anonimize informações corporativas sensíveis."
        ),
        exercise = ChapterExercise(
            id = "ex_cap7",
            title = "Automatize sua próxima ata",
            instructions = "Pegue um rascunho de conversa ou reunião recente da sua rotina e use o prompt do Resumo Executivo para gerar uma ata limpa.",
            suggestedPrompt = "Transforme este rascunho de conversa em uma ata com 3 tópicos: O que foi decidido, Quem faz o quê, e Próximo prazo: [colar notas]",
            practicalTask = "Envie a versão estruturada para seus colegas ou salve em sua pasta de trabalho.",
            reflectionQuestions = listOf(
                "A clareza melhorou em comparação com a sua forma habitual de anotar?",
                "Quanto tempo você estima que economizou?"
            )
        )
    )

    val chapter8 = Chapter(
        id = 8,
        numberLabel = "Capítulo 8",
        title = "IA para Pequenos Negócios",
        subtitle = "Atendimento ágil, propostas comerciais e estratégias de vendas sem custos extras",
        estimatedMinutes = 9,
        sections = listOf(
            ChapterSection.Paragraph(
                "Quem gerencia um pequeno negócio, um consultório ou trabalha como autônomo vive com uma sobrecarga crônica. Não há departamentos separados para marketing, atendimento ao cliente, cobrança e pós-venda. O dono ou profissional autônomo costuma fazer tudo sozinho, muitas vezes até tarde da noite."
            ),
            ChapterSection.Paragraph(
                "A inteligência artificial funciona para o pequeno empresário como uma equipe de apoio acessível e disponível 24 horas por dia. Ela pode criar mensagens de atendimento padronizadas para o WhatsApp, redigir propostas comerciais atraentes e até sugerir estratégias de promoção para períodos de baixo movimento."
            ),
            ChapterSection.Subheading("O Atendimento que Vende sem Ser Chato"),
            ChapterSection.Paragraph(
                "Clientes querem respostas rápidas, claras e amigáveis. Criar um cardápio de respostas prontas para as dúvidas mais frequentes economiza horas no balcão e no WhatsApp."
            ),
            ChapterSection.ExampleCallout(
                title = "Exemplo Prático: Lidando com Objeção de Preço",
                context = "Quando o cliente diz: 'Achei caro, no concorrente tá mais barato':",
                beforeExample = "Resposta reativa do comerciante: 'Mas o concorrente usa material ruim, o nosso tem mais qualidade por isso é esse preço.'",
                afterExample = "Resposta profissional lapidada: 'Entendo perfeitamente, [Nome]! O preço realmente é um fator importante. O nosso trabalho inclui garantia estendida de 1 ano com troca imediata no balcão e peças originais certificadas, o que evita que você tenha dores de cabeça depois. Que tal fecharmos com a primeira manutenção gratuita de cortesia para você testar com total tranquilidade?'",
                takeaway = "A resposta valoriza o cliente, reforça o diferencial do seu serviço e oferece um incentivo amigável sem desvalorizar seu trabalho."
            ),
            ChapterSection.PromptBox(
                title = "Prompt do Gerador de Scripts de Atendimento (FAQ)",
                description = "Crie respostas padronizadas e acolhedoras para o seu WhatsApp Business:",
                promptText = "Sou dono de um [tipo de negócio: ex: pet shop, oficina, estúdio de pilates]. Aqui estão as 4 dúvidas que meus clientes mais mandam no WhatsApp:\n1. [Dúvida 1: ex: Preço do serviço básico]\n2. [Dúvida 2: ex: Tempo de entrega]\n3. [Dúvida 3: ex: Formas de pagamento]\n4. [Dúvida 4: ex: Política de cancelamento]\n\nEscreva uma resposta modelo para cada uma, em tom acolhedor, profissional e ágil, pronta para ser salva nas respostas rápidas do WhatsApp.",
                expectedOutcome = "Scripts polidos e simpáticos que aumentam a conversão de clientes."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Criação de Proposta Comercial Irrecusável",
                description = "Transforme um orçamento frio em uma proposta de valor envolvente:",
                promptText = "Aja como um consultor sênior de vendas. Preciso enviar uma proposta de prestação de serviços para um cliente em potencial. As informações são:\n- Serviço: [descrever o serviço]\n- Benefício direto para o cliente: [ex: economizar tempo, aumentar vendas, ter paz de espírito]\n- Valor do investimento: [R$ X]\n- Prazo de entrega: [X dias]\n\nEscreva uma proposta em formato de e-mail/PDF concisa (1 página), que comece identificando o problema do cliente, apresente nossa solução de forma clara e termine com uma chamada para ação simples.",
                expectedOutcome = "Uma proposta convincente e altamente profissional."
            ),
            ChapterSection.TipCallout(
                title = "Teste de Ofertas para Dias Fracos",
                tip = "Pergunte à IA: 'Tenho uma cafeteria e o movimento nas terças-feiras é 40% menor que o habitual. Dê 3 ideias criativas de promoções de baixo custo para atrair o público do entorno nas terças'."
            )
        ),
        summaryPoints = listOf(
            "A IA nivela o jogo para autônomos e pequenos negócios sem custo extra.",
            "Crie scripts empáticos para contornar objeções de preço e dúvidas frequentes no WhatsApp.",
            "Transforme orçamentos técnicos em propostas focadas na resolução de problemas do cliente.",
            "Use a IA para fazer tempestade de ideias de promoções para dias ou épocas de baixo movimento."
        ),
        exercise = ChapterExercise(
            id = "ex_cap8",
            title = "Crie sua melhor resposta de atendimento",
            instructions = "Identifique a pergunta que você mais tem preguiça ou dificuldade de responder no seu trabalho diário com clientes e passe-a pelo prompt do Gerador de Scripts.",
            suggestedPrompt = "Como responder de forma educada e segura para um cliente que pede desconto exagerado em [meu serviço], explicando nosso valor agregado?",
            practicalTask = "Salve a resposta refinada nas notas do seu celular ou atalho de teclado.",
            reflectionQuestions = listOf(
                "A resposta soa profissional sem parecer fria?",
                "Essa resposta pode ser usada pelo restante da sua equipe?"
            )
        )
    )

    val chapter9 = Chapter(
        id = 9,
        numberLabel = "Capítulo 9",
        title = "IA para Criação de Conteúdo",
        subtitle = "Como ter ideias infinitas e produzir para redes sociais sem bloqueio criativo",
        estimatedMinutes = 10,
        sections = listOf(
            ChapterSection.Paragraph(
                "O bloqueio criativo é o maior inimigo de quem precisa manter presença digital — seja para divulgar a própria marca, atrair clientes ou construir autoridade profissional. Ficar olhando para a folha em branco na segunda-feira sem saber o que postar drena a energia de qualquer produtor."
            ),
            ChapterSection.Paragraph(
                "A inteligência artificial é uma geradora inesgotável de ângulos, ideias e formatos. Ela não substitui a sua experiência de vida e nem suas histórias reais, mas elimina por completo o trauma do ponto de partida."
            ),
            ChapterSection.Subheading("O Funil de Conteúdo em 3 Fases"),
            ChapterSection.StepByStep(
                title = "Da Ideia Bruta à Publicação com IA",
                steps = listOf(
                    StepItem(
                        stepNumber = 1,
                        title = "Geração de Ângulos Diferentes",
                        description = "Peça 10 ideias de abordagem para um mesmo assunto básico. Escolha a que mais tem a ver com você."
                    ),
                    StepItem(
                        stepNumber = 2,
                        title = "Estrutura do Gancho (Hook)",
                        description = "A primeira linha do post decide se o leitor vai continuar ou rolar o feed. Use a IA para testar 5 ganchos atraentes e honestos."
                    ),
                    StepItem(
                        stepNumber = 3,
                        title = "Adaptação de Formato",
                        description = "Transforme um texto de sucesso em carrossel, roteiro de vídeo curto (Reels/TikTok) ou newsletter semanal."
                    )
                )
            ),
            ChapterSection.ExampleCallout(
                title = "Exemplo Prático: Um Gancho Fraco vs. Um Gancho Irresistível",
                context = "Post sobre planejamento financeiro familiar:",
                beforeExample = "Gancho fraco: 'Hoje vamos falar sobre a importância de guardar dinheiro todos os meses.' (Quase todo mundo passa reto).",
                afterExample = "Gancho magnético: 'O erro de R$ 300 que quase toda família comete sem perceber todo começo de mês — e como estancar essa sangria hoje mesmo.'",
                takeaway = "Ganchos eficazes despertam curiosidade genuína sem apelar para clickbait mentiroso."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Calendário Editorial Mensal",
                description = "Gere 4 semanas de temas práticos para seu perfil ou negócio:",
                promptText = "Você é um estrategista de conteúdo para redes sociais. Meu nicho é [descrever o nicho: ex: fisioterapia postural, marcenaria artesanal, confeitaria vegana]. Meu público são [descrever o público].\n\nCrie uma grade de 12 temas de posts divididos em 3 pilares:\n1. Pilar Educativo (ensinar algo prático que resolve uma dor);\n2. Pilar de Quebra de Mitos (desmistificar erros comuns do mercado);\n3. Pilar de Conexão/Bastidores (histórias reais e confiança).\n\nPara cada tema, dê o título do post e a ideia central em uma frase.",
                expectedOutcome = "Um mês inteiro de ideias organizadas e variadas."
            ),
            ChapterSection.PromptBox(
                title = "Prompt de Roteiro de Vídeo Curto de 45 Segundos",
                description = "Crie roteiros dinâmicos para gravar no celular com facilidade:",
                promptText = "Crie um roteiro de vídeo de 45 segundos para [Instagram Reels / TikTok / YouTube Shorts] sobre o tema [assunto]. Estruture com:\n- [0 a 5 seg]: Gancho visual e primeira frase impactante;\n- [5 a 30 seg]: Conteúdo direto em 3 passos fáceis de entender;\n- [30 a 45 seg]: Chamada para ação final convidando para comentar ou salvar o vídeo.",
                expectedOutcome = "Roteiro cronometrado pronto para ser lido ou gravado."
            ),
            ChapterSection.TipCallout(
                title = "Humanize o conteúdo final",
                tip = "Acrescente sempre uma história pessoal ou caso real que aconteceu com você no início ou meio do post. A IA cria a estrutura; a sua experiência cria a conexão emocional."
            )
        ),
        summaryPoints = listOf(
            "A IA resolve o bloqueio da folha em branco fornecendo dezenas de ângulos para o mesmo tema.",
            "Dedique atenção especial aos ganchos: as primeiras palavras determinam o sucesso do conteúdo.",
            "Reaproveite o mesmo conteúdo em múltiplos formatos: texto, carrossel, roteiro de vídeo e e-mail.",
            "Nunca publique textos puramente robóticos; adicione sempre uma pitada da sua experiência pessoal."
        ),
        exercise = ChapterExercise(
            id = "ex_cap9",
            title = "Crie seu primeiro carrossel ou vídeo",
            instructions = "Escolha um conselho que você dá com frequência para amigos ou clientes e transforme-o em um roteiro de 45 segundos com o prompt acima.",
            suggestedPrompt = "Gere 3 ganchos magnéticos para um post sobre [o conselho que você costuma dar].",
            practicalTask = "Escolha o melhor gancho e grave um áudio ou escreva o post para conferir a naturalidade.",
            reflectionQuestions = listOf(
                "O gancho despertou a sua própria curiosidade?",
                "Qual formato (vídeo, carrossel ou texto simples) faz mais sentido para o seu estilo?"
            )
        )
    )
}
