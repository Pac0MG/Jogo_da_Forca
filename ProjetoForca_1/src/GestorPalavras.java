import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestorPalavras {
    private final List<String> palavras;
    private String palavraAtual;
    private final Random random;

    private static final String[] PALAVRAS_HARDCODED = {
            "PROGRAMACAO", "COMPUTADOR", "ALGORITMO", "VARIAVEL",
            "FUNCAO", "CLASSE", "OBJETO", "METODO", "ARRAY",
            "CICLO", "CONDICAO", "ELEFANTE", "GIRAFA", "TIGRE", "LEAO"
    };

    public GestorPalavras() {
        this.palavras = new ArrayList<>();
        this.random = new Random();
    }

    // Getter necessário
    public String getPalavraAtual() {
        return palavraAtual;
    }

    // Métodos principais
    public void inicializarPalavras() {
        palavras.clear();
        for (String palavra : PALAVRAS_HARDCODED) {
            palavras.add(palavra);
        }
    }

    public String escolherPalavraAleatoria() {
        if (palavras.isEmpty()) {
            throw new IllegalStateException("Lista de palavras está vazia! Chame inicializarPalavras() primeiro.");
        }

        int indiceAleatorio = random.nextInt(palavras.size());
        palavraAtual = palavras.get(indiceAleatorio);
        return palavraAtual;
    }

    public int obterTotalPalavras() {
        return palavras.size();
    }


}
