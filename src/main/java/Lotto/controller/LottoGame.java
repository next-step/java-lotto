package Lotto.controller;

import Lotto.domain.*;
import Lotto.domain.Number;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.Map;

public class LottoGame {

    private Lottos lottos;
    private Money money;
    private Lotto winningNumbers;
    private Number bonusNumber;

    public void start() {
        inputBuyMoney();

        createMyLottos();

        viewMyLottoNumbers();

        inputAndCreateWinningLottoNumbers();

        viewResult();
    }

    private void inputBuyMoney() {
        money = new Money(InputView.inputBuyMoney());
    }

    private void createMyLottos() {
        lottos = new Lottos(money.changeMoneyToLottoNum());
    }

    private void viewMyLottoNumbers() {
        ResultView.viewLottoNumbers(lottos);
    }

    private void inputAndCreateWinningLottoNumbers() {
        winningNumbers = new Lotto(InputView.inputWinningLottoNumbers());

        inputAndCreateBonusLottoNumber();
    }

    private void inputAndCreateBonusLottoNumber() {
        bonusNumber = new Number(InputView.inputBonusLottoNumbers());

        winningNumbers.isDuplicateNumber(bonusNumber);
    }

    private void viewResult() {
        Map<EqualLottoCntInfo, Integer> resultInfo = lottos.findWinningLotto(winningNumbers, bonusNumber);

        ResultView.viewResultBoard(resultInfo);

        viewYield(resultInfo);
    }

    private void viewYield(Map<EqualLottoCntInfo, Integer> resultInfo) {
        int totalWinningMoney = LottoResultMachine.calcTotalWinningMoney(resultInfo);

        ResultView.viewLottoYield(LottoResultMachine.calculateYield(totalWinningMoney, money.getMoney()));
    }
}