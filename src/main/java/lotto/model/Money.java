package lotto.model;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private Integer money;

    public Money(Integer money) {
        validation(money);

        this.money = money;
    }

    public int buyLotto() {
        return money / LOTTO_PRICE;
    }


    public int buyManualLotto(Integer size) {
        return (money / LOTTO_PRICE) - size;
    }

    public float earningsRate(Long totalReword) {
        return totalReword / Float.valueOf(money);
    }

    private void validation(Integer money) {
        validationTotalPrice(money);
    }

    private void validationTotalPrice(Integer money) {
        if(money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구매금액은 1000원이 넘어야 합니다.");
        }
    }

}
