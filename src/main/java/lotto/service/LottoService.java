package lotto.service;


import lotto.domain.lotto.LottoOffice;
import lotto.domain.lotto.LottoPackage;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.prize.MatchResult;

public class LottoService {

    private LottoService() {
    }

    public static LottoPackage purchase(Money money) {
        return LottoOffice.of(money).purchase();
    }

    public static MatchResult match(LottoPackage lottoPackage, WinningLotto winningLotto) {
        return lottoPackage.match(winningLotto);
    }

}
