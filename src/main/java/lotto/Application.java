package lotto;

import lotto.domain.*;
import lotto.domain.exception.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Money moneyPaid = receiveMoney();

        Cashier cashier = createCashier(moneyPaid);
        Money moneyLeft = cashier.receiveLeftMoney();
        OutputView.printMoneyLeft(moneyLeft);

        int playLottoCount = cashier.countPlayLotto();
        List<Lotto> lottos = LottoGenerator.generate(playLottoCount);
        OutputView.printGeneratedLottos(lottos);

        Lotto lastWeekWinningLotto = createLastWeekWinningLotto();
        WinningStatistics winningStatistics = WinningStatistics.of(lottos, lastWeekWinningLotto);
        OutputView.printWinningStatistics(winningStatistics, moneyPaid.subtract(moneyLeft));
    }

    private static Money receiveMoney() {
        try {
            return new Money(InputView.receiveMoney());
        } catch (NotNumberStringException | NotZeroOrMoreNumberException e) {
            System.out.println(e.getMessage());
            return receiveMoney();
        }
    }

    private static Cashier createCashier(Money moneyPaid) {
        try {
            return new Cashier(moneyPaid);
        } catch (UnpurchasableAmountOfMoneyException e) {
            System.out.println(e.getMessage());
            moneyPaid = receiveMoney();
            return createCashier(moneyPaid);
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
