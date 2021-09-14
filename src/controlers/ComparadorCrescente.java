
package controlers;

import entidades.Curriculo;

import java.util.Comparator;

public class ComparadorCrescente implements Comparator<Curriculo> {
    @Override
    public int compare(Curriculo o1, Curriculo o2) {
        if(o1.getNomeCompleto().compareToIgnoreCase(o2.getNomeCompleto())>0){
            return 1;
        }
        return -1;
    }
}

