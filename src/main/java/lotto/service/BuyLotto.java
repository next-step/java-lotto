package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Set;

public class BuyLotto {
    private final int BUY_AMT_UNIT = 1000;
    private final String BUY_AMT_UNIT_CHECK_TEXT = "금액은 " + BUY_AMT_UNIT + "원 단위로 입력하십시오.";
    private final int buyAmt;
    private final int count;
    private Lottos lottos = new Lottos();

    public BuyLotto(int buyAmt) {
        validateCheck(buyAmt);
        this.buyAmt = buyAmt;
        this.count = buyLottoCount(buyAmt);
    }

    public int getBuyAmt() {
        return this.buyAmt;
    }

    public int getCount() {
        return this.count;
    }

    private void validateCheck(Integer buyAmt) {
        if (buyAmt % BUY_AMT_UNIT != 0
                || buyAmt <= 0) {
            throw new IllegalArgumentException(BUY_AMT_UNIT_CHECK_TEXT);
        }
    }

    public int buyLottoCount(Integer buyAmt) {
        return buyAmt / BUY_AMT_UNIT;
    }

    public void putLottos(Lotto lotto) {
        lottos.putLottos(lotto);
    }

    public int lottosCount() {
        return this.lottos.getLottos().size();
    }

    public Set<Integer> getNumbers(int i) {
        return this.lottos.getLottos().get(i).getNumbers();
    }
}
