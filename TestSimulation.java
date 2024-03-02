import java.util.ArrayList;
//NISTOR Iarina
public class TestSimulation{
	public static void main(String[] args){
		
		Grille grille = new Grille(7,8);
		Agent1 agent = new Agent1(3,3,grille);
		grille.affiche(2);
		Simulation s;
		try{
			s = new Simulation(agent,grille,5);
			grille.affiche(2);
			System.out.println(s);
			s.lance(50);
			grille.affiche(2);
			System.out.println(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
