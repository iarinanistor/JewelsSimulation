//NISTOR Iarina
public class Joyau extends Contenu{
  private double prix;
  public Joyau(int quantite){
    super("Joyaux",quantite);
    this.prix = Math.random()*1000;
  }
  public double getPrix(){
    return prix;
  }
  public String toString(){
  	return "Joyau"+super.toString()+" prix: "+String.format("%.2f",prix);
  }
}
