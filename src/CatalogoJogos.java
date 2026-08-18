public class CatalogoJogos {

    private No inicio;
    private int tamanho;

    public CatalogoJogos() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // =========================
    // INSERÇÃO ORDENADA
    // =========================

    public void inserirOrdenado(Jogo jogo) {

        No novo = new No(jogo);

        // Caso 1: lista vazia
        if (estaVazio()) {

            novo.setProximo(novo);
            novo.setAnterior(novo);

            inicio = novo;

            tamanho++;

            return;
        }

        // Caso 2: novo jogo vem antes do primeiro
        if (jogo.getNome().compareToIgnoreCase(
                inicio.getJogo().getNome()
        ) < 0) {

            No ultimo = inicio.getAnterior();

            novo.setProximo(inicio);
            novo.setAnterior(ultimo);

            ultimo.setProximo(novo);
            inicio.setAnterior(novo);

            inicio = novo;

            tamanho++;

            return;
        }

        // Caso 3: procurar posição correta
        No atual = inicio;

        while (
                atual.getProximo() != inicio
                        &&
                        atual.getProximo()
                                .getJogo()
                                .getNome()
                                .compareToIgnoreCase(jogo.getNome()) <= 0
        ) {

            atual = atual.getProximo();
        }

        No proximo = atual.getProximo();

        novo.setAnterior(atual);
        novo.setProximo(proximo);

        atual.setProximo(novo);
        proximo.setAnterior(novo);

        tamanho++;
    }


    // =========================
    // BUSCA
    // =========================

    public Jogo buscarPorNome(String nome) {

        No encontrado = buscarNoPorNome(nome);

        if (encontrado == null) {
            return null;
        }

        return encontrado.getJogo();
    }


    // =========================
    // BUSCA DO NÓ
    // =========================

    private No buscarNoPorNome(String nome) {

        if (estaVazio()) {
            return null;
        }

        No atual = inicio;

        do {

            if (
                    atual.getJogo()
                            .getNome()
                            .equalsIgnoreCase(nome)
            ) {
                return atual;
            }

            atual = atual.getProximo();

        } while (atual != inicio);

        return null;
    }


    // =========================
    // REMOÇÃO
    // =========================

    public boolean removerPorNome(String nome) {

        No remover = buscarNoPorNome(nome);

        if (remover == null) {
            return false;
        }

        // Caso 1: existe apenas um elemento
        if (tamanho == 1) {

            inicio = null;
            tamanho = 0;

            return true;
        }

        No anterior = remover.getAnterior();
        No proximo = remover.getProximo();

        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);

        // Se removemos o primeiro,
        // o próximo passa a ser o novo início
        if (remover == inicio) {
            inicio = proximo;
        }

        tamanho--;

        return true;
    }


    // =========================
    // LISTAGEM
    // =========================

    public void listar() {

        if (estaVazio()) {
            System.out.println("O catálogo está vazio.");
            return;
        }

        System.out.println("\n=== CATÁLOGO DE JOGOS ===");

        No atual = inicio;
        int posicao = 1;

        do {

            System.out.println(
                    posicao + " - " + atual.getJogo().getNome()
            );

            atual = atual.getProximo();
            posicao++;

        } while (atual != inicio);
    }


    // =========================
    // STATUS
    // =========================

    public void mostrarStatus() {

        if (estaVazio()) {
            System.out.println("O catálogo está vazio.");
            return;
        }

        System.out.println(
                "\nQuantidade de jogos: " + tamanho
        );

        System.out.println(
                "Primeiro jogo: "
                        + inicio.getJogo().getNome()
        );

        System.out.println(
                "Último jogo: "
                        + inicio
                        .getAnterior()
                        .getJogo()
                        .getNome()
        );
    }


    // =========================
    // MÉTODOS AUXILIARES
    // =========================

    public boolean estaVazio() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    public No getInicio() {
        return inicio;
    }
}