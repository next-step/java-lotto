package lotto;

import lotto.domain.*;
import lotto.domain.numbergenerator.RandomLottoNumbersGenerator;
import lotto.exception.BonusNumberException;
import lotto.exception.LottoNumberException;
import lotto.exception.LottoNumbersCountException;
import lotto.exception.MinimumAmountException;
import lotto.view.Input;
import lotto.view.Output;

import static lotto.utils.StringUtil.split;
import static lotto.view.Input.askBonusBall;

public class Application {
    public static void main(String[] args) {
        Money purchaseAmount = getPurchaseAount();

        Lottos lottos = LottosFactory.from(purchaseAmount, new RandomLottoNumbersGenerator());

        Output.printLottosCount(lottos);
        Output.printLottos(lottos);

        String askWinningNumbers = Input.askWinningNumber();
        String[] winningNumbers = split(askWinningNumbers);

        LottoNumber bonusBall = getBonusBall();

        WinningLotto winningLotto = getWinningNumber(winningNumbers, bonusBall);

        WinningStatistics statistics = WinningStatistics.from(lottos, winningLotto);
        Output.printWinningStatistics(statistics);
    }

    private static LottoNumber getBonusBall() {
        int bonusBall = askBonusBall();
        try {
            return LottoNumber.from(bonusBall);
        } catch (LottoNumberException e) {
            Output.lottoNumberError();
            return getBonusBall();
        }
    }

    private static Money getPurchaseAount() {
        int purchaseAmount = Input.askPurchaseAmount();
        try {
            return Money.from(purchaseAmount);
        } catch (MinimumAmountException e) {
            Output.printMoneyError();
            return getPurchaseAount();
        }
    }

    private static WinningLotto getWinningNumber(String[] winningNumber, LottoNumber bonusBall) {
        try {
            return WinningLotto.from(winningNumber, bonusBall);
        } catch (LottoNumberException e) {
            Output.lottoNumberError();
            return getWinningNumber(winningNumber, bonusBall);
        } catch (LottoNumbersCountException e) {
            Output.winningNumberCountError();
            return getWinningNumber(winningNumber, bonusBall);
        } catch (BonusNumberException e) {
            Output.bonusNumberError();
            return getWinningNumber(winningNumber, getBonusBall());
        }
    }
}
