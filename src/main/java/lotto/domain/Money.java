package lotto.domain;

public class Money {

    private final int value;

    public Money(final int value) {
        this.value = value;
    }

    public int Value() {
        return value;
    }
    public Money multiple(int hit){
        return new Money(value * hit);
    }
}
