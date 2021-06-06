package lotto;

import static lotto.Lotto.LOTTO_PRICE;

public class Money {
    private int money;

    public Money(int num) {
        validateMoney(num);
        this.money = num;
    }

    public int value() {
        return this.money;
    }

    public void buyLotto(int number) {
        validateBuyingLotto(number);
        money = money - number * LOTTO_PRICE;
    }

    private void validateMoney(int num) {
        if (num <= 0) {
            throw new RuntimeException("구매 급액은 0보다 커야합니다.");
        }
    }

    private void validateBuyingLotto(int num) {
        if (num * LOTTO_PRICE > money) {
            throw new RuntimeException("구매 갯수가 금액보다 큽니다.");
        }
    }
}
