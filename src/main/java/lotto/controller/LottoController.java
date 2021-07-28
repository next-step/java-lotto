package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.util.DivisionNumber;
import lotto.view.ResultView;

public final class LottoController {
    private static final Money LOTTO_PRICE = new Money(1000);

    private LottoController() {}

    public static LottoController getInstance() {
        return InnerClazz.instance;
    }

    public LottoList buyLotto(int intMoney) {
        Money money = new Money(intMoney);
        DivisionNumber lottoSize = new DivisionNumber(money, LOTTO_PRICE);
        return LottoList.newAuto(lottoSize);
    }

    private static class InnerClazz {
        private static LottoController instance = new LottoController();
    }
}
