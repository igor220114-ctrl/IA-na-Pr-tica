package com.example.data.book.content

import com.example.data.model.AboutAuthor
import com.example.data.model.ChecklistItem
import com.example.data.model.GlossaryItem
import com.example.data.model.PromptItem

object BookAppendicesContent {

    val promptVault = listOf(
        // Categoria: Estudos
        PromptItem(
            id = "p_estudos_1",
            category = "Estudos",
            title = "Explicador com a Técnica Feynman",
            prompt = "Explique o conceito de [inserir conceito difícil] como se estivesse explicando para uma criança inteligente de 10 anos. Use uma analogia tirada de brincadeiras infantis ou da vida na escola, sem nenhum jargão técnico.",
            explanation = "Perfeito para destravar matérias que você acha complicadas de entender à primeira vista.",
            tags = listOf("feynman", "didática", "iniciante")
        ),
        PromptItem(
            id = "p_estudos_2",
            category = "Estudos",
            title = "Simulador de Prova e Concurso",
            prompt = "Aja como uma banca examinadora rigorosa. Crie 4 questões de múltipla escolha com 4 alternativas cada sobre o tema [assunto da prova]. Não mostre o gabarito agora. Aguarde eu responder para depois corrigir e explicar por que a alternativa correta é a certa.",
            explanation = "Ideal para fixar conteúdo antes de vestibulares, concursos ou exames profissionais.",
            tags = listOf("quiz", "simulado", "revisão")
        ),
        PromptItem(
            id = "p_estudos_3",
            category = "Estudos",
            title = "Cronograma de Estudos Progressivo",
            prompt = "Tenho [número de semanas/dias] para estudar para a prova de [matéria/concurso]. Tenho disponíveis [X] horas por dia. Crie um cronograma de estudos diário equilibrado, incluindo blocos de teoria, resolução de questões e revisões espaçadas periódicas.",
            explanation = "Organiza seu tempo de estudo de forma realista, evitando sobrecarga na véspera da prova.",
            tags = listOf("planejamento", "cronograma", "foco")
        ),

        // Categoria: Redação e Escrita
        PromptItem(
            id = "p_escrita_1",
            category = "Redação",
            title = "Revisor de Estilo Natural e Conciso",
            prompt = "Aja como um editor de revista conceituada. Revise o rascunho abaixo cortando 30% do tamanho sem perder nenhuma ideia principal. Mantenha o tom em português brasileiro acolhedor, fluido e elegante, eliminando qualquer clichê como 'no cenário atual' ou 'vale ressaltar'. Rascunho:\n\"[inserir rascunho]\"",
            explanation = "Deixa qualquer texto mais atraente, ágil e fácil de ler.",
            tags = listOf("revisão", "estilo", "clareza")
        ),
        PromptItem(
            id = "p_escrita_2",
            category = "Redação",
            title = "Adaptador de Tom (Formal para Coloquial)",
            prompt = "Reescreva a seguinte mensagem técnica/formal em uma linguagem coloquial e leve para envio no WhatsApp ou e-mail informal, garantindo que o leitor sinta simpatia e entenda tudo sem esforço:\n\"[inserir mensagem]\"",
            explanation = "Excelente para aproximar comunicados difíceis de clientes ou amigos.",
            tags = listOf("adaptação", "tom", "whatsapp")
        ),
        PromptItem(
            id = "p_escrita_3",
            category = "Redação",
            title = "Detector de Falhas e Argumentação Fraca",
            prompt = "Leia o texto opinativo ou proposta comercial abaixo com olhar cético de quem quer encontrar furos de argumentação. Aponte os 3 pontos mais frágeis e como posso reforçar minha tese com exemplos concretos antes de publicar:\n\"[inserir texto]\"",
            explanation = "Ajuda você a antecipar objeções antes de apresentar uma proposta ou relatório.",
            tags = listOf("crítica", "argumentação", "qualidade")
        ),

        // Categoria: Trabalho e Produtividade
        PromptItem(
            id = "p_trab_1",
            category = "Trabalho",
            title = "Ata Executiva Instantânea",
            prompt = "Aqui estão minhas notas desorganizadas da reunião de hoje: [colar notas]. Crie uma ata executiva estruturada em: 1. Principais decisões tomadas; 2. Próximas ações com responsável e prazo estimado; 3. Data e pauta do próximo encontro.",
            explanation = "Economiza 30 minutos após cada reunião de trabalho.",
            tags = listOf("ata", "reunião", "executivo")
        ),
        PromptItem(
            id = "p_trab_2",
            category = "Trabalho",
            title = "Assistente de E-mail Delicado e Firme",
            prompt = "Preciso responder ao e-mail abaixo dizendo NÃO para um pedido sem fechar as portas para futuros projetos. O tom deve ser extremamente cordial, grato pelo contato, mas transparente sobre a indisponibilidade atual. E-mail recebido:\n\"[inserir e-mail]\"",
            explanation = "Permite dizer 'não' com elegância e sem criar atritos desnecessários.",
            tags = listOf("e-mail", "diplomacia", "limites")
        ),
        PromptItem(
            id = "p_trab_3",
            category = "Trabalho",
            title = "Gerador de Fórmulas de Planilha",
            prompt = "Estou usando [Excel / Google Sheets]. Preciso de uma fórmula para: [descrever em português simples o que você quer calcular, ex: somar valores da coluna C se a coluna B for 'Aprovado' e a coluna D for deste mês]. Escreva a fórmula pronta em português e explique a lógica.",
            explanation = "Resolve dúvidas de Excel em segundos sem precisar navegar em fóruns antigos.",
            tags = listOf("excel", "fórmulas", "planilhas")
        ),

        // Categoria: Pequenos Negócios
        PromptItem(
            id = "p_neg_1",
            category = "Negócios",
            title = "Contorno Elegante de Objeção de Preço",
            prompt = "Um cliente potencial disse que achou o preço do meu serviço de [descrever serviço] alto demais em comparação ao concorrente. Escreva uma resposta de WhatsApp acolhedora, que não desvalorize meu trabalho, mostre nosso valor agregado (garantia, agilidade, atendimento personalizado) e proponha um próximo passo sem parecer desesperado.",
            explanation = "Aumenta suas chances de fechar vendas sem dar descontos que comprometam a margem.",
            tags = listOf("vendas", "preço", "whatsapp")
        ),
        PromptItem(
            id = "p_neg_2",
            category = "Negócios",
            title = "Proposta Comercial de 1 Página",
            prompt = "Escreva uma proposta comercial em formato de carta executiva para o serviço de [serviço] com investimento de [valor] e prazo de [dias]. Comece citando a dor atual do cliente [descrever problema do cliente] e como nossa solução gera economia ou retorno rápido.",
            explanation = "Estrutura propostas limpas, profissionais e persuasivas.",
            tags = listOf("proposta", "comercial", "orçamento")
        ),

        // Categoria: Criação de Conteúdo
        PromptItem(
            id = "p_cont_1",
            category = "Conteúdo",
            title = "10 Ganchos Magnéticos para Redes Sociais",
            prompt = "Vou gravar um vídeo curto (Reels/TikTok) sobre [tema do post]. Crie 5 opções de ganchos (primeira frase falada nos primeiros 3 segundos) usando curiosidade honesta, que façam a pessoa parar de rolar o feed imediatamente. Evite sensacionalismo barato.",
            explanation = "Aumenta drasticamente a taxa de retenção dos seus vídeos nas redes sociais.",
            tags = listOf("ganchos", "reels", "vídeo")
        ),
        PromptItem(
            id = "p_cont_2",
            category = "Conteúdo",
            title = "Carrossel Educativo em 5 Telas",
            prompt = "Crie a estrutura de um carrossel educativo para o Instagram de 5 lâminas sobre [assunto]. Para cada lâmina, dê: 1. Texto de título da imagem; 2. Texto de apoio (máximo 20 palavras); 3. Sugestão visual do que mostrar na tela.",
            explanation = "Ideal para produzir posts de alto salvamento e compartilhamento.",
            tags = listOf("carrossel", "instagram", "design")
        )
    )

