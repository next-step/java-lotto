package lotto.domain;

import util.CommonException;
import util.Message;

import java.util.stream.Stream;

public class LottoMoney {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private LottoCoin lottoCoin = new LottoCoin();
    private int remainMoney = 0;

    public LottoMoney(int money) {
        validateMoney(money);
        buyLotto(money);
    }

    private void buyLotto(int money) {
        Stream.iterate(money,i -> i >= ZERO, i -> i - LOTTO_PRICE)
                .forEach(loopMoney -> {
                    validateRemainMoney(loopMoney);
                    validateCoinCharge(loopMoney);
                });
    }

    private void validateCoinCharge(int money) {
        if(money >= LOTTO_PRICE) {
            lottoCoin.coinCharge();
        }
    }

    private void validateRemainMoney(Integer remainMoney) {
        if(remainMoney < LOTTO_PRICE) {
            this.remainMoney = remainMoney;
        }
    }

    private void validateMoney(int money) {
        if(money < LOTTO_PRICE) {
            CommonException.IllegalArgumentException(Message.SHORT_OF_MONEY);
        }
    }

    public int getCoin() {
        return lottoCoin.getCoin();
    }

    public int getRemainMoney() {
        return remainMoney;
    }
}
