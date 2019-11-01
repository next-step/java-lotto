package com.seok2.adder.domain;

import java.util.Objects;

public class PositiveInteger {

    public static final PositiveInteger ZERO = new PositiveInteger();
    private static final int ZERO_VALUE = 0;

    private final int integer;

    public PositiveInteger() {
        this(ZERO_VALUE);
    }

    public PositiveInteger(int integer) {
        if(integer < ZERO_VALUE)
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

    public PositiveInteger add(PositiveInteger operand) {
        if(operand.integer == ZERO_VALUE)
            return this;
        return new PositiveInteger(this.integer + operand.integer);
    }

    public int intValue() {
        return this.integer;
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


}
