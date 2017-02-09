package br.ufla.dcc.ppoo.gui;

import br.ufla.dcc.ppoo.i18n.I18N;
import br.ufla.dcc.ppoo.imagens.GerenciadorDeImagens;
import br.ufla.dcc.ppoo.seguranca.SessaoUsuario;
import br.ufla.dcc.ppoo.servicos.GerenciadorJogos;
import br.ufla.dcc.ppoo.modelo.Jogo;
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

/**
 * Classe que representa a Tela Principal
 *
 * @author Julio
 */
public class TelaPrincipal {

    // objeto de controle de sessão (autenticação) do usuário
    private final SessaoUsuario sessaoUsuario;
    // tela de autenticação (login) de usuário
    private final TelaAutenticacao telaAutenticacao;
    // tela de cadastro de usuário
    private final TelaCadastroUsuario telaCadastroUsuario;
    
    private final TelaCadastramentoJogo telaCadastroJogo;
    private final TelaAvaliacao telaAvaliacao;
   // private final GerenciadorJogos gerenciadorJogos;
    private GerenciadorJogos gerenciadorJogos;
    
    
    
    
    // janela da tela principal
    private JFrame janela;

    // Menus principais da tela    
    private JMenuBar menuPrincipal;
    private JMenu menuInicio;
    private JMenu menuIdioma;
    private JMenu menuAjuda;
    private JMenu cadastrarf;
    

    // Submenus da tela
    private JMenuItem menuEntrar;
    private JMenuItem menuCadastrarUsuario;
    private JMenuItem menuIdiomaPortugues;
    private JMenuItem menuIdiomaIngles;
    private JMenuItem menuSair;
    private JMenuItem menuSobre;
    private JMenuItem menuNovoJogo;
    private JMenuItem menuAvaliar;
     
    


    // Itens de menu específicos para usuários logados no sistema    
    private JMenuItem menuLogout;

    /**
     * Construtor; incializa as demais telas e sessão de usuário.
     */
    public TelaPrincipal() {
        
        telaAutenticacao = new TelaAutenticacao(this);
        telaCadastroUsuario = new TelaCadastroUsuario(this);
        sessaoUsuario = SessaoUsuario.obterInstancia();
        
        telaCadastroJogo = new TelaCadastramentoJogo(this);
        telaAvaliacao = new TelaAvaliacao(this);
        
    }

    /**
     * Inicializa a tela
     */
    public void inicializar() {
        // Serve para o caso em que o usuário
        // decidiu mudar o idioma da aplicação.
        if (janela != null) {
            janela.dispose();
        }
        construirTela();
        configurarEventosTela();
        exibirTela();
    }

