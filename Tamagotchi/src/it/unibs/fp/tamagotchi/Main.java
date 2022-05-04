package it.unibs.fp.tamagotchi;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Main {

	private static final int MAX_SODDISFAZIONE_INIZIALE= 99;
	private static final int MIN_SODDISFAZIONE_INIZIALE= 1;
	private static final int MAX_SAZIETA_INIZIALE= 99;
	private static final int MIN_SAZIETA_INIZIALE= 1;
	private static final int MAX_CAREZZE = 20;
	private static final int MIN_CAREZZE = 0;
	private static final int MAX_BISCOTTI = 20;
	private static final int MIN_BISCOTTI = 0;
	private static final String DAI_CAREZZE = "Dai carezze";
	private static final String DAI_BISCOTTI = "Dai biscotti";
	private static final String NUM_BISCOTTI = "Inserire il numero di biscotti";
	private static final String NUM_CAREZZE = "Inserire il numero di carezze";
	private static final String RICHIESTA_SODDISFAZIONE = "Inserisci il valore iniziale di soddisfazione (da 1 a 99): ";
	private static final String RICHIESTA_SAZIETA = "Inserisci il valore iniziale di sazieta' (da 1 a 99): ";
	private static final String RICHIESTA_NOME = "Come si chiama il tuo Tamagotchi?";
	private static final String SCELTA = "Scegli l'opzione";
	private static final String SALUTO = "Benvenuto nel mondo del Tamagotchi!";
	

	public static void main(String[] args) {
		System.out.println(SALUTO);
		
		String[] voci = {DAI_BISCOTTI, DAI_CAREZZE};
		int scelta=0, numBiscotti, numCarezze;
		Tamagotchi tamagotchi = creaTamagotchi();
		MyMenu menu=new MyMenu(SCELTA, voci);
		do {
			scelta=menu.scegli();
			switch(scelta) {
				case 1:
					numBiscotti=InputDati.leggiIntero(NUM_BISCOTTI, MIN_BISCOTTI, MAX_BISCOTTI);
					tamagotchi.daiBiscotti(numBiscotti);
					break;
				case 2:
					numCarezze=InputDati.leggiIntero(NUM_CAREZZE, MIN_CAREZZE, MAX_CAREZZE);
					tamagotchi.daiCarezze(numCarezze);
					break;
				default:
					break;
			}
			System.out.println(tamagotchi.toString());
		}while(scelta!=0 || !tamagotchi.sonoMorto());
	}

	private static Tamagotchi creaTamagotchi() {
		String nome=InputDati.leggiStringaNonVuota(RICHIESTA_NOME);
		int sazieta=InputDati.leggiIntero(RICHIESTA_SAZIETA, MIN_SAZIETA_INIZIALE, MAX_SAZIETA_INIZIALE);
		int soddisfazione=InputDati.leggiIntero(RICHIESTA_SODDISFAZIONE, MIN_SODDISFAZIONE_INIZIALE, MAX_SODDISFAZIONE_INIZIALE);
		
		Tamagotchi tamagotchi=new Tamagotchi(nome, sazieta, soddisfazione);
		return tamagotchi;
	}

}
