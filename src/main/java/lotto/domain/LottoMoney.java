package lotto.domain;

import util.CommonException;

public class LottoMoney {
    public static final String SHORT_OF_MONEY = "돈이 부족합니다.";
    private static final int LOTTO_PRICE = 1000;

    public LottoMoney(int money) {
        validateMoney(money);
    }

    private void validateMoney(int money) {
        if(money < LOTTO_PRICE) {
            CommonException.IllegalArgumentException(SHORT_OF_MONEY);
        }
    }
}
