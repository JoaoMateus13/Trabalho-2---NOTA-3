package entidades;

public class ArtigoPeriodico extends Producao{
    private String producaoISSN;

    public ArtigoPeriodico(String curriculoID, String tituloArtigo,
                           String avaliacao, String ano, String producaoISSN) {
        super(curriculoID, tituloArtigo, avaliacao, ano);
        this.producaoISSN = producaoISSN;

    }

    public String getProducaoISSN() {
        return producaoISSN;
    }

    public void setProducaoISSN(String producaoISSN) {
        this.producaoISSN = producaoISSN;
    }
}