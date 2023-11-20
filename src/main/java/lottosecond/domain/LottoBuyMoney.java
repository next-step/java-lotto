package lottosecond.domain;

import lottosecond.domain.lotto.Lottos;

public class LottoBuyMoney {

    private final int money;

    public LottoBuyMoney(int money) {
        if (!isValidBuyPrice(money)) {
            throw new IllegalArgumentException("로또 구매 금액은 1000의 배수여야 합니다.");
        }

        this.money = money;
    }

    public int countLotto() {
        return money / Lottos.EACH_LOTTO_PRICE;
    }

    private boolean isValidBuyPrice(int lottoBuyMoney) {
        return lottoBuyMoney % Lottos.EACH_LOTTO_PRICE == 0;
    }
}
