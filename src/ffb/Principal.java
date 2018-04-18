package ffb;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	JLabel tempo = new JLabel("30");
	private int segundos = 30;

	public int getSegundos() {
		return segundos;
	}

	public void SetSegundos(int segundos) {
		this.segundos = segundos;
	}

	static Cenario cenario;

	public void editarJanela() {
		Font fonte = new Font("Arial", Font.BOLD, 20);
		add(BorderLayout.NORTH, tempo);

		tempo.setHorizontalAlignment(SwingConstants.CENTER);
		tempo.setFont(fonte);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setResizable(false);
	}

	private void cronometro() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (this.getSegundos() == 0) {
				JOptionPane.showMessageDialog(null, "Tempo Excedido!");
				System.exit(0);
			} else {
				this.SetSegundos(this.getSegundos() - 1);
				;
				tempo.setText(this.segundos + "");
			}

		}
	}

	public Principal() {
		super("meuSapinho Developed by::Leonardo Anjos");

		cenario = new Cenario();

		editarJanela();

		add(cenario.getSapo().getJlabel_sapo());

		for (int moedas = 0; moedas < 3; moedas++)
			add(cenario.getLista_insetos(moedas).getJlabel_inseto());

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

			public void keyReleased(KeyEvent e) {
				// System.out.println("" + e.getKeyCode());
			}

			public void keyTyped(KeyEvent e) {

			}
		});
	}

	public static void main(String[] args) {

		new Principal();

	}
}
