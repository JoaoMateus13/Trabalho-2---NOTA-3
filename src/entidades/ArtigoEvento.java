package entidades;

public class ArtigoEvento extends Producao{
    private String tituloAnaisProceeding;

    public ArtigoEvento(String curriculoID, String tituloArtigo,
                        String avaliacao, String ano, String tituloAnaisProceeding) {
        super(curriculoID, tituloArtigo, avaliacao, ano);
        this.tituloAnaisProceeding = tituloAnaisProceeding;
    }

    public String getTituloAnaisProceeding() {
        return tituloAnaisProceeding;
    }

    public void setTituloAnaisProceeding(String tituloAnaisProceeding) {
        this.tituloAnaisProceeding = tituloAnaisProceeding;
    }
}
