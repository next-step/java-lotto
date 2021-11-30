package com.pollra.calculator;

import java.util.Objects;

/**
 * @since       2021.11.29
 * @author      pollra
 **********************************************************************************************************************/
public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public Number plus(Number otherNumber) {
        return new Number(value + otherNumber.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Number)) return false;
        Number number=(Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
