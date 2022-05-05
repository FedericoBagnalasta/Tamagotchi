package it.unibs.fp.tamagotchi;

public class Tamagotchi {
	private static final double FATTORE_AUMENTO_SAZIETA = 0.1;
	private static final int FATTORE_DECREMENTO_SODDISFAZIONE = 4;
	private static final int FATTORE_DECREMENTO_SAZIETA = 2;
	private static final int FELICITA_SODDISFAZIONE = 80;
	private static final int FELICITA_SAZIETA = 80;
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
	public final String FELICE = "\nSono felice";
	public final String TRISTE = "\nSono triste";
	public final String MORTO = "\nSono morto";
	private static final String SODDISFAZIONE = "\nSoddisfazione:";
	private static final String SAZIETA = "\nSazietà:";
	private static final String NOME = "Nome:";
	private String nome;
	private double sazieta;
	private double soddisfazione;
	
	public Tamagotchi(String nome, int sazieta, int soddisfazione) {
		this.nome = nome;
		this.sazieta = sazieta;
		this.soddisfazione = soddisfazione;
	}
	
	public void daiBiscotti(int numBiscotti){
		for(int i = 0; i < numBiscotti; i++) {
			sazieta=Math.min(MAX_SAZIETA, sazieta+sazieta*FATTORE_AUMENTO_SAZIETA);
		}
		soddisfazione=Math.max(MIN_SODDISFAZIONE, soddisfazione-numBiscotti/FATTORE_DECREMENTO_SODDISFAZIONE);
	}

	public void daiCarezze(int numCarezze) {
		soddisfazione=Math.min(MAX_SODDISFAZIONE, soddisfazione+numCarezze);
		sazieta=Math.max(MIN_SAZIETA, sazieta-numCarezze/FATTORE_DECREMENTO_SAZIETA);
	}
	
	public boolean sonoMorto() {
		return sazieta == MORTE_MAX_SAZIETA || sazieta == MORTE_MIN_SAZIETA || soddisfazione == MORTE_MIN_SODDISFAZIONE;
	}
	
	public double getSazieta() {
		return sazieta;
	}

	public double getSoddisfazione() {
		return soddisfazione;
	}
	
	public boolean sonoTriste() {
		return(soddisfazione<TRISTEZZA_MIN_SODDISFAZIONE || sazieta<TRISTEZZA_MIN_SAZIETA || sazieta>TRISTEZZA_MAX_SAZIETA);
	}
	
	public boolean sonoFelice() {
		return(sazieta>FELICITA_SAZIETA || soddisfazione>FELICITA_SODDISFAZIONE);
	}
	
	public String toString() {
		StringBuffer descrizione=new StringBuffer();
			descrizione.append(NOME+nome);
			descrizione.append(SAZIETA+sazieta);
			descrizione.append(SODDISFAZIONE+soddisfazione);
			if(sonoTriste()) descrizione.append(TRISTE);
			if(sonoFelice() && !sonoTriste()) descrizione.append(FELICE);
			if(sonoMorto()) descrizione.append(MORTO);
			return descrizione.toString();
			
	}

}
