package ffb;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Inseto extends Personagem implements Serializable {

	private JLabel jlabel_inseto;
	private Rectangle rectangle_inseto;

	public Inseto() {
		
	}
	
	public Inseto(int x, int y, int hight, int width) {
		super(x, y, hight, width);
		this.rectangle_inseto = new Rectangle(x, y, hight, width);
		this.setImg(new ImageIcon(getClass().getResource("inseto.gif")));
		this.jlabel_inseto = new JLabel(this.getImg());
		this.jlabel_inseto.setBounds(rectangle_inseto);
	}

	/*
	 * // gets/sets public Rectangle setRectangle_inseto() { return
	 * rectangle_inseto; }
	 * 
	 * public void setRectangle_inseto(Rectangle rectangle_inseto) {
	 * this.rectangle_inseto = rectangle_inseto; }
	 * 
	 * public JLabel getJlabel_inseto() { return jlabel_inseto; }
	 */

	public JLabel getJlabel_inseto() {
		return jlabel_inseto;
	}

	public void setJlabel_inseto(JLabel jlabel_inseto) {
		this.jlabel_inseto = jlabel_inseto;
	}

	public Rectangle getRectangle_inseto() {
		return rectangle_inseto;
	}

	public void setRectangle_inseto(Rectangle rectangle_inseto) {
		this.rectangle_inseto = rectangle_inseto;
	}

	// metodos concretos
	public void insetosAleatorios() {
		Random n_aleatorio = new Random();
		rectangle_inseto.x = n_aleatorio.nextInt(300);
		rectangle_inseto.y = n_aleatorio.nextInt(900);
		this.jlabel_inseto.setBounds(rectangle_inseto);
	}

}