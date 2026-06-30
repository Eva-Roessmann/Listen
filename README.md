# 🔗 Verkettete Liste - Doppelt verkettete Liste mit Cursor
> **Titel:** Verkettete Liste (Linked List)
> **Zweck:** Verständnis von verketteten Datenstrukturen, Knoten-Referenzen und Cursor-Navigation in Java vertiefen
---
## 📋 Projektinformationen
| Feld | Inhalt |
|------|-------|
| **Projektname** | Verkettete Liste |
| **Typ** | Schulprojekt |
| **Klasse** | 1aAPC |
| **Schuljahr** | 2025/26 |
| **Abgabedatum** | 02.06.2026 |
| **Autor** | Rößmann Eva |
| **Lehrer** | G. Jarz |
| **Fach** | Applikationsentwicklung |
---
## 🎯 Projektbeschreibung
Dieses Projekt implementiert eine **doppelt verkettete Liste** in Java mit den drei klassischen Zeigern **Head**, **Tail** und **Cursor**.
Der Benutzer kann beliebig viele String-Werte eingeben (Eingabe endet mit `X`), die dynamisch ans Ende der Liste angehängt werden. Über ein **Menü** lassen sich danach Elemente am Anfang, Ende oder an einer bestimmten Position eingefügt bzw. gelöscht werden. Zusätzlich kann die Liste mit `next()` und `prev()` durchlaufen, sortiert und das aktuelle Cursor-Element gelöscht werden.
---
## 🛠️ Entwicklungsumgebung
### Verwendete Software & Tools
| Tool / Software | Version | Zweck |
|---|---|---|
| **IntelliJ IDEA** | 2025.3.4.1 | Code-Editor & IDE |
| **Java SDK** | 21+ | Programmiersprache |
| **Terminal/Console** | - | Programmausführung |
### 💻 Betriebssystem
- ✅ Windows 11
- ✅ macOS
- ✅ Linux
---
### 📊 Beispiel-Ausführung
```
=== Werte eingeben (X zum Beenden der Eingabe) ===
Wert eingeben: Banane
Wert eingeben: Apfel
Wert eingeben: Kirsche
Wert eingeben: X

========== MENÜ ==========
1  - addFirst
2  - addLast
3  - addIndex
4  - deleteFirst
5  - deleteLast
6  - deleteIndex
7  - printAll
8  - sort
9  - deleteCurrent (Cursor-Element löschen)
10 - next (Cursor vorrücken)
11 - prev (Cursor zurücksetzen)
0  - Beenden
Auswahl: 7
Liste: Banane[C] <-> Apfel <-> Kirsche

Auswahl: 8
Liste wurde sortiert.

Auswahl: 7
Liste: Apfel[C] <-> Banane <-> Kirsche

Auswahl: 10
Aktuelles Element: Banane

Auswahl: 9
Aktuelles Element wurde gelöscht.

Auswahl: 7
Liste: Apfel <-> Kirsche[C]

Auswahl: 0
Programm wird beendet.
```
---
### 🔍 Detaillierte Code-Analyse
| Code-Element | Erklärung |
|---|---|
| `class Node` | Speichert einen Wert sowie Verweise auf den vorherigen (`prev`) und nächsten (`next`) Knoten |
| `Node head;` | Zeiger auf das erste Element der Liste |
| `Node tail;` | Zeiger auf das letzte Element der Liste |
| `Node cursor;` | Zeiger auf das aktuell ausgewählte Element zum Durchlaufen |
| `addFirst(value)` | Fügt einen neuen Knoten am Anfang der Liste ein |
| `addLast(value)` | Fügt einen neuen Knoten am Ende der Liste ein |
| `addIndex(index, value)` | Fügt einen neuen Knoten an einer beliebigen Position ein |
| `deleteFirst()` | Entfernt den ersten Knoten der Liste |
| `deleteLast()` | Entfernt den letzten Knoten der Liste |
| `deleteIndex(index)` | Entfernt den Knoten an einer bestimmten Position |
| `deleteCurrent()` | Entfernt das Element, auf dem der Cursor aktuell steht |
| `printAll()` | Gibt alle Elemente der Liste aus, Cursor-Element wird mit `[C]` markiert |
| `sort()` | Sortiert die Werte der Liste alphabetisch mittels Bubble-Sort |
| `next()` | Bewegt den Cursor einen Schritt in Richtung Ende |
| `prev()` | Bewegt den Cursor einen Schritt in Richtung Anfang |
| `while (!eingabe.equalsIgnoreCase("X"))` | Liest so lange Werte ein, bis der Benutzer "X" eingibt |
| `sc.close();` | Scanner schließen |
---
## 📚 Verwendete Java-Konzepte
- Klassen und Objekte (Node, VerketteteListe)
- Referenzen / Zeiger zwischen Objekten (head, tail, cursor, next, prev)
- Doppelt verkettete Liste
- Schleifen (while, do-while, for)
- Verzweigungen (if/else, switch)
- Benutzereingaben mit `Scanner`
- Bubble-Sort-Algorithmus
- Methoden mit Parametern und Rückgabewerten
---
## 📖 Wichtige Funktionen der eigenen List-Klasse
| Funktion | Beschreibung |
|---|---|
| `liste.addFirst("Wert");` | Fügt "Wert" als neues erstes Element der Liste ein |
| `liste.addLast("Wert");` | Fügt "Wert" als neues letztes Element der Liste ein |
| `liste.addIndex(2, "Wert");` | Fügt "Wert" an Position 2 der Liste ein |
| `liste.deleteFirst();` | Löscht das erste Element der Liste |
| `liste.deleteLast();` | Löscht das letzte Element der Liste |
| `liste.deleteIndex(2);` | Löscht das Element an Position 2 |
| `liste.deleteCurrent();` | Löscht das Element, auf dem der Cursor steht |
| `liste.printAll();` | Gibt alle Elemente der Liste in der Konsole aus |
| `liste.sort();` | Sortiert alle Werte der Liste alphabetisch |
| `liste.next();` | Bewegt den Cursor einen Schritt nach vorne |
| `liste.prev();` | Bewegt den Cursor einen Schritt nach hinten |
| `liste.cursorToHead();` | Setzt den Cursor zurück auf das erste Element |
| `liste.size();` | Gibt die aktuelle Anzahl der Elemente in der Liste zurück |
---
## 📜 Lizenz
Dieses Projekt wurde im Rahmen des Schulunterrichts erstellt.
```
Copyright © 2026 Rößmann Eva
Schulprojekt - rdata GmbH
Nicht für kommerzielle Nutzung vorgesehen
```
---
