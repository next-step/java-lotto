package Lotto.controller;

import Lotto.domain.*;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.Map;

public class LottoGame {

    private Lottos lottos = new Lottos();

    private Money money;
    private WinningLottoNumbers winningNumbers;

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
        winningNumbers = new WinningLottoNumbers(InputView.inputWinningLottoNumbers());
    }

    private void viewResult() {
        Map<WinningRankInfo, Integer> totalRankInfo = LottoMachine.checkWinningLotto(lottos, winningNumbers);

        ResultView.viewResultBoard(totalRankInfo);

        viewYield(totalRankInfo);
    }

    private void viewYield(Map<WinningRankInfo, Integer> totalRankInfo) {
        int totalWinningMoney = LottoMachine.calcTotalWinningMoney(totalRankInfo);

        ResultView.viewLottoYield(LottoMachine.calculateYield(totalWinningMoney, money.getMoney()));
    }
}
