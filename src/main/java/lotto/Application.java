package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Money money = new Money(InputView.receiveMoney());
        Cashier cashier = new Cashier(money);

        int playLottoCount = cashier.countPlayLotto();

        List<Lotto> lottos = LottoGenerator.generate(playLottoCount);
        OutputView.printGeneratedLottos(lottos);

        Lotto lastWeekWinningLotto = createLastWeekWinningLotto();
        WinningStatistics winningStatistics = WinningStatistics.of(lottos, lastWeekWinningLotto);
        OutputView.printWinningStatistics(winningStatistics, money);
    }

    private static Cashier createCashier() {
        try {
            return new Cashier(InputView.receiveMoney());
        } catch (NotNumberStringException | NotThousandUnitsMoneyException | NotZeroOrMoreNumberException e) {
            System.out.println(e.getMessage());
            return createCashier();
        }
    }

    private static Lotto createLastWeekWinningLotto() {
        try {
            return Lotto.of(InputView.receiveLastWeekWinningNumber());
        } catch (NotNumberStringException | OutOfRangeLottoNumberException | InvalidLottoNumberSizeException e) {
            System.out.println(e.getMessage());
            return createLastWeekWinningLotto();
        }
    }
}
