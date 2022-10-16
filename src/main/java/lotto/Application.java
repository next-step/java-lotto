package lotto;

import lotto.domain.*;
import lotto.domain.exception.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Money money = receiveMoney();
        Money moneyLeft = money.calculateLeft();
        OutputView.printMoneyLeft(moneyLeft);

        PlayLottoCount playLottoCount = money.countPlayLotto();
        List<Lotto> lottos = AutoLottoGenerator.generate(playLottoCount);
        OutputView.printGeneratedLottos(lottos);

        Lotto lastWeekWinningLotto = createLastWeekWinningLotto();
        WinningStatistics winningStatistics = WinningStatistics.of(lottos, lastWeekWinningLotto);
        OutputView.printWinningStatistics(winningStatistics, money.calculatePrice());
    }

    private static Money receiveMoney() {
        try {
            return new Money(InputView.receiveMoney());
        } catch (NotNumberStringException | NotZeroOrMoreNumberException e) {
            System.out.println(e.getMessage());
            return receiveMoney();
        }
    }

    private static Lotto createLastWeekWinningLotto() {
        try {
            return Lotto.from(InputView.receiveLastWeekWinningNumber());
        } catch (NotNumberStringException | OutOfRangeLottoNumberException | InvalidLottoNumberSizeException e) {
            System.out.println(e.getMessage());
            return createLastWeekWinningLotto();
        }
    }
}
