package com.seok2.adder.domain;

import java.util.Objects;

public class PositiveInteger {

    private static final int ZERO = 0;
    private final int integer;

    public PositiveInteger() {
        this(ZERO);
    }

    public PositiveInteger(int integer) {
        if(integer < ZERO)
            throw new IllegalArgumentException();
        this.integer = integer;
    }

    public static PositiveInteger parse(String s) {
        try {
            return  new PositiveInteger(Integer.parseInt(s));
        } catch ( NumberFormatException e ) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveInteger that = (PositiveInteger) o;
        return integer == that.integer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(integer);
    }

    public PositiveInteger add(PositiveInteger operand) {
        if(operand.integer == ZERO)
            return this;
        return new PositiveInteger(this.integer + operand.integer);
    }
}
