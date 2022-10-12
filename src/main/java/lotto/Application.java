package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Cashier cashier = createCashier();
        int playLottoCount = cashier.countPlayLotto();
        List<Lotto> lottos = LottoGenerator.generate(playLottoCount);
        OutputView.printGeneratedLottos(lottos);

        Lotto lastWeekWinningLotto = createLastWeekWinningLotto();
        WinningStatistics winningStatistics = WinningStatistics.of(lottos, lastWeekWinningLotto);
        OutputView.printWinningStatistics(winningStatistics, new BigDecimal(14000));
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
