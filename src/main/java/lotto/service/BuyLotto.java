package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

public class BuyLotto {
    private final int BUY_AMOUNT_UNIT = 1000;
    private final String BUY_AMOUNT_UNIT_CHECK_TEXT = "금액은 " + BUY_AMOUNT_UNIT + "원 단위로 입력하십시오.";
    private final int buyAmount;
    private final int count;
    private Lottos lottos = new Lottos();

    public BuyLotto(Money money) {
        validateCheck(money);
        this.buyAmount = money.getBuyAmount();
        this.count = buyLottoCount(money);
    }

    public int getbuyAmount() {
        return this.buyAmount;
    }

    public int getCount() {
        return this.count;
    }

    private void validateCheck(Money money) {
        if (money.getBuyAmount() % BUY_AMOUNT_UNIT != 0
                || money.getBuyAmount() <= 0) {
            throw new IllegalArgumentException(BUY_AMOUNT_UNIT_CHECK_TEXT);
        }
    }

    public int buyLottoCount(Money money) {
        return money.getBuyAmount() / BUY_AMOUNT_UNIT;
    }

    public void putLottos(Lotto lotto) {
        lottos.putLottos(lotto);
    }

    public Lottos getLottos() {
        return this.lottos;
    }
}
