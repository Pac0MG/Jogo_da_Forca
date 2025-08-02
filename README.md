Jogo da Forca em Java

Um jogo da forca simplificado desenvolvido em Java com sistema de estatísticas em memória, seguindo as especificações do projeto de Integração de Sistemas de Informação.

Índice

- [Descrição](#-descrição)
- [Funcionalidades](#-funcionalidades)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Como Executar](#-como-executar)
- [Como Jogar](#-como-jogar)
- [Especificações Técnicas](#-especificações-técnicas)
- [Exemplo de Execução](#-exemplo-de-execução)

Descrição

Este projeto implementa um jogo da forca clássico onde o jogador deve adivinhar uma palavra letra por letra. O programa conta com um sistema de estatísticas que acompanha o desempenho durante a sessão e oferece feedback visual através de ASCII art.

Funcionalidades

Menu Principal com opções de Novo Jogo e Sair
15 palavras pré-definidas relacionadas com programação e animais
Sistema de tentativas limitado a 6 erros
Desenho ASCII da forca que evolui com os erros
Validação de entrada robusta do utilizador
Estatísticas detalhadas de cada jogo individual
Estatísticas da sessão exibidas ao sair
Controlo de tempo com hora de início e fim
Opção de jogar novamente após cada partida
Interface intuitiva com feedback claro

Estrutura do Projeto

ProjetoForca/
├── Main.java            Classe principal com menu e controlo do fluxo
├── JogoForca.java       Lógica do jogo e gestão do estado
├── GestorPalavras.java  Gestão da lista de palavras
└── README.md            Documentação do projeto

Descrição das Classes

Main.java
- Controla o menu principal e fluxo geral do programa
- Gere estatísticas da sessão (jogos jogados, vitórias)
- Implementa validação de entrada do utilizador
- Controla o loop principal da aplicação

JogoForca.java
- Contém toda a lógica do jogo da forca
- Gere o estado do jogo (palavra secreta, letras tentadas, tentativas restantes)
- Implementa o desenho ASCII da forca evolutivo
- Verifica condições de vitória e derrota

GestorPalavras.java
- Gere a lista de 15 palavras hardcoded
- Seleciona palavras aleatórias para cada jogo
- Fornece informações sobre o total de palavras disponíveis

Como Executar

 Pré-requisitos
- Java JDK 8 ou superior
- Terminal/Prompt de comando

Passos para execução

1. Compilar os ficheiros Java:
bash
javac *.java

2. Executar o programa:
bash
java Main

3. Seguir as instruções no ecrã

Como Jogar

1. Iniciar o programa - O sistema carrega as 15 palavras disponíveis
2. Escolher "1" no menu para iniciar um novo jogo
3. Adivinhar letras - Digite uma letra por vez quando solicitado
4. Acompanhar o progresso - Veja a palavra sendo revelada e a forca sendo desenhada
5. Vencer ou perder - Descubra a palavra completa ou esgote as 6 tentativas
6. Ver estatísticas - Analise o seu desempenho ao final de cada jogo
7. Jogar novamente - Escolha se quer uma nova partida ou sair

Regras do Jogo

- Você tem 6 tentativas erradas antes de perder
- Cada letra incorreta adiciona uma parte ao desenho da forca
- Letras já tentadas não podem ser repetidas
- A palavra é revelada progressivamente conforme acerta as letras
- Vitória: Descobrir todas as letras da palavra
- Derrota: Esgotar as 6 tentativas sem descobrir a palavra

Especificações Técnicas

Tecnologias Utilizadas
- Java SE (versão 8+)
- Collections Framework (List, ArrayList)
- Java Time API para controlo de tempo
- Scanner para entrada do utilizador
- StringBuilder para otimização de strings

Características Técnicas
- Orientação a Objetos com 3 classes bem definidas
- Encapsulamento com getters adequados e campos final
- Lista hardcoded de 15 palavras pré-definidas
- Validação robusta de todas as entradas do utilizador
- Gestão de memória eficiente sem ficheiros externos
- Interface ASCII para visualização da forca

Lista de Palavras Disponíveis

"PROGRAMACAO", "COMPUTADOR", "ALGORITMO", "VARIAVEL",
"FUNCAO", "CLASSE", "OBJETO", "METODO", "ARRAY",
"CICLO", "CONDICAO", "ELEFANTE", "GIRAFA", "TIGRE", "LEAO"

Exemplo de Execução

=== JOGO DA FORCA ===
Bem-vindo ao Jogo da Forca!
Carregando lista de palavras...
15 palavras disponíveis.
Sistema inicializado!

=== MENU PRINCIPAL ===
1. Novo Jogo
2. Sair
Escolha uma opção: 1

=== INICIANDO NOVO JOGO ===
Escolhendo palavra aleatória...
Palavra selecionada! (11 letras)

Regras:
- Adivinhe a palavra letra por letra
- Você tem 6 tentativas erradas
Boa sorte!

=== ESTADO DO JOGO ===
Palavra: _ _ _ _ _ _ _ _ _ _ _
Tentativas restantes: 6
Letras tentadas: (nenhuma)
Hora de início: 15:30:22

+---+
|   |
|    
|    
|    
|    
=========

Digite uma letra: A
Muito bem! A letra 'A' existe na palavra!

=== ESTADO DO JOGO ===
Palavra: _ _ _ _ _ A _ A _ _ _
Tentativas restantes: 6
Letras tentadas: A
Hora de início: 15:30:22

[... continua até vitória ou derrota ...]

=== PARABÉNS! VOCÊ VENCEU! ===
Palavra completa: PROGRAMACAO

=== ESTATÍSTICAS DO JOGO ===
Palavra: PROGRAMACAO
Letras tentadas: A, E, O, R, I, G, M, C, P (9 letras)
Tentativas corretas: 7
Tentativas erradas: 2
Resultado: VITÓRIA
Hora de início: 15:30:22
Hora de fim: 15:33:15

Deseja jogar novamente? (S/N): N

A sair do programa...
Obrigado por jogar o Jogo da Forca!

Estatísticas da sessão:
- Jogos: 1
- Vitórias: 1
- Última palavra: PROGRAMACAO (VITÓRIA)

Desenvolvido por: [Nome do Aluno]
Sistema encerrado.

Desenvolvido por: gmv - https://www.linkedin.com/in/goncalomv/
Data: Agosto 2025
