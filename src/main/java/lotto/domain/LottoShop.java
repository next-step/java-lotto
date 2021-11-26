package lotto.domain;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;

    public Lottos buyLottos(int money) {
        int count = calculateCountAvailable(money);
        return new Lottos(count);
    }

    public int calculateCountAvailable(int money) {
        validate(money);
        return money / LOTTO_PRICE;
    }

    private void validate(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("해당 금액으로는 로또를 사실 수 없습니다.");
        }
    }

}
