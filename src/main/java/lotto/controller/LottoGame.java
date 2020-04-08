package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.math.BigDecimal;
import java.util.List;

public class LottoGame {
    public void start() {
        Money money = new Money(InputView.getMoney());
        LottoGroup lottoGroup = new LottoGroup(money.getCountOfLotto());
        ResultView.printLottoGroup(lottoGroup);
        String winningLottoNumbers = InputView.getWinningLotto();
        int bonusNo = InputView.getBonusNo();
        List<Rank> ranks = lottoGroup.matching(new Lotto(winningLottoNumbers), bonusNo);
        int totalWinningMoney = 0;
        for (Rank rank : ranks) {
            totalWinningMoney += rank.getWinningMoney();
        }
        BigDecimal earningRate = money.getEarningRate(totalWinningMoney);
        ResultView.printEarningRate(earningRate.toString());
    }
}
