
package br.ufla.dcc.ppoo.modelo;

public class Avaliacao {
    
    private Double nota;
    private String comentario;
    private String usuario;

    public Avaliacao(Double nota, String comentario, String usuario) {
        this.nota = nota;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "nota=" + nota + ", comentario=" + comentario + ", usuario=" + usuario + '}';
    }
}