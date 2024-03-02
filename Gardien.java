//NISTOR Iarina
public class Gardien extends Contenu{
  private int pointsVie;
  public Gardien(int quantite){
    super("Gardiens",quantite);
    this.pointsVie = (int)(Math.random()*201);
  }
  public int getPointsVie(){
    return pointsVie;
  }
  public void decreasePointsVie(int p){
    pointsVie -= p;
  }
  public String toString(){
  	return "Gardien"+super.toString()+" pointsVie: "+pointsVie;
  }
}
