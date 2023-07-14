package lotto.domain;

public class ManualBuyCount {

    final int value;

    public ManualBuyCount(final int value, final Money money) {
        validate(value, money);
        this.value = value;
    }

    private void validate(final int value, final Money money) {
        if (money.getValue() < value * Lotto.PRICE) {
            throw new IllegalArgumentException("주어진 돈으로 해당 개수 만큼 로또를 구매할 수 없습니다.");
        }
    }
}
