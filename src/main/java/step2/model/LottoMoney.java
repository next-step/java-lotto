
package step2.model;

public class LottoMoney {

    private static final int LOTTO_COST = 1000;

    private final int lottoMoney;

    public LottoMoney(int inputMoney) {
        lottoMoney = inputMoney;
    }

    public int getLottoCount() {
        return lottoMoney / LOTTO_COST;
    }
}