    val glossary = listOf(
        GlossaryItem(
            term = "Prompt",
            simpleDefinition = "A instrução textual ou pergunta que você digita para a inteligência artificial responder ou executar uma tarefa.",
            practicalExample = "\"Aja como um professor e resuma este texto em 3 tópicos\" é um prompt."
        ),
        GlossaryItem(
            term = "LLM (Large Language Model)",
            simpleDefinition = "Grande Modelo de Linguagem. É o motor estatístico treinado com bilhões de textos que alimenta ferramentas como Gemini, Claude e ChatGPT.",
            practicalExample = "O Gemini é um LLM capaz de compreender e produzir linguagem natural humana."
        ),
        GlossaryItem(
            term = "Alucinação (Hallucination)",
            simpleDefinition = "Quando a IA inventa informações falsas, datas inexistentes ou leis fictícias com aparência de verdade irrefutável.",
            practicalExample = "A IA citar um livro inexistente com título e autor inventados ao ser pressionada por referências."
        ),
        GlossaryItem(
            term = "Janela de Contexto (Context Window)",
            simpleDefinition = "A quantidade máxima de texto (medida em tokens ou palavras) que a IA consegue 'lembrar' e considerar de uma só vez em uma conversa.",
            practicalExample = "Modelos com grandes janelas de contexto conseguem ler livros inteiros ou relatórios de 300 páginas de uma única vez."
        ),
        GlossaryItem(
            term = "Engenharia de Prompt",
            simpleDefinition = "A habilidade prática de estruturar comandos claros, com contexto, regras e exemplos, para obter as melhores respostas possíveis da IA.",
            practicalExample = "Usar o método C.O.R.P. (Contexto, Objetivo, Regras, Persona) em vez de frases soltas."
        ),
        GlossaryItem(
            term = "RAG (Retrieval-Augmented Generation)",
            simpleDefinition = "Técnica em que a IA busca informações em documentos específicos fornecidos pelo usuário antes de formular a resposta, reduzindo alucinações.",
            practicalExample = "Fazer upload do PDF do estatuto da sua empresa e pedir para a IA responder dúvidas apenas com base nele."
        ),
        GlossaryItem(
            term = "Agente de IA",
            simpleDefinition = "Um sistema de inteligência artificial capaz de tomar decisões autônomas, usar ferramentas externas (pesquisar na web, rodar código) e cumprir tarefas complexas de múltiplos passos.",
            practicalExample = "Um assistente que lê seu e-mail, consulta sua agenda e sugere os melhores horários de reunião automaticamente."
        ),
        GlossaryItem(
            term = "Token",
            simpleDefinition = "A unidade básica de texto que a IA processa. Em português, 1 palavra comum costuma equivaler a cerca de 1 a 2 tokens.",
            practicalExample = "Os limites de uso e cobrança de serviços de IA costumam ser calculados pelo número de tokens processados."
        )
    )

