package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.math.BigDecimal;
import java.util.List;

public class LottoGame {
    public void start() {
        Money money = new Money(InputView.getMoney());
        int countOfManual = InputView.getManualSelectLottoCount();
        List<String> manualLottoNumbers = InputView.getManualLottoNumbers(countOfManual);
        LottoGroup lottoGroup = LottoGroup.buyLotto(money.getCountOfLotto() - countOfManual, manualLottoNumbers);
        ResultView.printLottoGroup(lottoGroup.getLottos());
        WinningLotto winningLotto = new WinningLotto(InputView.getWinningLotto(), InputView.getBonusNo());
        Ranks ranks = lottoGroup.matching(winningLotto);
        BigDecimal earningRate = money.getEarningRate(ranks.getTotalWinningMoney());
        ResultView.printEarningRate(earningRate.toString());
    }
}
