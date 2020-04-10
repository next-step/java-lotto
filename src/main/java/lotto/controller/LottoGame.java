package lotto.controller;

import lotto.domain.LottoGroup;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.math.BigDecimal;
import java.util.List;

public class LottoGame {
    public void start() {
        Money money = new Money(InputView.getMoney());
        LottoGroup lottoGroup = LottoGroup.buyAutoSelectLotto(money.getCountOfLotto());
        ResultView.printLottoGroup(lottoGroup.getLottos());
        String winningLottoNumbers = InputView.getWinningLotto();
        int bonusNo = InputView.getBonusNo();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNo);
        List<Rank> ranks = lottoGroup.matching(winningLotto);
        int totalWinningMoney = 0;
        for (Rank rank : ranks) {
            totalWinningMoney += rank.getWinningMoney();
        }
        BigDecimal earningRate = money.getEarningRate(totalWinningMoney);
        ResultView.printEarningRate(earningRate.toString());
    }
}
