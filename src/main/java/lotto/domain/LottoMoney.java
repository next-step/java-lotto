package lotto.domain;

import util.CommonException;
import util.Message;

public class LottoMoney {
    private static final int LOTTO_PRICE = 1000;

    public LottoMoney(int money) {
        validateMoney(money);
    }

    private void validateMoney(int money) {
        if(money < LOTTO_PRICE) {
            CommonException.IllegalArgumentException(Message.SHORT_OF_MONEY);
        }
    }
}
