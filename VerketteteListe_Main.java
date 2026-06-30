import java.util.Scanner;   // Scanner-Klasse importieren, um Benutzereingaben zu lesen

// Hauptklasse mit dem Menü
// -------------------------
// Liest zuerst solange Werte vom Benutzer ein, bis "X" eingegeben wird,
// und hängt jeden Wert dynamisch ans Ende der Liste an.
// Danach erscheint ein Menü, mit dem man die Liste bearbeiten
// und durchlaufen (next/prev) kann.
public class VerketteteListe_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);          // Scanner für Benutzereingaben erstellen
        VerketteteListe liste = new VerketteteListe(); // neue, leere verkettete Liste erstellen

        // --- Schritt 1: Werte einlesen, bis der Benutzer "X" eingibt ---
        System.out.println("Werte eingeben (X zum Beenden):");
        while (true) {                                  // Endlosschleife, wird mit "break" verlassen
            System.out.print("Wert: ");
            String e = sc.nextLine();                   // eine Zeile vom Benutzer einlesen
            if (e.equalsIgnoreCase("X")) break;          // Schleife verlassen, sobald "X" eingegeben wird
            liste.addLast(e);                            // Wert dynamisch am Ende der Liste einfügen
        }
        liste.cursor = liste.head;                       // Cursor nach der Eingabe an den Anfang setzen

        // --- Schritt 2: Menü zur Bearbeitung der Liste ---
        int auswahl = -1;                                 // Startwert ungleich 0, damit die Schleife startet
        while (auswahl != 0) {                            // Schleife läuft, bis der Benutzer "0" wählt
            System.out.println("\n1 addFirst | 2 addLast | 3 addIndex | 4 deleteFirst | 5 deleteLast");
            System.out.println("6 deleteIndex | 7 printAll | 8 sort | 9 deleteCurrent | 10 next | 11 prev | 0 Ende");
            System.out.print("Auswahl: ");
            auswahl = sc.nextInt();                       // Menüauswahl als Zahl einlesen
            sc.nextLine();                                // verbleibenden Zeilenumbruch "leeren"

            switch (auswahl) {                            // je nach Auswahl die passende Aktion ausführen
                case 1 -> {                               // addFirst
                    System.out.print("Wert: ");
                    liste.addFirst(sc.nextLine());        // Wert einlesen und am Anfang einfügen
                }
                case 2 -> {                               // addLast
                    System.out.print("Wert: ");
                    liste.addLast(sc.nextLine());         // Wert einlesen und am Ende einfügen
                }
                case 3 -> {                               // addIndex
                    System.out.print("Index: ");
                    int i = sc.nextInt(); sc.nextLine();  // Index einlesen
                    System.out.print("Wert: ");
                    liste.addIndex(i, sc.nextLine());     // Wert an der Position einfügen
                }
                case 4 -> liste.deleteFirst();            // erstes Element löschen
                case 5 -> liste.deleteLast();             // letztes Element löschen
                case 6 -> {                               // deleteIndex
                    System.out.print("Index: ");
                    liste.deleteIndex(sc.nextInt());      // Element an der Position löschen
                    sc.nextLine();                        // Zeilenumbruch "leeren"
                }
                case 7 -> liste.printAll();               // alle Elemente ausgeben
                case 8 -> liste.sort();                   // Liste alphabetisch sortieren
                case 9 -> liste.deleteCurrent();          // Cursor-Element löschen
                case 10 -> liste.next();                  // Cursor einen Schritt vorrücken
                case 11 -> liste.prev();                  // Cursor einen Schritt zurücksetzen
                case 0 -> System.out.println("Programm beendet."); // Schleife wird danach verlassen
                default -> System.out.println("Ungültige Auswahl!"); // falsche Eingabe abfangen
            }
        }
        sc.close();   // Scanner schließen, da er nicht mehr benötigt wird
    }
}
