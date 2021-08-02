package lotto.service;

import lotto.domain.lotto.LottoOffice;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.money.PaymentInfo;
import lotto.domain.prize.MatchResult;

public class LottoService {

    private LottoService() {
    }

    public static Lottos purchase(PaymentInfo paymentInfo, Lottos manualLottos) {
        return LottoOffice.purchase(paymentInfo, manualLottos);
    }

    public static MatchResult match(Lottos lottos, Money money, WinningLotto winningLotto) {
        return MatchResult.of(lottos.calculateMatch(winningLotto), money);
    }

}
