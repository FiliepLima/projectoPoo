
package avaliadorjogo;

import java.util.ArrayList;


public class Jogo {
    
    private String nomeJogo;
    private String produtora;
    private String genero;
    private String modoJogo;
    private int ano;
    private ArrayList<Avaliacao> listaAvaliacao;

    public Jogo(String nomeJogo, String produtora, String genero, String modoJogo, int ano) {
        this.nomeJogo = nomeJogo;
        this.produtora = produtora;
        this.genero = genero;
        this.modoJogo = modoJogo;
        this.ano = ano;
        this.listaAvaliacao = new ArrayList();
    }    

    public String getNomeJogo() {
        return nomeJogo;
    }

    public String getProdutora() {
        return produtora;
    }

    public String getGenero() {
        return genero;
    }

    public String getModoJogo() {
        return modoJogo;
    }

    public int getAno() {
        return ano;
    }
    
    public void addAvaliacao(Avaliacao a1){
        
        listaAvaliacao.add(a1);
       
    }
    
    public void imprimir(){ //temporario
        
        for(Avaliacao s: listaAvaliacao)
            System.out.println(s.toString());  
    }

    @Override
    public String toString() {
        return "Jogo{" + "nomeJogo=" + nomeJogo + ", produtora=" + produtora + ", genero=" + genero + ", modoJogo=" + modoJogo + ", ano=" + ano + '}';
    }
    
    
    
    
}

