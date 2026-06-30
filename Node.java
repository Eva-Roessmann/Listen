// Klasse Node (Knoten)
// ---------------------
// Jeder Knoten speichert einen Wert (String) und einen Verweis (Referenz)
// auf den nächsten Knoten in der Liste.
public class Node {
    String value;   // der gespeicherte Wert des Knotens (z.B. "Apfel")
    Node next;      // Verweis auf den nächsten Knoten in der Liste (null = kein Nachfolger)

    // Konstruktor: erstellt einen neuen Knoten mit gegebenem Wert
    Node(String value) {
        this.value = value;   // speichert den übergebenen Wert in diesem Knoten
        // this.next wird automatisch mit null initialisiert (kein Nachfolger)
    }
}
