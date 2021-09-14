
package entidades;

import java.io.Serializable;
import java.util.Hashtable;


public class Curriculo implements Serializable,Comparable<Curriculo> {
    private String curriculoId;
    private String nomeCompleto;
    private Hashtable<Integer, Producao> producaoHashtable;
    private Hashtable<String, Setor> setorHashtable;

    public Curriculo(String curriculoId, String nomeCompleto) {
        this.curriculoId = curriculoId;
        this.nomeCompleto = nomeCompleto;
        this.producaoHashtable = new Hashtable<Integer, Producao>();
        this.setorHashtable = new Hashtable<String, Setor>();
    }

    public String getCurriculoId() {
        return curriculoId;
    }

    public void setCurriculoId(String curriculoId) {
        this.curriculoId = curriculoId;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Hashtable<Integer, Producao> getProducaoHashtable() {
        return producaoHashtable;
    }

    public void setProducaoHashtable(Hashtable<Integer, Producao> producaoHashtable) {
        this.producaoHashtable = producaoHashtable;
    }

    public Hashtable<String, Setor> getSetorHashtable() {
        return setorHashtable;
    }

    public void setSetorHashtable(Hashtable<String, Setor> setorHashtable) {
        this.setorHashtable = setorHashtable;
    }

    public void receberProducao(Producao producao, Integer key){
        this.producaoHashtable.put(key,producao);
    }

    public void receberSetor(Setor setores, String key){
        this.setorHashtable.put(key, setores);
    }


    @Override
    public int compareTo(Curriculo o) {
        return this.nomeCompleto.compareTo(o.getNomeCompleto());
    }
}

