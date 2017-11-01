import java.util.Arrays;
import java.util.Random;

/**
 * Die Klasse MessApp steuert einen Messablauf, um die Performance des
 * Zufallszahlengenerators zu messen.
 */
public class MessApp {
  private Messkonduktor messkonduktor;
  private int[][] laufzeiten; 
  private int[] secondArraylaufzeiten; //is pseudonomically the second array of the multidimensional array.

  /**
   * Fuehrt eine Messung durch.
   */
  public void messen() {
    initialisieren();
    analyseDurchfuehren();
    berechneUndDruckeMittelwerteMessreihe();
    berechneUndDruckeMittelwerteMessung();
  }

  /**
   *  Diese Methode initialisiert die Messungen.
   */
  private void initialisieren() {
      laufzeiten = new int[10][20];
      messkonduktor = new Messkonduktor(400000);   
    }
 
  /**
   * Füllt gesamthaft 200 (10 * 20) Einträge von Messungen in das '2d Array' laufzeiten.
   */
  private void analyseDurchfuehren() {
      bitteWarten();
      resultateBerechnen();
      resultateAusgeben();
  }
  
  /*
   * Weist darauf hin, dass die Berechnung nun gestartet wurde, welche etwas dauert.
   */
  private void bitteWarten() {
      System.out.println("Please wait while the calculation is in progress. This may take a few seconds...");
      System.out.println();
  }
  
  /**
   * Berechnet alle Messungen der Laufzeiten pro Messung.
   */
  private void resultateBerechnen(){
      for (int x = 0; x < laufzeiten.length; x++) { //iteriert 10 mal
            secondArraylaufzeiten = new int[laufzeiten[x].length]; //an Array of 20
            laufzeiten[x] = messkonduktor.messungenDurchfuehren(secondArraylaufzeiten); //Gibt 20 mal Messungen zurück.
      }
  }
  
  /**
   * Gibt die Resultate der Messungen aus. Die Resultate werden in einer Matrix dargestellt.
   * Die Matrix enthält die Reihen und Spalten des zweidimensionalen Arrays.
   * Pro Reihe und Spalte wird eine Beschriftung angezeigt.
   */
  private void resultateAusgeben(){
      System.out.println("Resultate (in Millisekunden):");
      System.out.println();
      System.out.print("Spalten ");
      spaltenAusgeben();
      System.out.println();
      System.out.println(" Reihen");
      reihenAusgeben();
      System.out.println();
      System.out.println();
  }
  
  /*
   * Gibt die Spaltennummerierung aus.
   */
  private void spaltenAusgeben(){
      for (int j = 0; j < laufzeiten[0].length; j++){
           System.out.print(String.format("%02d", (j + 1)) + " ");
      }
  }
  
  /**
   * Gibt die Reihennummerierung aus und gibt alle Messdaten für alle Messreihen aus.
   */
  private void reihenAusgeben(){
      for (int i = 0; i < laufzeiten.length; i++){
          System.out.print("   " + (String.format("%02d", (i + 1))) + "   ");
          for (int j = 0; j < laufzeiten[i].length; j++){
            System.out.print(laufzeiten[i][j]);
            System.out.print(" ");
          }
          System.out.println();
      }
  }
  
  /**
   * Berechnet und druckt den Mittelwert von jeder 'Reihe'.
   */
  private void berechneUndDruckeMittelwerteMessreihe() {
        System.out.println("Mittelwerte Messreihen:");
        System.out.println();
        for (int i = 0; i < laufzeiten.length; i++){ //Iteriert 10 mal
            int summe = 0;
            for (int j = 0; j < laufzeiten[i].length; j++){ //iteriert 20 mal
                summe += laufzeiten[i][j]; //adds up all values per 'row'.
            }
            int mittelwert = summe / laufzeiten[i].length;
            System.out.println("mw Messreihe " + (String.format("%02d", (i + 1))) + ": " + mittelwert + "ms");
        }
        System.out.println();
        System.out.println();
  }
  
  /**
   * Berechnet und druckt den Mittelwert von jeder 'Spalte'.
   */
  private void berechneUndDruckeMittelwerteMessung() {
        System.out.println("Mittelwerte Messspalten:");
        System.out.println();
        for (int j = 0; j < secondArraylaufzeiten.length; j++){ //Iteriert 20 mal
            int summe = 0;
            for (int i = 0; i < laufzeiten.length; i++){ //iteriert 10 mal
                summe += laufzeiten[i][j]; //adds up all values per 'column'.
            }
            int mittelwert = summe / laufzeiten.length; //calculates the mittelwert.
            System.out.println("mw Messspalte " + (String.format("%02d", (j + 1))) + ": " + mittelwert + "ms");
        }
        System.out.println();
  }
}