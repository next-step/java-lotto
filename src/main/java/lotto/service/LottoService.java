package lotto.service;


import lotto.domain.lotto.LottoOffice;
import lotto.domain.lotto.LottoBunch;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.prize.MatchResult;

public class LottoService {

    private LottoService() {}
    
    public static LottoBunch purchase(Money money) {
        return LottoOffice.of(money).purchase();
    }

    public static MatchResult matchWinningNumber(LottoBunch lottoBunch, WinningLotto winningLotto) {
        return lottoBunch.match(winningLotto);
    }

}
