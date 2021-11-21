package lotto;

import lotto.domain.*;
import lotto.exception.LottoNumberException;
import lotto.exception.LottoNumbersCountException;
import lotto.exception.MinimumAmountException;
import lotto.view.Input;
import lotto.view.Output;

import static lotto.utils.StringUtil.split;

public class Application {
    public static void main(String[] args) {
        Money purchaseAmount = getPurchaseAount();

        Lottos lottos = LottosFactory.from(purchaseAmount, new RandomLottoNumbersGenerator());

        Output.printLottosCount(lottos);
        Output.printLottos(lottos);

        WinningLotto winningLotto = getWinningNumber();

        WinningStatistics statistics = WinningStatistics.from(lottos, winningLotto);
        Output.printWinningStatistics(statistics);
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

    private static WinningLotto getWinningNumber() {
        try {
            String winningNumber = Input.askWinningNumber();
            String[] split = split(winningNumber);
            return WinningLotto.from(split);
        }catch (LottoNumberException e) {
            Output.LottoNumberError();
            return getWinningNumber();
        } catch (LottoNumbersCountException e) {
            Output.WinningNumberCountError();
            return getWinningNumber();
        }
    }
}
