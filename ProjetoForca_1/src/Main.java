import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private final Scanner scanner;
    private final JogoForca jogoForca;
    private final GestorPalavras gestorPalavras;
    private boolean continuar;
    private int jogosNestaSessao;
    private int vitoriasNestaSessao;
    private String ultimaPalavra;
    private String ultimoResultado;

    public Main() {
        this.scanner = new Scanner(System.in);
        this.gestorPalavras = new GestorPalavras();
        this.jogoForca = new JogoForca(gestorPalavras);
        this.continuar = true;
        this.jogosNestaSessao = 0;
        this.vitoriasNestaSessao = 0;
        this.ultimaPalavra = "";
        this.ultimoResultado = "";
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.inicio();
        main.executarLoop();
        main.fim();
    }

    private void inicio() {
        System.out.println("=== JOGO DA FORCA ===");
        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.print("Carregando lista de palavras...");
        gestorPalavras.inicializarPalavras();
        System.out.println("\n" + gestorPalavras.obterTotalPalavras() + " palavras disponíveis.");
        System.out.println("Sistema inicializado!\n");
    }

    private void executarLoop() {
        while (continuar) {
            mostrarMenuPrincipal();
            int opcao = lerOpcao();
            processarOpcao(opcao);
        }
    }

    private void mostrarMenuPrincipal() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Novo Jogo");
        System.out.println("2. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        while (true) {
            try {
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                if (opcao >= 1 && opcao <= 2) {
                    return opcao;
                }
                System.out.print("Opção inválida! Escolha 1 ou 2: ");
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Por favor, digite um número: ");
            }
        }
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                executarJogo();
                break;
            case 2:
                continuar = false;
                break;
        }
    }

    private void executarJogo() {
        System.out.println("\n=== INICIANDO NOVO JOGO ===");
        System.out.println("Escolhendo palavra aleatória...");

        jogoForca.inicializarJogo();
        jogosNestaSessao++;

        System.out.println("Palavra selecionada! (" + jogoForca.getPalavraSecreta().length() + " letras)");
        System.out.println("\nRegras:");
        System.out.println("- Adivinhe a palavra letra por letra");
        System.out.println("- Você tem 6 tentativas erradas");
        System.out.println("Boa sorte!\n");

        while (!jogoForca.isJogoTerminado()) {
            jogoForca.mostrarEstado();
            jogoForca.mostrarForca();

            char letra = lerLetra();

            if (jogoForca.getLetrasTentadas().contains(letra)) {
                System.out.println("Você já tentou essa letra! Tente outra.\n");
                continue;
            }

            jogoForca.processarTentativa(letra);
            System.out.println();
        }

        mostrarResultadoFinal();

        if (perguntarNovoJogo()) {
            System.out.println();
        } else {
            continuar = false;
        }
    }

    private char lerLetra() {
        System.out.print("Digite uma letra: ");
        while (true) {
            String entrada = scanner.nextLine().trim().toUpperCase();
            if (validarEntrada(entrada)) {
                return entrada.charAt(0);
            }
            System.out.print("Entrada inválida! Digite apenas uma letra: ");
        }
    }

    private boolean validarEntrada(String entrada) {
        return entrada.length() == 1 && Character.isLetter(entrada.charAt(0));
    }

    private void mostrarResultadoFinal() {
        if (jogoForca.isJogadorVenceu()) {
            System.out.println("=== PARABÉNS! VOCÊ VENCEU! ===");
            System.out.println("Palavra completa: " + jogoForca.getPalavraSecreta());
            vitoriasNestaSessao++;
            ultimoResultado = "VITÓRIA";
        } else {
            System.out.println("=== GAME OVER ===");
            jogoForca.mostrarForca();
            System.out.println("A palavra era: " + jogoForca.getPalavraSecreta());
            ultimoResultado = "DERROTA";
        }

        ultimaPalavra = jogoForca.getPalavraSecreta();
        mostrarEstatisticasJogoAtual();
    }

    private void mostrarEstatisticasJogoAtual() {
        System.out.println("\n=== ESTATÍSTICAS DO JOGO ===");
        System.out.println("Palavra: " + jogoForca.getPalavraSecreta());

        StringBuilder letras = new StringBuilder();
        for (int i = 0; i < jogoForca.getLetrasTentadas().size(); i++) {
            letras.append(jogoForca.getLetrasTentadas().get(i));
            if (i < jogoForca.getLetrasTentadas().size() - 1) {
                letras.append(", ");
            }
        }
        System.out.println("Letras tentadas: " + letras + " (" + jogoForca.getLetrasTentadas().size() + " letras)");

        System.out.println("Tentativas corretas: " + jogoForca.obterLetrasCorretas());
        System.out.println("Tentativas erradas: " + jogoForca.obterLetrasErradas());
        System.out.println("Resultado: " + ultimoResultado);
        System.out.println("Hora de início: " + jogoForca.getHoraInicio());
        System.out.println("Hora de fim: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    private boolean perguntarNovoJogo() {
        System.out.print("\nDeseja jogar novamente? (S/N): ");
        while (true) {
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (resposta.equals("S") || resposta.equals("SIM")) {
                return true;
            } else if (resposta.equals("N") || resposta.equals("NAO") || resposta.equals("NÃO")) {
                return false;
            } else {
                System.out.print("Resposta inválida! Digite S para Sim ou N para Não: ");
            }
        }
    }

    private void fim() {
        System.out.println("\nA sair do programa...");
        System.out.println("Obrigado por jogar o Jogo da Forca!");
        mostrarEstatisticasFinais();
        System.out.println("Desenvolvido por: gmv");
        System.out.println("Sistema encerrado.");
        scanner.close();
    }

    private void mostrarEstatisticasFinais() {
        System.out.println("\nEstatísticas da sessão:");
        System.out.println("- Jogos: " + jogosNestaSessao);
        System.out.println("- Vitórias: " + vitoriasNestaSessao);
        if (!ultimaPalavra.isEmpty()) {
            System.out.println("- Última palavra: " + ultimaPalavra + " (" + ultimoResultado + ")");
        }
    }
}