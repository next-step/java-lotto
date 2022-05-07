package Lotto.controller;

import Lotto.domain.*;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.Map;

public class LottoGame {

    private Lottos lottos = new Lottos();

    private Money money;
    private Lotto winningNumbers;

    public void start() {
        inputBuyMoney();

        viewMyLottoNumbers();

        inputWinningLottoNumbers();

        viewResult();
    }

    private void inputBuyMoney() {
        money = new Money(InputView.inputBuyMoney());

        createMyLottos();
    }

    private void createMyLottos() {
        lottos.createLottoNumbers(money.changeMoneyToLottoNum());
    }

    private void viewMyLottoNumbers() {
        ResultView.viewLottoNumbers(lottos);
    }

    private void inputWinningLottoNumbers() {
        winningNumbers = new Lotto(InputView.inputWinningLottoNumbers());
    }

    private void viewResult() {
        Map<WinningRankInfo, Integer> totalRankInfo = LottoResultMachine.findWinningLotto(lottos, winningNumbers);

        ResultView.viewResultBoard(totalRankInfo);

        viewYield(totalRankInfo);
    }

    private void viewYield(Map<WinningRankInfo, Integer> totalRankInfo) {
        int totalWinningMoney = LottoResultMachine.calcTotalWinningMoney(totalRankInfo);

        ResultView.viewLottoYield(LottoResultMachine.calculateYield(totalWinningMoney, money.getMoney()));
    }
}
