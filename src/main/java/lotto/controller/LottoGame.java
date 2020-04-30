package lotto.controller;

import lotto.domain.*;
import lotto.domain.machine.DefaultLottoMachine;
import lotto.domain.machine.LottoMachine;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.math.BigDecimal;
import java.util.List;

public class LottoGame {
    public void start() {
        Money money = new Money(InputView.getMoney());
        int countOfManual = InputView.getManualSelectLottoCount();
        List<String> manualLottoNumbers = InputView.getManualLottoNumbers(countOfManual);
        LottoMachine lottoMachine = new DefaultLottoMachine();
        LottoGroup lottoGroup = lottoMachine.buyLotto(money, manualLottoNumbers);
        ResultView.printLottoGroup(lottoGroup.getLottos());
        WinningLotto winningLotto = new WinningLotto(Lotto.ofComma(InputView.getWinningLotto()), LottoNumber.of(InputView.getBonusNo()));
        Ranks ranks = lottoGroup.matching(winningLotto);
        BigDecimal earningRate = money.getEarningRate(ranks.getTotalWinningMoney());
        ResultView.printEarningRate(earningRate.toString());
    }
}
