package lotto.model.constants;

public enum Dividend {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int correctCount;
    private int dividendAmount;

    Dividend(int correctCount, int dividendAmount) {
        this.correctCount = correctCount;
        this.dividendAmount = dividendAmount;
    }

    @Override
    public String toString() {
        return correctCount + "개 일치 (" + dividendAmount + "원) - ";
    }
}
