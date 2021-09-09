package step5.domain;

public class Lotto {

    private static final String MANUAL_LOTTO_AMOUNT_ERROR = "자동으로 구매하는 로또의 수량은 전체 구매하는 로또의 수량을 초과할 수 없습니다.";
    private static final int PRICE_VALUE = 1_000;
    private final int money;
    private int numberOfTotalLotto;
    private int numberOfManualLotto;
    private int numberOfAutoLotto;

    public Lotto(int money) {
        calculateNumberOfTotalLotto(money);
        this.money = money;
    }

    private void calculateNumberOfTotalLotto(int money) {
        this.numberOfTotalLotto = money / PRICE_VALUE;
    }

    public void buyManually(Integer numberOfManualLotto) {
        this.numberOfManualLotto = numberOfManualLotto;
        this.numberOfAutoLotto = numberOfTotalLotto - numberOfManualLotto;
        if (numberOfAutoLotto < 0) {
            throw new IllegalArgumentException(MANUAL_LOTTO_AMOUNT_ERROR);
        }
    }

    public int manual() {
        return numberOfManualLotto;
    }

    public int auto() {
        return numberOfAutoLotto;
    }

    public Integer money() {
        return money;
    }
}
