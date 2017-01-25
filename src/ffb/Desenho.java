package ffb;

import javax.swing.ImageIcon;

public class Desenho {

	private int x;
	private int y;
	private int height, width;
	private ImageIcon img;

	public Desenho() {
	}

	public Desenho(int x, int y, int height, int width) {
		super();
		this.setX(x);
		this.setY(y);
		this.setHeight(height);
		this.setWidth(width);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public ImageIcon getImg() {
		return img;
	}

}