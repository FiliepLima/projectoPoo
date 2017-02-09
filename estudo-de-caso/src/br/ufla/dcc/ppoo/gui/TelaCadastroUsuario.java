package br.ufla.dcc.ppoo.gui;

import br.ufla.dcc.ppoo.i18n.I18N;
import br.ufla.dcc.ppoo.imagens.GerenciadorDeImagens;
import br.ufla.dcc.ppoo.modelo.Usuario;
import br.ufla.dcc.ppoo.servicos.GerenciadorUsuarios;
import br.ufla.dcc.ppoo.util.Utilidades;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Classe que representa a tela de Cadastro de Usuários
 * 
 * @author Paulo Jr. e Julio Alves
 */
public class TelaCadastroUsuario {

    // referência para a tela principal
    private final TelaPrincipal telaPrincipal;
    // referência para o gerenciador de usuários
    private final GerenciadorUsuarios gerenciadorUsuarios;

    // componentes da tela
    private JDialog janela;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private JLabel lbNome;
    private JLabel lbLogin;
    private JLabel lbSenha;
    private JLabel lbConfirmarSenha;
    private JTextField txtNome;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;
    private JButton btnSalvar;
    private JButton btnCancelar;

    /**
     * Constrói a tela de Cadastro de Usuários guardando a referência da tela 
     * principal e criando o gerenciador de usuários.
     * 
     * @param telaPrincipal Referência da tela principal.
     */
    public TelaCadastroUsuario(TelaPrincipal telaPrincipal) {
        this.gerenciadorUsuarios = new GerenciadorUsuarios();
        this.telaPrincipal = telaPrincipal;
    }
    
    /**
     * Inicializa a tela, construindo seus componentes, configurando os eventos
     * e, ao final, exibe a tela.
     */
    public void inicializar() {
        construirTela();
        configurarAcoesBotoes();
        exibirTela();
    }

    /**
     * Adiciona um componente à tela.
     */
    private void adicionarComponente(Component c,
            int anchor, int fill, int linha,
            int coluna, int largura, int altura) {
        gbc.anchor = anchor;
        gbc.fill = fill;
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridwidth = largura;
        gbc.gridheight = altura;
        gbc.insets = new Insets(5, 5, 5, 5);
        layout.setConstraints(c, gbc);
        janela.add(c);
    }

    /**
     * Adiciona um componente à tela.
     */
    private void adicionarComponentes() {
        lbNome = new JLabel(I18N.obterRotuloUsuarioNome());
        adicionarComponente(lbNome,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                0, 0, 1, 1);

       
       lbLogin = new JLabel(I18N.obterRotuloUsuarioLogin());
        adicionarComponente(lbLogin,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                1, 0, 1, 1);

        lbSenha = new JLabel(I18N.obterRotuloUsuarioSenha());
        adicionarComponente(lbSenha,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                2, 0, 1, 1);

        lbConfirmarSenha = new JLabel(I18N.obterRotuloUsuarioConfirmarSenha());
        adicionarComponente(lbConfirmarSenha,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                3, 0, 1, 1);

        txtNome = new JTextField(35);
        adicionarComponente(txtNome,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                0, 1, 1, 1);

        txtLogin = new JTextField(25);
        adicionarComponente(txtLogin,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                1, 1, 1, 1);

        txtSenha = new JPasswordField(10);
        adicionarComponente(txtSenha,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                2, 1, 1, 1);

        txtConfirmarSenha = new JPasswordField(10);
        adicionarComponente(txtConfirmarSenha,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                3, 1, 1, 1);

        btnSalvar = new JButton(I18N.obterBotaoSalvar(),
                GerenciadorDeImagens.OK);

        btnCancelar = new JButton(I18N.obterBotaoCancelar(),
                GerenciadorDeImagens.CANCELAR);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);

        adicionarComponente(painelBotoes,
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE,
                4, 0, 2, 1);
    }

    /**
     * Retorna um novo usuário a partir do login, nome e senha passados.
     * 
     * @return Usuário criado.
     */
    private Usuario carregarUsuario() {
        return new Usuario(txtLogin.getText(),
                txtSenha.getPassword(),
                txtNome.getText());
    }

    /**
     * Limpa os componentes da tela
     */
    private void limparTela() {
        txtNome.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtConfirmarSenha.setText("");
        txtNome.requestFocus();
    }

    /**
     * Configura os eventos dos botões.
     */
    private void configurarAcoesBotoes() {
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!Arrays.equals(txtSenha.getPassword(),
                            txtConfirmarSenha.getPassword())) {
                        throw new Exception(I18N.obterErroSenhasNaoConferem());
                    }

                    gerenciadorUsuarios.cadastrarUsuario(carregarUsuario());
                    Utilidades.msgInformacao(I18N.obterSucessoCadastroUsuario());
                    limparTela();
                } catch (Exception ex) {
                    Utilidades.msgErro(ex.getMessage());
                }

            }
        });

    }

    /**
     * Constrói a janela tratando internacionalização, componentes e layout.
     */
    private void construirTela() {
        janela = new JDialog();
        janela.setTitle(I18N.obterTituloTelaCadastrarUsuario());
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        janela.setLayout(layout);
        adicionarComponentes();        
        janela.pack();
    }

    /**
     * Exibe a tela.
     */
    public void exibirTela() {
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(telaPrincipal.obterJanela());
        janela.setModal(true);
        janela.setVisible(true);
        janela.setResizable(false);
    }
}
