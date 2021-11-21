package lotto;

import lotto.domain.Lottos;
import lotto.domain.LottosFactory;
import lotto.domain.RandomLottoNumbersGenerator;
import lotto.domain.WinningLotto;
import lotto.exception.LottoNumberException;
import lotto.exception.LottoNumbersCountException;
import lotto.view.Input;
import lotto.view.Output;

import static lotto.utils.StringUtil.split;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = Input.askPurchaseAmount();

        Lottos lottos = LottosFactory.from(purchaseAmount, new RandomLottoNumbersGenerator());

        Output.printLottosCount(lottos);
        Output.printLottos(lottos);

        WinningLotto winningLotto = getWinningNumber();
        Output.printWinningStatistics();
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
