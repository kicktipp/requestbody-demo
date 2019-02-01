package com.example.requestbodydemo;

public class Answer {
    private int anzahlFehler;

    Answer(int anzahlFehler) {
        this.anzahlFehler = anzahlFehler;
    }

    public int getAnzahlFehler() {
        return anzahlFehler;
    }

    public void setAnzahlFehler(int anzahlFehler) {
        this.anzahlFehler = anzahlFehler;
    }
}
