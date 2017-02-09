
package br.ufla.dcc.ppoo.servicos;


import br.ufla.dcc.ppoo.modelo.Avaliacao;
import br.ufla.dcc.ppoo.modelo.Usuario;
import br.ufla.dcc.ppoo.modelo.Jogo;

import java.util.ArrayList;


public class GerenciadorJogos {
    
    private static ArrayList<Jogo> listaJogos;

    public GerenciadorJogos() {
        listaJogos = new ArrayList();
    }
    
    

     public void addJogosLista(Jogo j1){
        listaJogos.add(j1);

    }
   
    public void imprimir(){
        
        for(Jogo s: listaJogos)
             System.out.println(s.toString());  

    }
    
}

