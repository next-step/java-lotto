package step2.domain;

public class LottosCount {
    private final int manual;
    private final int auto;
    private static final int LOTTO_PRICE = 1000;

    public LottosCount(int manual, int money) {
        validate(manual, possibleCount(money));
        this.manual = manual;
        this.auto = (money - (manual * LOTTO_PRICE)) / LOTTO_PRICE;
    }

    private void validate(int manual, int possibleCount) {
        if (manual > possibleCount) {
            throw new IllegalArgumentException("구매 가능 수량을 초과하였습니다.");
        }
    }

    private int possibleCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getManual() {
        return manual;
    }

    public int getAuto() {
        return auto;
    }
}
