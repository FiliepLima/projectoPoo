
package br.ufla.dcc.ppoo.modelo;

import br.ufla.dcc.ppoo.i18n.I18N;
import br.ufla.dcc.ppoo.imagens.GerenciadorDeImagens;
import br.ufla.dcc.ppoo.seguranca.SessaoUsuario;
import br.ufla.dcc.ppoo.servicos.GerenciadorJogos;
import br.ufla.dcc.ppoo.util.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;

import java.util.ArrayList;


public class Jogo {
    
    private String nomeJogo;
    private String produtora;
    private String genero;
    private String modoJogo;
    private String ano;
    private ArrayList<Avaliacao> listaAvaliacao;

    public Jogo(String nomeJogo, String produtora, String genero, String modoJogo, String ano) {
        this.nomeJogo = nomeJogo;
        this.produtora = produtora;
        this.genero = genero;
        this.modoJogo = modoJogo;
        this.ano = ano;
        this.listaAvaliacao = new ArrayList();
        
        
        //System.out.println(toString());
       
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
    
    public String getAno() {
        return ano;
    }
    /*
    public void addAvaliacao(Avaliacao a1){
        
        listaAvaliacao.add(a1);
       
    }
    
    public void imprimir(){ //temporario
        
        for(Avaliacao s: listaAvaliacao)
            System.out.println(s.toString());  
    }*/

    @Override
    public String toString() {
        return "Jogo{" + "nomeJogo=" + nomeJogo + ", produtora=" + produtora + ", genero=" + genero + ", modoJogo=" + modoJogo + ", ano=" + ano + '}';
    }
    
    
    
    
}