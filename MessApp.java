import java.util.Arrays;
import java.util.Random;

/**
 * Die Klasse MessApp steuert einen Messablauf, um die Performance des
 * Zufallszahlengenerators zu messen.
 */
public class MessApp {
  private Messkonduktor messkonduktor;
  int[] messAnzahl = new int[400000];
  int[][] laufzeiten = new int[10][20];

  /**
   * Fuehrt eine Messung durch.
   */
  public void messen() {
    initialisieren();
    /*analyseDurchfuehren();
    berechneUndDruckeMittelwerteMessreihe();
    berechneUndDruckeMittelwerteMessung();*/
  }

  /**
   * Diese Methode generiet 400'000 Zahlen und speichert dessen Messwerte in dem Mehrdimensionalen Array
   * "laufzeiten"
   */
  
  private void initialisieren() {
        // Beide for-loops füllen alle 200 Einträge des Multidimensionalen Arrays:
        for (int j = 0; j < laufzeiten.length; j++) { //Iteriert 10 mal
            for (int k = 0; k < laufzeiten[0].length; k++){ //iteriert 20 mal
                laufzeiten[k] = messkonduktor.messungenDurchfuehren(messAnzahl); 
                //gibt 400000mal eine Messung mit Zufallszahl und dessen Laufzeit zurück.
            }
        }
    }
 
  private void analyseDurchfuehren() {
    // durchzufuehren und in der Objektsammlung zu speichern.
  }

  private void berechneUndDruckeMittelwerteMessreihe() {
        int[] mittelwert = new int[10]; //equal to the lenght of Messreihen.
        int summe = 0;
      
        //berechnet den Mittelwert von jeder Reihe:
        for (int j = 0; j < laufzeiten.length; j++){ //Iteriert 10 mal
            for (int k = 0; k < laufzeiten[0].length; k++){ //iteriert 20 mal
                summe += laufzeiten[j][k]; //adds up the sum for each placeholder in k.
            }
            mittelwert[j] = summe / laufzeiten.length; //calculates the mittelwert.
            summe = 0; //reset the sum for calculating the mittelwert of the next row (j) correctly.
        }
        
        //Gibt den Mittelwert von jeder Reihe aus:
        for (int m : mittelwert) {
            System.out.println(m);
        }
  }

  private void berechneUndDruckeMittelwerteMessung() {
      int[] mittelwert = new int[200]; //represents the total amount of placeholders in the multi-dimensional array.
      int summe = 0;
      for (int j = 0; j < laufzeiten.length; j++){ //Iteriert 10 mal
            for (int k = 0; k < laufzeiten[0].length; k++){ //iteriert 20 mal
                for (int zeitdauerInMs : messkonduktor.messungenDurchfuehren(messAnzahl)) {
                     summe += zeitdauerInMs; //Gibt den Mittelwert für alle einzelne Messungen.
                }
                mittelwert[k] = (summe / messkonduktor.messungenDurchfuehren(messAnzahl).length);
                summe = 0;
            }
      }
      
      //Gibt den Mittelwert von jeder Reihe aus / erwartet sind 200 Einträge:
      for (int m : mittelwert) {
          System.out.println(m);
      }
  }
}