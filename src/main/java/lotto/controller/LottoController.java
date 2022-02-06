package lotto.controller;

import java.util.Map;
import lotto.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.YieldCalculator;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.Numbers;
import lotto.domain.money.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoGame lottoGame = new LottoGame();
    public LottoController() {
    }

    public void start() {
        final Money money = InputMoneyValue();
        final int lottoCount = lottoGame.calculateLottoCount(money);
        ResultView.printLottoCount(lottoCount);

        final Lottos lottos = generateLottos(lottoCount);
        ResultView.printLottos(lottos);

        final Numbers winningNumbers = InputWinningNumbers();
        final BonusNumber bonusNumber = InputBonusNumber(winningNumbers);

        final Map<LottoResult, Integer> results = lottoGame.getResults(lottos, winningNumbers, bonusNumber);
        double yield = YieldCalculator.calculateYield(results, money);
        ResultView.printLottoResults(results, yield);
    }

    private BonusNumber InputBonusNumber(Numbers winningNumbers) {
        try {
            return new BonusNumber(InputView.inputBonusNumber(),winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputBonusNumber(winningNumbers);
        }
    }

    private Numbers InputWinningNumbers() {
        try {
            return new Numbers(InputView.inputLastWinningNumbers());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputWinningNumbers();
        }
    }

    private Lottos generateLottos(int lottoCount) {
        try {
            return lottoGame.generateLottos(lottoCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateLottos(lottoCount);
        }
    }

    private Money InputMoneyValue() {
        try {
            return new Money(InputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputMoneyValue();
        }
    }
}
