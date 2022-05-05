package it.unibs.fp.tamagotchi;

public class TamagotchiTest {

	public static void main(String[] args) {
		System.out.println("Creo un tamagotchi e gli do' da mangiare per 100 volte e il risultato atteso e' che il tamagotchi1 muoia");
		Tamagotchi tamagotchi1 = new Tamagotchi("Pippo", 50, 50);
		int numPasti = 100;
		for(int i = 0; i < numPasti; i++) {
			tamagotchi1.riceviBiscotti();
			System.out.println(tamagotchi1.toString());
			if(tamagotchi1.sonoMorto()) {
				System.out.println("Il tamagotchi1 e' morto");
				break;
			}
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------------");
		
		System.out.println("Creo un tamagotchi e gli do' carezze per 100 volte e il risultato atteso e' che il tamagotchi2 muoia");
		Tamagotchi tamagotchi2 = new Tamagotchi("Pluto", 40, 40);
		int numCarezze = 100;
		for(int i = 0; i < numCarezze; i++) {
			tamagotchi2.riceviCarezze();
			System.out.println(tamagotchi2.toString());
			if(tamagotchi2.sonoMorto()) {
				System.out.println("Il tamagotchi2 e' morto");
				break;
			}
		}
	}
}