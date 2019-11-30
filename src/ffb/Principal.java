package ffb;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private static final long serialVersionUID = 5337795894807525294L;

	static Cenario cenario;
	private int tempoJogo = 30;
	JLabel cronometroJogo = new JLabel(Integer.toString(tempoJogo));
	
	public int getTempoJogo() {
		return this.tempoJogo;
	}

	public void setTempoJogo(int tempoJogo) {
		this.tempoJogo = tempoJogo;
	}

	public void editarJanela() {
		Font fonte = new Font("Arial", Font.BOLD, 20);
		add(BorderLayout.NORTH, cronometroJogo);

		cronometroJogo.setHorizontalAlignment(SwingConstants.CENTER);
		cronometroJogo.setFont(fonte);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setResizable(false);
	}

	private void cronometro() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (this.getTempoJogo() == 0) {
				JOptionPane.showMessageDialog(null, "fim de jogo!");
				System.exit(0);
			} else {
				this.setTempoJogo(this.getTempoJogo() - 1);
				cronometroJogo.setText(Integer.toString(this.getTempoJogo()));
			}

		}
	}

	public Principal() {
		super("meu sapinho - developed by::Leonardo Anjos");
		
		this.setTempoJogo(30);

		cenario = new Cenario();

		editarJanela();

		add(cenario.getSapo().getJlabel_sapo());

		for (int insetos = 0; insetos < 3; insetos++) {
			add(cenario.getLista_insetos(insetos).getJlabel_inseto());			
		}

		add(cenario.getLbltexto());

		// movimento aleatorio dos mosquitos
		cenario.getSecondTasksd().start();

		add(cenario.getCenario_jlabel());

		Movimentar();

		cronometro();
	}

	public void Movimentar() {
		addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 38) {
					cenario.getSapo().moverCima();
				}

				if (e.getKeyCode() == 40) {
					cenario.getSapo().moverBaixo();
				}

				if (e.getKeyCode() == 37) {
					cenario.getSapo().moverEsquerda();
				}

				if (e.getKeyCode() == 39) {
					cenario.getSapo().moverDireita();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public static void main(String[] args) {
		new Principal();
	}
}
