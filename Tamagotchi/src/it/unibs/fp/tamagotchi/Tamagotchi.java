package it.unibs.fp.tamagotchi;
import it.unibs.fp.mylib.EstrazioniCasuali;

public class Tamagotchi {
	private static final int MAX_CAREZZE = 20;
	private static final int MIN_CAREZZE = 0;
	private static final int MAX_BISCOTTI = 20;
	private static final int MIN_BISCOTTI = 0;
	private static final double FATTORE_AUMENTO_SAZIETA = 0.1;
	private static final int FATTORE_DECREMENTO_SODDISFAZIONE = 4;
	private static final int FATTORE_DECREMENTO_SAZIETA = 2;
	private static final int TRISTEZZA_MAX_SAZIETA = 80;
	private static final int TRISTEZZA_MIN_SAZIETA = 30;
	private static final int TRISTEZZA_MIN_SODDISFAZIONE = 30;
	private static final int MORTE_MIN_SODDISFAZIONE = 0;
	private static final int MORTE_MIN_SAZIETA = 0;
	private static final int MORTE_MAX_SAZIETA = 100;
	private static final int MIN_SAZIETA = 0;
	private static final int MAX_SODDISFAZIONE = 100;
	private static final int MIN_SODDISFAZIONE = 0;
	private static final int MAX_SAZIETA = 100;
	public final String FELICE = "\nSono felice!";
	public final String TRISTE = "\nSono triste!";
	public final String MORTO = "\nSono morto";
	private static final String SODDISFAZIONE = "\nSoddisfazione:";
	private static final String SAZIETA = "\nSazietà:";
	private static final String NOME = "\nNome:";
	private String nome;
	private double sazieta;
	private double soddisfazione;
	
	/**
	 * Costruttore della classe Tamagotchi
	 * @param nome
	 * @param sazieta
	 * @param soddisfazione
	 */
	public Tamagotchi(String nome, int sazieta, int soddisfazione) {
		this.nome = nome;
		this.sazieta = sazieta;
		this.soddisfazione = soddisfazione;
	}
	
	/**
	 * Metodo per assegnare un numero scelto dall'utente di biscotti
	 * @param numBiscotti
	 */
	public void riceviBiscotti(int numBiscotti){
		for(int i = 0; i < numBiscotti; i++) {
			sazieta=Math.min(MAX_SAZIETA, sazieta+sazieta*FATTORE_AUMENTO_SAZIETA);
		}
		soddisfazione=Math.max(MIN_SODDISFAZIONE, soddisfazione-numBiscotti/FATTORE_DECREMENTO_SODDISFAZIONE);
	}
	
	/**
	 * Metodo per assegnare un numero scelto dall'utente di carezze
	 * @param numCarezze
	 */
	public void riceviCarezze(int numCarezze) {
		soddisfazione=Math.min(MAX_SODDISFAZIONE, soddisfazione+numCarezze);
		sazieta=Math.max(MIN_SAZIETA, sazieta-numCarezze/FATTORE_DECREMENTO_SAZIETA);
	}
	
	/**
	 * Metodo per assegnare un numero casuale di biscotti
	 */
	public void riceviBiscotti(){
		int numBiscotti = EstrazioniCasuali.estraiIntero(MIN_BISCOTTI, MAX_BISCOTTI);
		for(int i = 0; i < numBiscotti; i++) {
			sazieta=Math.min(MAX_SAZIETA, sazieta+sazieta*FATTORE_AUMENTO_SAZIETA);
		}
		soddisfazione=Math.max(MIN_SODDISFAZIONE, soddisfazione-numBiscotti/FATTORE_DECREMENTO_SODDISFAZIONE);
		System.out.printf("Il numero di biscotti dati al Tamagotchi e': %d\n", numBiscotti);
	}

	/**
	 * Metodo per assegnare un numero casuale di carezze
	 */
	public void riceviCarezze() {
		int numCarezze = EstrazioniCasuali.estraiIntero(MIN_CAREZZE, MAX_CAREZZE);
		soddisfazione=Math.min(MAX_SODDISFAZIONE, soddisfazione+numCarezze);
		sazieta=Math.max(MIN_SAZIETA, sazieta-numCarezze/FATTORE_DECREMENTO_SAZIETA);
		System.out.printf("Il numero di carezze date al Tamagotchi e': %d\n", numCarezze);
	}
	
	/**
	 * Metodo per verificare la morte di un Tamagotchi
	 */
	public boolean sonoMorto() {
		return sazieta == MORTE_MAX_SAZIETA || sazieta == MORTE_MIN_SAZIETA || soddisfazione == MORTE_MIN_SODDISFAZIONE;
	}
	
	public double getSazieta() {
		return sazieta;
	}

	public double getSoddisfazione() {
		return soddisfazione;
	}
	
	/**
	 * Metodo per verificare se un Tamagotchi e' triste
	 * @return
	 */
	public boolean sonoTriste() {
		return(soddisfazione<TRISTEZZA_MIN_SODDISFAZIONE || sazieta<TRISTEZZA_MIN_SAZIETA || sazieta>TRISTEZZA_MAX_SAZIETA);
	}
	
	/**
	 * Metodo che restituisce il nome e lo stato del Tamagotchi
	 */
	public String toString() {
	StringBuffer descrizione=new StringBuffer();
			sazieta = (double) (Math.round(sazieta*100.0)/100.0);
			soddisfazione = (double) (Math.round(soddisfazione*100.0)/100.0);
			descrizione.append(NOME+nome);
			descrizione.append(SAZIETA+sazieta);
			descrizione.append(SODDISFAZIONE+soddisfazione);
			if(sonoTriste()) descrizione.append(TRISTE);
			if(sonoMorto()) descrizione.append(MORTO);
			return descrizione.toString();		
	}
}
//qualsiasi