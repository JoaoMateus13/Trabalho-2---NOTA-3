package entidades;

public abstract class Producao {
    private String curriculoID;
    private String tituloArtigo;
    private String avaliacao;
    private String ano;

    public Producao(String curriculoID, String tituloArtigo, String avaliacao, String ano) {
        this.curriculoID = curriculoID;
        this.tituloArtigo = tituloArtigo;
        this.avaliacao = "---";
        this.ano = ano;
    }

    public String getCurriculoID() {
        return curriculoID;
    }

    public void setCurriculoID(String curriculoID) {
        this.curriculoID = curriculoID;
    }

    public String getTituloArtigo() {
        return tituloArtigo;
    }

    public void setTituloArtigo(String tituloArtigo) {
        this.tituloArtigo = tituloArtigo;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
