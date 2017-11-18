package com.diuly.letscode.exercicioparte2.model;

/**
 * Created by letscode on 18/11/2017.
 */

public enum Affiliation {
    GALACTIC_REPUBLIC(0),
    GALACTIC_EMPIRE(1),
    FIRST_ORDER(2);

    private int value;

    Affiliation(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
