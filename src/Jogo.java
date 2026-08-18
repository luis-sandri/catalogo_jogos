public class Jogo {

    private String nome;
    private String genero;
    private String plataforma;
    private int ano;
    private double nota;

    public Jogo(
            String nome,
            String genero,
            String plataforma,
            int ano,
            double nota
    ) {
        this.nome = nome;
        this.genero = genero;
        this.plataforma = plataforma;
        this.ano = ano;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getAno() {
        return ano;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Jogo {" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", ano=" + ano +
                ", nota=" + nota +
                '}';
    }
}