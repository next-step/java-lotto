package lotto.controller;

import lotto.domain.LottoGroup;
import lotto.domain.Money;
import lotto.domain.Ranks;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.math.BigDecimal;

public class LottoGame {
    public void start() {
        Money money = new Money(InputView.getMoney());
        LottoGroup lottoGroup = LottoGroup.buyAutoSelectLotto(money.getCountOfLotto());
        ResultView.printLottoGroup(lottoGroup.getLottos());
        String winningLottoNumbers = InputView.getWinningLotto();
        int bonusNo = InputView.getBonusNo();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNo);
        Ranks ranks = lottoGroup.matching(winningLotto);
        BigDecimal earningRate = money.getEarningRate(ranks.getTotalWinningMoney());
        ResultView.printEarningRate(earningRate.toString());
    }
}
