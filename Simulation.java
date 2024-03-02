//NISTOR Iarina 
import java.util.ArrayList;
import java.util.Random;
public class Simulation{
  private Agent1 agent;
  private Grille grille;
  private Contenu[][] tab;
  public Simulation(Agent1 a,Grille g,int m) throws CoordonneesIncorrectesException{
  //m doit etre plus petite que nbLignes*nbColonnes
  	Random random = new Random();
    grille = g;
    agent = a;
    for (int i = 0;i<m;i++){
    	int ligne = random.nextInt(grille.nbLignes);
        int colonne = random.nextInt(grille.nbColonnes);
         while(!grille.caseEstVide(ligne,colonne)){
           	ligne = random.nextInt(grille.nbLignes);
        	colonne = random.nextInt(grille.nbColonnes);
         } 
         if (Math.random()<0.5){
         	grille.setCase(ligne,colonne,new Gardien(10));
         }else{
         	grille.setCase(ligne,colonne,new Joyau(10));
         }
    }
  }
  
  public String toString(){
    String s="";
    for (Contenu c : grille.lesContenus()){
      s+=c.toString()+"\n";  
    }
    s+=agent.toString()+"\n";
    return s;
  }
  
  public void lance(int nbEtapes){  
  	int xnew=agent.getPosx();
  	int ynew = agent.getPosy();
    while(nbEtapes>0){
    	double x = Math.random();
    	if (x<0.25){
    		xnew = agent.getPosx()+1;
    	}
    	else if (x<0.5){
    		xnew = agent.getPosx()-1;
    	}
    	else if (x<0.75){
    		ynew = agent.getPosy()+1;
    	}
    	else{
    		ynew = agent.getPosy()-1;
    	}
    	if(Math.random()<0.3){
      		int f = (int)(Math.random()*91+10);
      		try {
      			agent.seDeplacer(xnew,ynew,f);
      		} catch (Exception e){
      			System.out.println(e.getMessage());
      			nbEtapes++;
      		}
    	} else {
    		try {
      			agent.seDeplacer(xnew,ynew);
      		} catch (Exception e){
      			System.out.println(e.getMessage());
      			nbEtapes++;
      		}
    	}
    	nbEtapes--;
    }
  }
  
  
}