    val checklist = listOf(
        ChecklistItem(
            id = "chk_1",
            stepOrder = 1,
            title = "Definir o Contexto e a Persona",
            description = "Antes de enviar o pedido, explique quem é você, para quem é o trabalho e qual papel a IA deve assumir.",
            whyItMatters = "Elimina 80% das respostas genéricas e fora de tom."
        ),
        ChecklistItem(
            id = "chk_2",
            stepOrder = 2,
            title = "Estipular Limites de Formato e Tamanho",
            description = "Especifique o tamanho máximo (palavras, parágrafos) e o formato exato (tópicos, tabela, e-mail).",
            whyItMatters = "Evita textos longos e burocráticos que você teria que resumir depois."
        ),
        ChecklistItem(
            id = "chk_3",
            stepOrder = 3,
            title = "Proteger Dados Pessoais e Sigilosos",
            description = "Remova senhas, números de documentos, endereços pessoais e dados confidenciais de clientes.",
            whyItMatters = "Garante conformidade com a LGPD e preserva a segurança da sua empresa."
        ),
        ChecklistItem(
            id = "chk_4",
            stepOrder = 4,
            title = "Conferir Fatos, Números e Leis em Fontes Oficiais",
            description = "Faça checagem independente de dados estatísticos, citações de leis e cálculos matemáticos.",
            whyItMatters = "Protege você contra as alucinações involuntárias dos modelos de linguagem."
        ),
        ChecklistItem(
            id = "chk_5",
            stepOrder = 5,
            title = "Fazer a Leitura Final Humana em Voz Alta",
            description = "Leia o texto final do início ao fim, ajustando palavras artificiais para manter a sua voz autêntica.",
            whyItMatters = "Garante que o material continue soando como um ser humano genuíno."
        )
    )

    val aboutAuthor = AboutAuthor(
        name = "Equipe Editorial IA na Prática",
        bio = "Especialistas em comunicação digital, produtividade e aplicação prática de tecnologias emergentes para o dia a dia de profissionais, estudantes e empreendedores brasileiros.",
        note = "Este eBook foi concebido como um guia vivo e dinâmico, focado na resolução prática de problemas reais sem jargões desnecessários.",
        contactOrEditableNote = "Você pode personalizar esta seção com o seu nome, bio e links para transformar este modelo no seu próprio projeto editorial digital."
    )

    const val disclaimer = "Aviso Importante: O universo da inteligência artificial generativa evolui com rapidez extraordinária. Interfaces, nomes de botões, limites de planos gratuitos e modelos específicos citados neste guia podem sofrer alterações ao longo do tempo. Os princípios fundamentais ensinados aqui — comunicação clara, estruturação de contexto, checagem factual e pensamento crítico —, no entanto, são atemporais e continuarão válidos em qualquer ferramenta que você venha a utilizar no futuro."
}
