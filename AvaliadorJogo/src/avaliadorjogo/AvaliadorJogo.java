
package avaliadorjogo;


public class AvaliadorJogo {


    public static void main(String[] args) {
        Jogo j1;
        j1 = new JogoMobile("Battle", "ea", "FPS" , "mult", 2000,"mouse");
        
        Usuario u1 = new Usuario("marcos" , "thais" , "waifu");
        
        Avaliacao a1 = new Avaliacao(10.0, "e ruim pra raio", u1.getNomeUsuario() );
        Avaliacao a2 = new Avaliacao(3.0, "e bao", u1.getNomeUsuario() );

        j1.addAvaliacao(a1);
        j1.addAvaliacao(a2);
        
        //j1.imprimir();
      /*
        

        Jogo j2 = j1;//polimorfismo
        
        j2.imprimir();
          */        
        
        //System.out.println(j1.toString());
        
        //System.out.println(a1.toString());
        
        
    }
    
}
