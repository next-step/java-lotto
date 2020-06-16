package step2.model;

import step2.exception.LottoLowMoneyException;

public class LottoMoney {

    private static final int LOTTO_COST = 1000;

    private final int lottoMoney;

    public LottoMoney(int inputMoney) {
        validatePrice(inputMoney);
        lottoMoney = inputMoney;
    }

    public int getLottoCount() {
        return lottoMoney / LOTTO_COST;
    }

    private void validatePrice(int inputMoney) {
        if ( inputMoney < LOTTO_COST ) {
            throw new LottoLowMoneyException();
        }
    }
}
