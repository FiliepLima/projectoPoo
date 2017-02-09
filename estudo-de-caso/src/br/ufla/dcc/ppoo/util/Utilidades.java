package br.ufla.dcc.ppoo.util;

import br.ufla.dcc.ppoo.i18n.I18N;
import javax.swing.JOptionPane;

/**
 * Classe Utilitária com métodos estáticos para exibição de caixas de mensagens
 * padronizadas com internacionalização
 * 
 * @author Paulo Jr. e Julio Alves
 */
public class Utilidades {

    /**
     * Exibe uma caixa de mensagem de confirmação com a mensagem passada 
     * (utilizando internacionalização).
     * 
     * @param mensagem String que representa a chave da mensagem internacionalizada.
     * @return Retorna True se o usuário confirmou e False, caso contrário.
     */
    public static boolean msgConfirmacao(String mensagem) {
        final int op = JOptionPane.showConfirmDialog(null, mensagem,
                I18N.obterTituloMensagemConfirmacao(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return op == JOptionPane.YES_OPTION;
    }

    /**
     * Exibe uma caixa de mensagem de informação com a mensagem passada 
     * (utilizando internacionalização).
     * 
     * @param mensagem String que representa a chave da mensagem internacionalizada. 
     */
    public static void msgInformacao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                I18N.obterTituloMensagemInformacao(), JOptionPane.INFORMATION_MESSAGE);

    }
    
    /**
     * Exibe uma caixa de mensagem de erro com a mensagem passada  (utilizando 
     * internacionalização).
     * 
     * @param mensagem String que representa a chave da mensagem internacionalizada.
     */
    public static void msgErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                I18N.obterTituloMensagemErro(), JOptionPane.ERROR_MESSAGE);

    }
}
