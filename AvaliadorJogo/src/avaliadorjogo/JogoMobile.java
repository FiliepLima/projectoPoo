
package avaliadorjogo;


public class JogoMobile extends Jogo{
    
    private String controle;

    public JogoMobile(String nomeJogo, String produtora, String genero, String modoJogo, int ano, String controle) {
        super(nomeJogo, produtora, genero, modoJogo, ano);
        this.controle = controle;    
    } 
   
}
