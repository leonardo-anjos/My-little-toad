package ffb;

import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sapo extends Personagem implements Serializable {

	private static final long serialVersionUID = -5974501580700393665L;

	private JLabel jlabel_sapo;
	private Rectangle rectangle_sapo;
	private ImageIcon img_sapo;

	int count = 0;

	public Sapo() {

	}

	public Sapo(int x, int y, int velocidade, int heigth, int width, int life, int strength) {
		super(x, y, heigth, width, velocidade);
		this.rectangle_sapo = new Rectangle(x, y, heigth, width);
		this.setImg(new ImageIcon(getClass().getResource("sapo.gif")));
		this.img_sapo = new ImageIcon(getClass().getResource("sapo.gif"));
		this.jlabel_sapo = new JLabel(this.getImg());
		this.jlabel_sapo.setBounds(rectangle_sapo);

		this.setLife(life);
		this.setStrength(strength);
	}

	public JLabel getJlabel_sapo() {
		return jlabel_sapo;
	}

	public Rectangle getRectangle_sapo() {
		return rectangle_sapo;
	}

	public boolean comer(Inseto inseto) throws ColisaoException {
		if (rectangle_sapo.intersects(inseto.getRectangle_inseto())) {
			this.setLife(this.getLife() + 1);
			this.setStrength(this.getStrength() + 100);
			count++;
			throw new ColisaoException();
		}
		return false;
	}

	public void moverCima() {
		if (this.getY() > 0) {
			super.moverCima();
			rectangle_sapo.y -= this.getVelocidade();
			this.jlabel_sapo.setIcon(img_sapo);
			this.jlabel_sapo.setBounds(rectangle_sapo);
		}
	}

	public void moverBaixo() {
		if (this.getY() < 350) {
			super.moverBaixo();
			rectangle_sapo.y += this.getVelocidade();
			this.jlabel_sapo.setIcon(getImg());
			this.jlabel_sapo.setBounds(rectangle_sapo);
		}
	}

	public void moverDireita() {
		if (this.getX() < 700) {
			super.moverDireita();
			this.jlabel_sapo.setIcon(img_sapo);
			rectangle_sapo.x += this.getVelocidade();
			this.jlabel_sapo.setBounds(rectangle_sapo);
		}
	}

	public void moverEsquerda() {
		if (this.getX() > 0) {
			super.moverEsquerda();
			rectangle_sapo.x -= this.getVelocidade();
			this.jlabel_sapo.setIcon(img_sapo);
			this.jlabel_sapo.setBounds(rectangle_sapo);
		}
	}

}