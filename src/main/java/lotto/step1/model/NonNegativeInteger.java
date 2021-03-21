package lotto.step1.model;

import java.util.Objects;

public class NonNegativeInteger {
    private final int value;

    public NonNegativeInteger(){
        this(0);
    }
    public NonNegativeInteger(String nonNegativeInteger){
        this(Integer.parseInt(nonNegativeInteger));
    }

    public NonNegativeInteger(int nonNegativeInteger){
        if(nonNegativeInteger < 0){
            throw new IllegalArgumentException(Constants.checkNonNegative);
        }
        value = nonNegativeInteger;
    }

    public NonNegativeInteger sum(NonNegativeInteger other){
        return new NonNegativeInteger(this.value + other.value);
    }

    public int value(){
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        NonNegativeInteger otherNonNegativeInteger = (NonNegativeInteger) other;
        return value == otherNonNegativeInteger.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
