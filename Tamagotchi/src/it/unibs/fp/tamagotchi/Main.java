package it.unibs.fp.tamagotchi;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Main {

	private static final String DAI_CAREZZE = "Dai carezze";
	private static final String DAI_BISCOTTI = "Dai biscotti";
	private static final String NUM_BISCOTTI = "Inserire il numero di biscotti";
	private static final String NUM_CAREZZE = "Inserire numero carezze";
	private static final String RICHIESTA_SODDISFAZIONE = "Inserisci il valore iniziale di soddisfazione (da 0 a 100): ";
	private static final String RICHIESTA_SAZIETA = "inserisci il valore iniziale di sazieta' (da 0  a 100) : ";
	private static final String RICHIESTA_NOME = "come si chiama il tuo Tamagotchi?";
	private static final int MAX_SAZIETA = 100;
	private static final String Scelta = "Scegli l'opzione";
	private static final String SALUTO = "Benvenuto nel mondo del Tamagotchi!";

	public static void main(String[] args) {
		System.out.println(SALUTO);
		
		String[] voci = {DAI_BISCOTTI, DAI_CAREZZE};
		int scelta=0, numBiscotti, numCarezze;
		Tamagotchi tamagotchi = creaTamagotchi();
		MyMenu menu=new MyMenu(Scelta, voci);
		do {
			scelta=menu.scegli();
			switch(scelta) {
				case 1:
					numBiscotti=InputDati.leggiIntero(NUM_BISCOTTI, 0, 20);
					tamagotchi.daiBiscotti(numBiscotti);
					break;
				case 2:
					numCarezze=InputDati.leggiIntero(NUM_CAREZZE, 0, 20);
					tamagotchi.daiCarezze(numCarezze);
					break;
				default:
					break;
			}
			System.out.println(tamagotchi.toString());
		}while(scelta!=0);
	}
	
	//bagna puzza

	private static Tamagotchi creaTamagotchi() {
		String nome=InputDati.leggiStringaNonVuota(RICHIESTA_NOME);
		int sazieta=InputDati.leggiIntero(RICHIESTA_SAZIETA, 0, MAX_SAZIETA);
		int soddisfazione=InputDati.leggiIntero(RICHIESTA_SODDISFAZIONE, 0, 100);
		
		Tamagotchi tamagotchi=new Tamagotchi(nome, sazieta, soddisfazione);
		return tamagotchi;
	}

}
