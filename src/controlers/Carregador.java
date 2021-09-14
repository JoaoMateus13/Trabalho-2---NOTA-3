package controlers;

import entidades.ArtigoPeriodico;
import entidades.Curriculo;
import entidades.Producao;
import entidades.Setor;

import java.io.*;
import java.util.Hashtable;


public class Carregador {

   /* public static TreeMap<String, Curriculo> carregarCurriulo() throws IOException {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Zeus\\Documents\\" +
                "Trabalho 2 - NOTA 3\\src\\dados\\curriculo.csv")));
        TreeMap<String, Curriculo> curriculoHashtable = new TreeMap<String, Curriculo>();

        String linha = leitor.readLine();

        while ((linha = leitor.readLine()) != null) {
            String tmp[] = linha.split(";");
            curriculoHashtable.put(tmp[0], new Curriculo(tmp[0], tmp[1]));
        }
        leitor.close();
        return curriculoHashtable;
    }*/

    public static Hashtable<String, Curriculo> carregarCurriulo() throws IOException {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Zeus\\Documents\\" +
                "Trabalho 2 - NOTA 3\\src\\dados\\curriculo.csv")));
        Hashtable<String, Curriculo> curriculoHashtable = new Hashtable<String, Curriculo>();

        String linha = leitor.readLine();

        while ((linha = leitor.readLine()) != null) {
            String tmp[] = linha.split(";");
            curriculoHashtable.put(tmp[0], new Curriculo(tmp[0], tmp[1]));
        }
        leitor.close();
        return curriculoHashtable;
    }


    public static Hashtable<Integer, Producao> carregarProducaoPeriodico() throws IOException {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Zeus\\" +
                "Documents\\Trabalho 2 - NOTA 3\\src\\dados\\artigos_em_periodico.csv")));


        String linha = leitor.readLine();

        Hashtable<Integer, Producao> producaoHashtable = new Hashtable<Integer, Producao>();
        while ((linha = leitor.readLine()) != null) {
            String tmp[] = linha.split(";");
            producaoHashtable.put(producaoHashtable.hashCode(), new ArtigoPeriodico(tmp[0], tmp[1], tmp[2],
                    tmp[4], tmp[2]) {
            });
        }
        leitor.close();
        return producaoHashtable;
    }


    public static Hashtable<String, Setor> carregarSetores() throws IOException {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Zeus\\" +
                "Documents\\Trabalho 2 - NOTA 3\\src\\dados\\setor.csv")));

        Hashtable<String, Setor> setores = new Hashtable<String, Setor>();

        String linha = leitor.readLine();
        while((linha = leitor.readLine()) != null) {
            String[] tmp = linha.split(";");
            setores.put(tmp[0], new Setor(tmp[0], tmp[2], tmp[1]));
        }
        leitor.close();

        return setores;
    }

    public static void curriculoProducoe(Hashtable<Integer, Producao> producoes, Hashtable<String, Curriculo> curriculos) throws IOException {
        for (int key : producoes.keySet()) {
            Producao producao = producoes.get(key);
            Curriculo curriculo = curriculos.get(producao.getCurriculoID());
            curriculo.receberProducao(producao, key);
        }
    }

   public static void curriculoSetores(Hashtable<String, Setor> setores, Hashtable<String, Curriculo> curriculos) throws IOException {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Zeus\\" +
                "Documents\\Trabalho 2 - NOTA 3\\src\\dados\\curriculo_setor.csv")));

       String linha = leitor.readLine();
       while((linha = leitor.readLine()) != null) {
           String[] tmp = linha.split(";");

           for(String key : curriculos.keySet()) {
               if( tmp[0].equals(curriculos.get(key).getCurriculoId()) ) {
                   curriculos.get(key).receberSetor(setores.get(tmp[1]), tmp[1]);

               }
           }

       }
       leitor.close();

   }

   public static void estratosPeriodicos(Hashtable<Integer, Producao> producoes) throws IOException {
       BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Zeus" +
               "\\Documents\\Trabalho 2 - NOTA 3\\src\\dados\\estrato_artigo_periodico.csv")));

       String linha = leitor.readLine();
       while ((linha = leitor.readLine()) != null) {
           String[] tmp = linha.split(";");

           for (int key : producoes.keySet()) {
               ArtigoPeriodico producao = (ArtigoPeriodico) producoes.get(key);
               if (tmp[0].equalsIgnoreCase(producao.getProducaoISSN())){
                   producao.setAvaliacao(tmp[2]);
               }
           }
       }
   }



    public static void escreverRelatorioPadrao(/*String CurriculoId, String NomeCompleto, String TituloArtigo,
    String CurriculoID*/) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter("test.txt")) ;
        Hashtable<Integer, Producao> producoes = carregarProducaoPeriodico();
        Hashtable<String, Curriculo> curriculos = carregarCurriulo();
        Hashtable<String, Setor> setores = carregarSetores();
        curriculoSetores(setores, curriculos);
        curriculoProducoe(producoes, curriculos);
        curriculoSetores(setores, curriculos);
        estratosPeriodicos(producoes);
        for (String key : curriculos.keySet()) {
            Curriculo curriculo = curriculos.get(key);
            for (int key1 : curriculo.getProducaoHashtable().keySet()) {
                Producao producao = curriculo.getProducaoHashtable().get(key1);
                String nome = curriculo.getNomeCompleto();
                String titulo = producao.getTituloArtigo();
                //String lugar = setor.getNome();
                String ano = producao.getAno();
                String qualis = producao.getAvaliacao();
                for (String key2 : curriculo.getSetorHashtable().keySet()) {
                    Setor setor1 = curriculo.getSetorHashtable().get(key2);
                    String sigla = setor1.getNome();
                    String lugar = setor1.getSigla();
                    escritor.write("\n" + nome + " | " + lugar + " | " + ano  + " | " + titulo + " | " + sigla +
                            " | " + qualis);
                }

            }
        }
        escritor.close();
    }

    public static void main(String[] args) {
        try {
            escreverRelatorioPadrao();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}