//NISTOR Iarina
import java.util.ArrayList;
public class Agent1{
  private int posx,posy;
  ArrayList<Joyau> sac; 
  private Grille grille;
  public Agent1(int posx,int posy,Grille g){
    this.posx = posx;
    this.posy = posy;
    sac = new ArrayList<>();
    grille = g;
  }
  public void seDeplacer(int xnew,int ynew) throws DeplacementIncorrectException,CoordonneesIncorrectesException,CaseNonPleineException{
    if (grille.sontValides(xnew,ynew)) {
      posx = xnew;
      posy = ynew;
    } else throw new DeplacementIncorrectException("deplacement incorrect");
    if (grille.getCase(xnew,ynew) instanceof Gardien){
      sac.clear();
    }else if (grille.getCase(xnew,ynew) instanceof Joyau){
      sac.add((Joyau)grille.getCase(xnew,ynew));
       grille.videCase(xnew,ynew);
    }
  }
  public void seDeplacer(int xnew,int ynew,int f) throws DeplacementIncorrectException,CoordonneesIncorrectesException,CaseNonPleineException{
    if (grille.sontValides(xnew,ynew)) {
      posx = xnew;
      posy = ynew;
    } else throw new DeplacementIncorrectException("deplacement incorrect");
    if (grille.getCase(xnew,ynew) instanceof Joyau){
      sac.add((Joyau)(grille.getCase(xnew,ynew)));
      grille.videCase(xnew,ynew);
    } else if (grille.getCase(xnew,ynew) instanceof Gardien) {
      if (f>((Gardien)grille.getCase(xnew,ynew)).getPointsVie()){
        grille.videCase(xnew,ynew);
      } else {
        sac.clear();
        ((Gardien)(grille.getCase(xnew,ynew))).decreasePointsVie(f);
      } 
    } 
  }
  
  public double fortune(){
    double s = 0;
    for (Joyau j : sac){
      s+= j.getPrix();
    }
    return s;
  }
  public int getPosx(){
    return posx;
  }
  public void setPosx(int x){
  	posx = x;
  }
  public int getPosy(){
    return posy;
  }
  public void setPosy(int y){
  	posy = y;
  }
  public void contenuSac(){
    for (Joyau j : sac){
      System.out.println(j);
    }
  }
  public String toString(){
  	return "Agent1  position = ("+posx+","+posy+")"+" fortune : "+fortune();
  }
  
}
