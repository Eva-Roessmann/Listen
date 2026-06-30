// Klasse VerketteteListe
// -----------------------
// Implementiert eine einfach verkettete Liste mit:
// - head   (Zeiger auf den ersten Knoten der Liste)
// - tail   (Zeiger auf den letzten Knoten der Liste)
// - cursor (Zeiger auf das "aktuelle" Element, zum Navigieren mit next()/prev())
class VerketteteListe {
    Node head;     // Anfang der Liste (null = Liste ist leer)
    Node tail;     // Ende der Liste (null = Liste ist leer)
    Node cursor;   // aktuelles Element, auf das der Benutzer gerade "zeigt"
    int size;      // Anzahl der Elemente in der Liste

    // Fügt einen neuen Knoten am ANFANG der Liste ein
    void addFirst(String v) {
        Node n = new Node(v);     // neuen Knoten mit dem übergebenen Wert erstellen
        n.next = head;            // neuer Knoten zeigt auf den bisherigen ersten Knoten
        head = n;                 // head wird auf den neuen Knoten aktualisiert
        if (tail == null) tail = n;   // war die Liste vorher leer, ist der neue Knoten auch tail
        size++;                   // Zähler für Elementanzahl erhöhen
    }

    // Fügt einen neuen Knoten am ENDE der Liste ein
    void addLast(String v) {
        Node n = new Node(v);             // neuen Knoten erstellen
        if (head == null) {
            head = tail = n;              // Liste war leer -> neuer Knoten ist head UND tail
        } else {
            tail.next = n;                // bisheriger letzter Knoten zeigt jetzt auf den neuen
            tail = n;                     // tail wird auf den neuen Knoten aktualisiert
        }
        size++;                           // Zähler erhöhen
    }

    // Fügt einen neuen Knoten an Position i ein (0 = ganz vorne)
    void addIndex(int i, String v) {
        if (i <= 0) { addFirst(v); return; }     // Spezialfall: ganz vorne einfügen
        if (i >= size) { addLast(v); return; }   // Spezialfall: ganz hinten einfügen

        Node prev = head;                  // Start beim ersten Knoten
        for (int k = 0; k < i - 1; k++) {
            prev = prev.next;              // so lange weiterwandern, bis wir
            // direkt VOR der Einfügeposition stehen
        }
        Node n = new Node(v);              // neuen Knoten erstellen
        n.next = prev.next;                // neuer Knoten zeigt auf den bisherigen Nachfolger
        prev.next = n;                     // "prev" zeigt jetzt auf den neuen Knoten
        size++;                            // Zähler erhöhen
    }

    // Löscht den ersten Knoten der Liste
    void deleteFirst() {
        if (head == null) return;          // Liste ist leer -> nichts zu tun
        if (cursor == head) cursor = head.next;  // Cursor verschieben, falls er auf head stand
        head = head.next;                  // head zeigt jetzt auf den zweiten Knoten
        if (head == null) tail = null;     // war das der letzte Knoten, ist die Liste jetzt leer
        size--;                            // Zähler verringern
    }

    // Löscht den letzten Knoten der Liste
    void deleteLast() {
        if (head == null) return;                  // Liste ist leer -> nichts zu tun
        if (head == tail) { deleteFirst(); return; } // nur 1 Element -> deleteFirst() reicht

        Node prev = head;                  // Start beim ersten Knoten
        while (prev.next != tail) {
            prev = prev.next;              // so lange weiterwandern, bis wir
            // den vorletzten Knoten gefunden haben
        }
        if (cursor == tail) cursor = prev; // Cursor verschieben, falls er auf tail stand
        prev.next = null;                  // der neue letzte Knoten hat keinen Nachfolger mehr
        tail = prev;                       // tail wird auf den vorletzten Knoten gesetzt
        size--;                            // Zähler verringern
    }

    // Löscht den Knoten an Position i
    void deleteIndex(int i) {
        if (i < 0 || i >= size) return;    // ungültiger Index -> nichts tun
        if (i == 0) { deleteFirst(); return; }  // Spezialfall: erstes Element löschen

        Node prev = head;                  // Start beim ersten Knoten
        for (int k = 0; k < i - 1; k++) {
            prev = prev.next;              // bis zum Knoten VOR der Löschposition wandern
        }
        Node toDelete = prev.next;         // das ist der zu löschende Knoten
        if (cursor == toDelete) cursor = toDelete.next;  // Cursor ggf. verschieben
        prev.next = toDelete.next;         // "prev" überspringt den gelöschten Knoten
        if (toDelete == tail) tail = prev; // war es der letzte Knoten, tail aktualisieren
        size--;                            // Zähler verringern
    }

    // Löscht das Element, auf dem der Cursor aktuell steht
    void deleteCurrent() {
        if (cursor == null || head == null) return;     // nichts zu löschen
        if (cursor == head) { deleteFirst(); return; }  // Cursor steht ganz vorne

        Node prev = head;                  // Start beim ersten Knoten
        while (prev.next != cursor) {
            prev = prev.next;              // bis zum Vorgänger des Cursors wandern
        }
        prev.next = cursor.next;           // Vorgänger überspringt das Cursor-Element
        if (cursor == tail) tail = prev;   // war es der letzte Knoten, tail aktualisieren
        cursor = prev.next;                // Cursor auf das nächste Element setzen
        size--;                            // Zähler verringern
    }

    // Gibt alle Elemente der Liste von vorne nach hinten aus
    void printAll() {
        Node n = head;                     // Start beim ersten Knoten
        System.out.print("Liste: ");
        while (n != null) {                // solange wir nicht am Ende angekommen sind
            System.out.print(n.value + (n == cursor ? "[C]" : ""));  // Wert ausgeben,
            // Cursor-Element zusätzlich mit "[C]" markieren
            if (n.next != null) System.out.print(" -> ");  // Trennzeichen zwischen Elementen
            n = n.next;                    // einen Schritt weiter zum nächsten Knoten
        }
        System.out.println();
    }

    // Sortiert die Liste alphabetisch (aufsteigend) mittels Bubble-Sort
    void sort() {
        boolean swapped;                   // merkt sich, ob in einem Durchlauf getauscht wurde
        do {
            swapped = false;
            Node n = head;                 // jeder Durchlauf startet wieder beim ersten Knoten
            while (n != null && n.next != null) {
                if (n.value.compareTo(n.next.value) > 0) {  // vergleicht zwei Nachbarwerte
                    String t = n.value;            // Werte vertauschen (nicht die Knoten selbst)
                    n.value = n.next.value;
                    n.next.value = t;
                    swapped = true;                // es wurde getauscht -> noch ein Durchlauf nötig
                }
                n = n.next;                 // einen Schritt weiter
            }
        } while (swapped);                 // wiederholen, bis nichts mehr getauscht wird
    }

    // Bewegt den Cursor einen Schritt nach VORNE (Richtung Ende)
    void next() {
        if (cursor != null && cursor.next != null) cursor = cursor.next;
        // nur weiterrücken, wenn der Cursor existiert und noch ein Nachfolger da ist
    }

    // Bewegt den Cursor einen Schritt nach HINTEN (Richtung Anfang)
    void prev() {
        if (cursor == null || cursor == head) return;  // schon am Anfang -> nichts tun
        Node n = head;                      // Start beim ersten Knoten
        while (n.next != cursor) {
            n = n.next;                     // so lange weiterwandern, bis wir den
            // Vorgänger des Cursors gefunden haben
        }
        cursor = n;                         // Cursor auf den gefundenen Vorgänger setzen
    }
}
