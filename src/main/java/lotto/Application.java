package lotto;

import lotto.domain.*;
import lotto.domain.exception.LottoDomainException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Money money = receiveMoney();
        Money moneyLeft = money.calculateLeft();
        PlayLottoCount playLottoCount = money.countPlayLotto();
        OutputView.printLottoCountAndMoneyLeft(playLottoCount, moneyLeft);
        OutputView.printNewLine();

        ManualLottoCount manualLottoCount = createManualLottoCount(playLottoCount);
        OutputView.printNewLine();

        LottoPaper manualLottoPaper = createLottoPaper(manualLottoCount);
        OutputView.printNewLine();

        LottoPaper lottoPaper = manualLottoPaper.generateAutoLottos(playLottoCount.subtract(manualLottoCount), new AutoLottoGenerator());
        OutputView.printGeneratedLottos(lottoPaper.getElements());
        OutputView.printNewLine();

        Lotto lastWeekWinningLotto = createLastWeekWinningLotto();
        BonusBall bonusBall = createBonusBall(lastWeekWinningLotto);
        WinningStatistics winningStatistics = WinningStatistics.of(lottoPaper.getElements(), lastWeekWinningLotto, bonusBall);
        OutputView.printWinningStatistics(winningStatistics, money.calculatePrice());
    }

    private static Money receiveMoney() {
        try {
            return new Money(InputView.receiveMoney());
        } catch (LottoDomainException e) {
            System.out.println(e.getMessage());
            return receiveMoney();
        }
    }

    private static ManualLottoCount createManualLottoCount(PlayLottoCount playLottoCount) {
        try {
            return new ManualLottoCount(playLottoCount, InputView.receiveManualLottoCount());
        } catch (LottoDomainException e) {
            System.out.println(e.getMessage());
            return createManualLottoCount(playLottoCount);
        }
    }

    private static LottoPaper createLottoPaper(ManualLottoCount manualLottoCount) {
        try {
            return LottoPaper.from(InputView.receiveManualLottos(manualLottoCount));
        } catch (LottoDomainException e) {
            System.out.println(e.getMessage());
            return createLottoPaper(manualLottoCount);
        }
    }

    private static Lotto createLastWeekWinningLotto() {
        try {
            return Lotto.from(InputView.receiveLastWeekWinningNumber());
        } catch (LottoDomainException e) {
            System.out.println(e.getMessage());
            return createLastWeekWinningLotto();
        }
    }

    private static BonusBall createBonusBall(final Lotto lastWeekWinningLotto) {
        try {
            return new BonusBall(InputView.receiveBonusBall(), lastWeekWinningLotto);
        } catch (LottoDomainException e) {
            System.out.println(e.getMessage());
            return createBonusBall(lastWeekWinningLotto);
        }
    }
}
