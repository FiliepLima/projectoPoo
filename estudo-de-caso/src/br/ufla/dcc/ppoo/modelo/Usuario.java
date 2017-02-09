package br.ufla.dcc.ppoo.modelo;

import java.util.Arrays;

/**
 * Representa um usuário do sistema.
 * 
 * @author Paulo Jr. e Julio Alves
 */
public class Usuario {
    // login do usuário
    private String login;
    // senha do usuário
    private char[] senha;
    // nome do usuário
    private String nome;

    /**
     * Constrói um usuário a partir de seu login, senha e nome.
     * 
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @param nome Nome do usuário.
     */
    public Usuario(String login, char[] senha, String nome) {
        this.login = login;
        this.senha = Arrays.copyOf(senha, senha.length);
        this.nome = nome;
    }
    
    /**
     * Constrói um usuário a partir de seu login e senha (deixa nome vazio).
     * 
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     */
    public Usuario(String login, char[] senha) {
        this(login, senha, "");
    }

    /**
     * Retorna o login do usuário.
     * 
     * @return O login do usuário.
     */
    public String obterLogin() {
        return login;
    }

    /**
     * Retorna a senha do usuário.
     * 
     * @return A senha do usuário.
     */
    public char[] obterSenha() {
        return senha;
    }

    /**
     * Retorna o nome do usuário.
     * 
     * @return O nome do usuário.
     */
    public String obterNome() {
        return nome;
    }
    
    
}
