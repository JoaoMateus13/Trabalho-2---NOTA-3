package entidades;

public class Setor {
    private String setor_id;
    private String sigla;
    private String nome;

    public Setor(String setor_id, String sigla, String nome) {
        this.setor_id = setor_id;
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSetor_id() {
        return setor_id;
    }

    public void setSetor_id(String setor_id) {
        this.setor_id = setor_id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
