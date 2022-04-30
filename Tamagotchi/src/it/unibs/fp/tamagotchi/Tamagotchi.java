package it.unibs.fp.tamagotchi;

public class Tamagotchi {
	public final String FELICE = "\nSono felice";
	public final String TRISTE = "\nSono triste!";
	private static final String SODDISFAZIONE = "\nSoddisfazione:";
	private static final String SAZIETA = "\nSazietà";
	private static final String NOME = "Nome:";
	private String nome;
	private int sazieta;
	private int soddisfazione;
	
	public Tamagotchi(String nome, int sazieta, int soddisfazione) {
		this.nome = nome;
		this.sazieta = sazieta;
		this.soddisfazione = soddisfazione;
	}
	
	 public void daiBiscotti(int numBiscotti){
		 sazieta=Math.min(100, sazieta+numBiscotti);
		 soddisfazione=Math.max(0, soddisfazione-5);
	 }

	public void daiCarezze(int numCarezze) {
		soddisfazione=Math.min(100, soddisfazione+numCarezze);
		sazieta=Math.max(0, sazieta-5);
	}
	
	public int getSazieta() {
		return sazieta;
	}

	public int getSoddisfazione () {
		return soddisfazione;
	}
	
	public boolean isTriste() {
		return(sazieta<30 || soddisfazione<30);
	}
	
	public boolean isFelice() {
		return(sazieta>80 || soddisfazione>80);
	}
	
	public String toString() {
		StringBuffer descrizione =new StringBuffer ();
			descrizione.append(NOME+nome);
			descrizione.append(SAZIETA+sazieta);
			descrizione.append(SODDISFAZIONE+soddisfazione);
			if(isTriste()) descrizione.append(TRISTE);
			if(isFelice() && !isTriste()) descrizione.append(FELICE);
			return descrizione.toString();
			
	}

}
