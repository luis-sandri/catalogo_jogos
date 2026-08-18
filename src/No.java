public class No {

    private Jogo jogo;
    private No proximo;
    private No anterior;

    public No(Jogo jogo) {
        this.jogo = jogo;
        this.proximo = null;
        this.anterior = null;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}