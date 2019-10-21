package br.com.penseverde.manoelprado.penseverde;

import java.util.Observable;

public class Flux extends Observable {
    private int someVariable;

    public void setSomeVariable(int someVariable) {
        synchronized (this) {
            this.someVariable = someVariable;
        }
        setChanged();
        notifyObservers();
    }

    public synchronized int getSomeVariable() {
        return someVariable;
    }
}