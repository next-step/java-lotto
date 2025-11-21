package lotto.domain;

public class Price {

    private final int value;

    public Price(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public double profitPercent(int totalResultPrice) {
        return (double) totalResultPrice / this.value;
    }

    private void validate(int value) {
        checkMinPrice(value);
        checkDivisibleByThousand(value);
    }

    private void checkMinPrice(int value) {
        if (value < 1000) {
            throw new IllegalArgumentException("1000원 이상 입력해주세요.");
        }
    }

    private void checkDivisibleByThousand(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("1000 단위로 입력해주세요.");
        }
    }
}
