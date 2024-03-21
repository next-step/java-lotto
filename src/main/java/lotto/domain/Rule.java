package lotto.domain;

public enum Rule {

    NUMBERS_OF_BALLS(6),
    MAX_NUMBER(45),
    MIN_NUMBER(1);

    private final int number;

    Rule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