    /**
     * Configura os eventos da tela.
     */
    private void configurarEventosTela() {
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Utilidades.msgConfirmacao(I18N.obterConfirmacaoSaida())) {
                    System.exit(0);
                }
            }
        });

        menuIdiomaPortugues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.PT_BR);
                inicializar();
            }
        });

        menuIdiomaIngles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.EN_US);
                inicializar();
            }
        });

        menuEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAutenticacao.inicializar();
            }
        });

        menuLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sessaoUsuario.invalidarSessao();
                inicializar();
            }
        });

        menuCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastroUsuario.inicializar();
            }
        });

        menuSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utilidades.msgInformacao(I18N.obterMensagemSobre());
            }
        });

        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (Utilidades.msgConfirmacao(I18N.obterConfirmacaoSaida())) {
                    System.exit(0);
                }
            }
        });
        
        menuNovoJogo.addActionListener(new ActionListener() {//mod filipe menuSobre
            
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastroJogo.inicializar();       
            }
        });
        
        menuAvaliar.addActionListener(new ActionListener() {//mod filipe menuSobre
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAvaliacao.inicializar();
            }
        });
    }

    /**
     * Contrói o Menu Início, trata internacionalização
     */
    private void construirMenuInicio() {
        menuInicio = new JMenu(I18N.obterMenuInicio());
        menuInicio.setMnemonic(I18N.obterMnemonicoMenuInicio());
        menuEntrar = new JMenuItem(I18N.obterMenuEntrar(), GerenciadorDeImagens.ENTRAR);
        menuCadastrarUsuario = new JMenuItem(I18N.obterMenuCadastrarUsuario(), GerenciadorDeImagens.CADASTRAR_USUARIO);
        menuLogout = new JMenuItem(I18N.obterMenuLogout(), GerenciadorDeImagens.LOGOUT);

        if (!sessaoUsuario.estahLogado()) {
            menuInicio.add(menuEntrar);
            menuInicio.add(menuCadastrarUsuario);
        } else {
            // Aqui você poderá adicionar outros itens de menu, se necessário.
            
            menuInicio.add(menuLogout);
        }

        menuSair = new JMenuItem(I18N.obterMenuSair(), GerenciadorDeImagens.SAIR);
        menuInicio.addSeparator();
        menuInicio.add(menuSair);
        menuPrincipal.add(menuInicio);
    }

    /**
     * Constrói o menu Idioma, trata internacionalização.
     */
    private void construirMenuIdioma() {
        menuIdioma = new JMenu(I18N.obterMenuIdioma());
        menuIdioma.setMnemonic(I18N.obterMnemonicoMenuIdioma());
        menuIdiomaPortugues = new JMenuItem(I18N.obterMenuIdiomaPortugues(), GerenciadorDeImagens.BANDEIRA_BR);
        menuIdiomaIngles = new JMenuItem(I18N.obterMenuIdiomaIngles(), GerenciadorDeImagens.BANDEIRA_GB);
        menuIdioma.add(menuIdiomaPortugues);
        menuIdioma.add(menuIdiomaIngles);
        menuPrincipal.add(menuIdioma);
    }

    /**
     * Constrói o menu Ajuda, trata internacionalização.
     */
    private void construirMenuAjuda() {
        menuAjuda = new JMenu(I18N.obterMenuAjuda());
        menuAjuda.setMnemonic(I18N.obterMnemonicoMenuAjuda());
        menuSobre = new JMenuItem(I18N.obterMenuSobre(), GerenciadorDeImagens.SOBRE);
        menuAjuda.add(menuSobre);
        menuPrincipal.add(menuAjuda);
    }

    /**
     * Constrói o menu Usuário, trata internacionalização.
     */
    private void construirMenuUsuario() {
        menuPrincipal = new JMenuBar();
        construirMenuInicio();
        
        if (sessaoUsuario.estahLogado()) {
             // Aqui você poderá adicionar outros menus adequados
             // ao seu projeto que serão exibidos quando o
             // usuário estiver logado no sistema.
         }        
        
        construirMenuIdioma();
        construirMenuAjuda();
        construirCadastrarFilme();
        janela.setJMenuBar(menuPrincipal);
    }

    /**
     * Constrói a tela.
     */
    private void construirTela() {
        janela = new JFrame(I18N.obterTituloTelaPrincipal());
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        construirMenuUsuario();
    }

    /**
     * Exibe a tela.
     */
    private void exibirTela() {
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Permite que apenas o botão de fechar esteja disponível na janela.        
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

        janela.setVisible(true);
    }

    /**
     * Método main, inicializa o programa.
     *
     * @param args Argumentos passados na execução do programa.
     */
    
    public GerenciadorJogos g1 = new GerenciadorJogos();
        
    public static void main(String[] args) {
        new TelaPrincipal().inicializar();
    }

    /**
     * Retorna uma referência para a janela
     *
     * @return
     */
    public JFrame obterJanela() {
        return this.janela;
    }
    //mod filipe
        
        private void construirCadastrarFilme() {
        cadastrarf = new JMenu(I18N.obterRotuloAcao());
        //cadastrarf.setMnemonic(I18N.obterMnemonicoMenuAjuda());
        menuNovoJogo = new JMenuItem(I18N.obterBotaoNovoJogo(), GerenciadorDeImagens.SOBRE);
        cadastrarf.add(menuNovoJogo);
        
        menuAvaliar = new JMenuItem(I18N.obterMenuBotaoAvaliar(), GerenciadorDeImagens.SOBRE);
       cadastrarf.add(menuAvaliar);  
        
        
        menuPrincipal.add(cadastrarf);
       // menuPrincipal.add(menuAvaliar);
    }
        //avaliacao
      /*  private void construirAvaliacao() {
        avaliacao = new JMenu(I18N.obterCadastarJogo());
        avaliacao.setMnemonic(I18N.obterMnemonicoMenuAjuda());
        menuAvaliar = new JMenuItem(I18N.obterBotaoNovoJogo(), GerenciadorDeImagens.SOBRE);
        cadastrarf.add(menuNovoJogo);
        menuPrincipal.add(avaliacao);
    }*/
}
