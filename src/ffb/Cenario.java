package ffb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Cenario extends Personagem implements Runnable, Serializable {

	private ArrayList<Inseto> lista_insetos = new ArrayList<Inseto>();
	private Thread SecondTasksd = new Thread(this);
	private JLabel cenario_jlabel, lbltexto;
	private Sapo sapo;
	private int Points;

	public Cenario() {
		exibirCenario();
		pontuacao();
		sapo = new Sapo(0, 0, 40, 100, 100, 1, 100);
		exibirInsetos();
		arquivo();
	}

	public Inseto getLista_insetos(int i) {
		return lista_insetos.get(i);
	}

	public Thread getSecondTasksd() {
		return SecondTasksd;
	}

	public int getPoints() {
		return Points;
	}

	public JLabel getLbltexto() {
		return lbltexto;
	}

	public Sapo getSapo() {
		return sapo;
	}

	public void setSapo(Sapo sapo) {
		this.sapo = sapo;
	}

	public JLabel getCenario_jlabel() {
		return cenario_jlabel;
	}

	// metodos a serem chamados no construtor de Cenario
	public void exibirCenario() {
		this.setImg(new ImageIcon(getClass().getResource("cenario.png")));
		this.cenario_jlabel = new JLabel(this.getImg());
		this.cenario_jlabel.setBounds(0, 0, 800, 500);
	}

	public void pontuacao() {
		this.lbltexto = new JLabel("Ponto(s): 0");
		this.lbltexto.setBounds(700, 0, 500, 50);
	}

	public void exibirInsetos() {
		int i, w;
		for (i = 0, w = 0; i < 4; i++, w += 300) {
			lista_insetos.add(new Inseto(500, w, 32, 32));
		}
	}

	private void arquivo() {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Leonardo\\Desktop\\meuSapinho.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(Points);

			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			System.out.println("file not exists");
		} catch (IOException e) {
			System.out.println("erro de io");
		}

	}// fim do arquivo

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int d = 0, n = 0, i = 0;
		while (true) {
			try {
				// tempo para surgir o mosquito
				Thread.sleep(1000);
			} catch (Exception erro) {
			}

			for (i = 0; i < 4; i++) {
				lista_insetos.get(i).insetosAleatorios();

				try {
					sapo.comer(lista_insetos.get(i));
					this.setStrength(this.getStrength() + 100);
					if (this.getPoints() == 5) {
						this.setLife(this.getLife() + 1);
					}

				} catch (ColisaoException e) {
					System.out.println(Points);
					//this.lbltexto.setText("Ponto(s): " + this.Points++);
					//this.lbltexto.setBounds(700, 0, 500, 50);
				}

			}
			/*
			 * if (this.getLife() == 0 || this.getStrength() == 0) {
			 * JOptionPane.showMessageDialog(null, "Seu sapinho morreu! :(" );
			 * System.exit(0); }
			 */

			if (this.getPoints() == 10) {
				JOptionPane.showMessageDialog(null, "Parabéns! Você venceu!\n" + "Pontuação: " + this.getPoints());
				System.exit(0);
			}

		}
	}

}
