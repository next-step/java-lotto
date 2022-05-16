package Lotto.controller;

import Lotto.domain.*;
import Lotto.domain.Number;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private Money money;
    private Lotto winningNumbers;

    public void start() {

        Lottos lottos = createLottos();

        viewMyLottoNumbers(lottos);

        inputAndCreateWinningLottoNumbers();

        viewResult(lottos);
    }

    private Lottos createLottos() {
        money = new Money(InputView.inputBuyMoney(), true);

        List<Lotto> passiveLottos = inputAndCreatePassiveLotto();

        int automaticLottosCnt = money.changeMoneyToLottoNum() - passiveLottos.size();

        return Lottos.createLottosWithPassive(automaticLottosCnt, passiveLottos);
    }

    private List<Lotto> inputAndCreatePassiveLotto() {
        int passiveLottoCnt = InputView.inputPassiveLottoCount();

        InputView.showPassiveLottoNumbers();

        List<Lotto> passiveLottos= new ArrayList<>();
        for (int i = 0; i < passiveLottoCnt; ++i) {
            passiveLottos.add(new Lotto(InputView.inputPassiveLotto()));
        }

        return passiveLottos;
    }

    private void viewMyLottoNumbers(Lottos lottos) {
        ResultView.viewLottoNumbers(lottos);
    }

    private void inputAndCreateWinningLottoNumbers() {
        String winningNumberStr = InputView.inputWinningLottoNumbers();

        Number bonusNumber = new Number(InputView.inputBonusLottoNumbers());

        winningNumbers = new Lotto(winningNumberStr, bonusNumber);
    }

    private void viewResult(Lottos lottos) {
        Map<EqualLottoCntInfo, Integer> resultInfo = lottos.findWinningLotto(winningNumbers);

        ResultView.viewResultBoard(resultInfo);

        viewYield(resultInfo);
    }

    private void viewYield(Map<EqualLottoCntInfo, Integer> resultInfo) {
        int totalWinningMoney = LottoResultMachine.calcTotalWinningMoney(resultInfo);

        ResultView.viewLottoYield(LottoResultMachine.calculateYield(totalWinningMoney, money.getMoney()));
    }
}