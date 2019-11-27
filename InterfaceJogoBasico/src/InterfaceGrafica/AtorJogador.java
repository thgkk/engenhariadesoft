package InterfaceGrafica;

import javax.swing.JOptionPane;

import DominioDoProblema.ElementoDominioProblema;
import DominioDoProblema.Lance;
import DominioDoProblema.Movimentacao;
import Rede.AtorNetgames;

public class AtorJogador {
	
	public AtorNetgames ngServer;
	protected ElementoDominioProblema domProblema;
	protected InterfaceJogo gui;
	protected Movimentacao movimentacao;

	public AtorJogador() {
		ngServer = new AtorNetgames();
		domProblema = new ElementoDominioProblema();
	}

	public void conectar() {
		boolean conectado = ngServer.informarConectado();
		if(!conectado) {
			String jogador =JOptionPane.showInputDialog("Qual o seu nome?");
			String idServidor = ("localhost");
			idServidor = JOptionPane.showInputDialog(null, "Insira o endereço do servidor", idServidor);
			String notificacao = ngServer.conectar(idServidor, jogador);
			//.registrarJogadorLocal(jogador);
			JOptionPane.showMessageDialog(null, notificacao);
		} else {
			JOptionPane.showMessageDialog(null, "Voce ja esta conectado!");
		}
	}
	
	public String desconectar() {
		String mensagem = "Condicao para desconexao nao atendida (defina qual)";
		boolean permitido = domProblema.permitidoDesconectar();
		if (permitido) {
			mensagem = ngServer.desconectar();
			if (mensagem.equals("Sucesso: desconectado de Netgames Server")) {
				domProblema.definirConectado(false);
			}
		}
		return mensagem;
	}
	
	public String iniciarPartida() {
		String mensagem = "Condicao para iniciar partida nao atendida (defina qual)";
		boolean permitido = domProblema.permitidoIniciarPartida();
		if (permitido) {
			mensagem = ngServer.iniciarPartida();
		}
		return mensagem;
	}

	public void receberJogada(Lance lance) {
		 movimentacao.receberJogada(lance);
	}
	
	public void enviarJogada(Lance lance) {
		ngServer.enviarJogada(lance);
	}
}
