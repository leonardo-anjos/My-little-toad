package ffb;

public class Personagem extends Desenho implements Movimentos {

	private int life;
	private int strength;
	private int velocidade;

	public Personagem() {
	}

	public Personagem(int x, int y, int height, int width) {
		super(x, y, height, width);
	}

	public Personagem(int x, int y, int height, int width, int vel) {
		super(x, y, height, width);
		this.setVelocidade(vel);
	}


	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	@Override
	public void moverDireita() {
		// TODO Auto-generated method stub
		this.setX(this.getX() + velocidade);
	}

	@Override
	public void moverEsquerda() {
		// TODO Auto-generated method stub
		this.setX(this.getX() - velocidade);
	}

	@Override
	public void moverCima() {
		// TODO Auto-generated method stub
		this.setY(this.getY() - velocidade);
	}

	@Override
	public void moverBaixo() {
		// TODO Auto-generated method stub
		this.setY(this.getY() + velocidade);
	}

}