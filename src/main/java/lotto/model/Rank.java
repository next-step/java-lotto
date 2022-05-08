package lotto.model;

public enum Rank {
    NOT_WON(Number.of(0), Number.of(0)),
    FOURTH(Number.of(3), Number.of(5000)),
    THIRD(Number.of(4), Number.of(50000)),
    SECOND(Number.of(5), Number.of(1500000)),
    FIRST(Number.of(6), Number.of(2000000000));

    private final Number correctCount;
    private final Number prize;

    Rank(Number correctCount, Number prize) {
        this.correctCount = correctCount;
        this.prize = prize;
    }

    public Number getCorrectCount() {
        return correctCount;
    }

    public Number getPrize() {
        return prize;
    }
}
