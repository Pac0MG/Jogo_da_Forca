import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JogoForca {
    private String palavraSecreta;
    private char[] palavraRevelada;
    private final List<Character> letrasTentadas;
    private int tentativasRestantes;
    private boolean jogoTerminado;
    private boolean jogadorVenceu;
    private final GestorPalavras gestorPalavras;
    private String horaInicio;

    public JogoForca(GestorPalavras gestorPalavras) {
        this.gestorPalavras = gestorPalavras;
        this.letrasTentadas = new ArrayList<>();
        this.tentativasRestantes = 6;
        this.jogoTerminado = false;
        this.jogadorVenceu = false;
    }

    // Getters necessários
    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public List<Character> getLetrasTentadas() {
        return letrasTentadas;
    }

    public boolean isJogoTerminado() {
        return jogoTerminado;
    }

    public boolean isJogadorVenceu() {
        return jogadorVenceu;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    // Métodos principais
    public void inicializarJogo() {
        this.palavraSecreta = gestorPalavras.escolherPalavraAleatoria();
        this.palavraRevelada = new char[palavraSecreta.length()];
        this.letrasTentadas.clear();
        this.tentativasRestantes = 6;
        this.jogoTerminado = false;
        this.jogadorVenceu = false;
        this.horaInicio = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        // Inicializar palavra revelada com underscores
        for (int i = 0; i < palavraSecreta.length(); i++) {
            palavraRevelada[i] = '_';
        }
    }

    public void processarTentativa(char letra) {
        letra = Character.toUpperCase(letra);
        letrasTentadas.add(letra);

        if (verificarLetra(letra)) {
            revelarLetras(letra);
            System.out.println("Muito bem! A letra '" + letra + "' existe na palavra!");
            verificarVitoria();
        } else {
            tentativasRestantes--;
            System.out.println("A letra '" + letra + "' não existe na palavra.");
            if (tentativasRestantes > 0) {
                System.out.println("Tentativas restantes: " + tentativasRestantes);
            }
            verificarDerrota();
        }
    }

    public boolean verificarLetra(char letra) {
        return palavraSecreta.indexOf(letra) != -1;
    }

    public void verificarVitoria() {
        for (char c : palavraRevelada) {
            if (c == '_') {
                return; // Ainda há letras por descobrir
            }
        }
        jogoTerminado = true;
        jogadorVenceu = true;
    }

    public void verificarDerrota() {
        if (tentativasRestantes <= 0) {
            jogoTerminado = true;
            jogadorVenceu = false;
        }
    }

    public void mostrarEstado() {
        System.out.println("=== ESTADO DO JOGO ===");
        System.out.print("Palavra: ");
        for (char c : palavraRevelada) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("Tentativas restantes: " + tentativasRestantes);

        System.out.print("Letras tentadas: ");
        if (letrasTentadas.isEmpty()) {
            System.out.println("(nenhuma)");
        } else {
            StringBuilder letras = new StringBuilder();
            for (int i = 0; i < letrasTentadas.size(); i++) {
                letras.append(letrasTentadas.get(i));
                if (i < letrasTentadas.size() - 1) {
                    letras.append(", ");
                }
            }
            System.out.println(letras);
        }

        System.out.println("Hora de início: " + horaInicio);
        System.out.println();
    }

    public void mostrarForca() {
        String[] desenho = {
                "+---+",
                "|   |",
                "|    ",
                "|    ",
                "|    ",
                "|    ",
                "========="
        };

        int erros = 6 - tentativasRestantes;

        switch (erros) {
            case 1: desenho[2] = "|   O"; break;
            case 2: desenho[2] = "|   O"; desenho[3] = "|   |"; break;
            case 3: desenho[2] = "|   O"; desenho[3] = "|  /|"; break;
            case 4: desenho[2] = "|   O"; desenho[3] = "|  /|\\"; break;
            case 5: desenho[2] = "|   O"; desenho[3] = "|  /|\\"; desenho[4] = "|  / "; break;
            case 6: desenho[2] = "|   O"; desenho[3] = "|  /|\\"; desenho[4] = "|  / \\"; break;
        }

        for (String linha : desenho) {
            System.out.println(linha);
        }
        System.out.println();
    }

    public void revelarLetras(char letra) {
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                palavraRevelada[i] = letra;
            }
        }
    }

    public int obterLetrasCorretas() {
        int corretas = 0;
        for (char letra : letrasTentadas) {
            if (verificarLetra(letra)) {
                corretas++;
            }
        }
        return corretas;
    }

    public int obterLetrasErradas() {
        return letrasTentadas.size() - obterLetrasCorretas();
    }
}