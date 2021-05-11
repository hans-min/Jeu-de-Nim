import java.util.Scanner;

public class JeuDeNim {
	
	public static void main (String args[]) { // version Jeu à deux joueurs humains
		// Initialisation
		final int N = 5;
		final int MAX_PIONS = 20;
		int[] t = genereTabInit(N, MAX_PIONS);
		int noTas; //numéro du tas choisi
		int nbPions; //nombre de pions à retirer
		
		System.out.println("Etat du jeu :");
		afficheTab(t);
		
		int quelJoueur = 1 ;
		
		while (! fini(t)){
			// Choix du tas
			System.out.println("Joueur"+quelJoueur+", quel tas ?");
			noTas = saisirEntreBornes(0,N-1);
			while (t[noTas]==0) { // Cas tas vide
				System.out.println("Tas vide ! Choisissez un autre tas !");
				afficheTab(t);
				System.out.println("Joueur"+quelJoueur+", quel tas ?");
				noTas = saisirEntreBornes(0,N-1);
			}
	
			// Choix du nombre de pions
			System.out.println("Combien de pions prendre ?");
			nbPions = saisirEntreBornes(1,t[noTas]);
	
			// Mise à jour du nombre de pions du tas
			t[noTas] = t[noTas]-nbPions;
	
			// Affichage du jeu en fin de tour
			System.out.println("Etat du jeu :");
			afficheTab(t);	
			
			// On change de joueur si ce n'est pas fini
			if(!fini(t)){
				quelJoueur = (quelJoueur%2)+1; //on change de joueur	
			}
		}
		// Annonce du vainqueur
        System.out.println("Le gagnant est "+ quelJoueur);
	}
    
    /*public static void main (String args[]) { // version de test
        System.out.println("******************************************");
        System.out.println("Test de saisirEntreBornes entre 0 et 4");
        System.out.println("Saisie 1 : 5, Saisie 2 : -1, Saisie 3 : 1");
        System.out.println("C'est bon "+saisirEntreBornes(0,4));
        
        System.out.println("******************************************");
        System.out.println("Test de afficheTab");
        int []t = {0,1,2,3};
        afficheTab(t);
        System.out.println("C'est bon ");
        
        System.out.println("******************************************");
        System.out.println("Test de genereTabInit");
        afficheTab(genereTabInit(1,5));
        System.out.println("C'est bon ");

        System.out.println("******************************************");
        System.out.println("Test de fini");
        int[]t1={4,0,0};
        System.out.println("fini 1 "+fini(t1));
        t1[0] = 0;
        System.out.println("fini 2 "+fini(t1));
    }*/
    
    public static int saisirEntreBornes(int bInf, int bSup){
        Scanner sc = new Scanner(System.in);
		int res = 0;
		do {
			System.out.println("Donnez une valeur entre "+ bInf +" et "+ bSup);
			res = sc.nextInt();
			if (res<bInf) {
				System.out.println("La borne min est " + bInf);
            } else if (res>bSup) {
				System.out.println("La borne max est "+ bSup);
            }
		} while (res<bInf ||res>bSup);
		return res;
	}
    
    public static void afficheTab(int[] t){
		for(int i =0; i<t.length ; i++){
			System.out.print(t[i]+ " ");
		}
		System.out.println();
	}
    
    public static int[] genereTabInit(int nbTas, int nbPionsMax){
		int[] res = new int[nbTas];
		for(int i = 0; i<res.length; i++){
			res[i] = (int) (1+Math.random()*nbPionsMax);
		}
		return res;
	}
    
    public static boolean fini(int[] t){ //version avec un while
		boolean existNonNul = false ;
		int i = 0 ;
		while (! existNonNul && i<t.length){
			if (t[i]!=0) {
				existNonNul = true;
			}
			i++;
		}
		return !existNonNul;
	}
}
