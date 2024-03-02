public class GardienTeleportable extends Gardien implements Teleportable{
	public GardienTeleportable(int quantite){
		super(quantite);
	}
	public void seTeleporter(int x, int y){
		this.setPosition((int)(Math.random()*x),(int)(Math.random()*y))
	}
	
}
