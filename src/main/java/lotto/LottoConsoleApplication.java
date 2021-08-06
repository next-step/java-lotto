package lotto;

import lotto.model.LottoShop;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.prize.LottoPrize;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

import static lotto.model.LottoShop.LOTTO_PRICE;
import static lotto.model.LottoShop.getInstance;

public class LottoConsoleApplication {
    public static void main(String[] args) {
        final LottoShop shop = getInstance();
        final int payment = InputView.inputPayment();

        final int manualLottoCount = InputView.inputManualLottoCount();

        validate(payment, manualLottoCount);

        final String[] manualNumbers = InputView.inputManualLottoNumbers(manualLottoCount);

        newLine();

        final int autoNumberOfPurchases = getAutoNumberOfPurchases(payment, manualLottoCount);

        final Lottos lottos = shop.buy(payment, autoNumberOfPurchases, manualNumbers);

        ResultView.printGameCount(manualLottoCount, autoNumberOfPurchases);

        ResultView.printLottoNumber(lottos);

        final String winningNumbers = InputView.inputWinningNumbers();

        final String bonusNumber = InputView.inputBonusNumber();

        final WinningLotto winningLotto = WinningLotto.from(winningNumbers, bonusNumber);
        final List<LottoPrize> lottoPrizes = winningLotto.matchResults(lottos);
        final LottoStatistics lottoStatistics = LottoStatistics.from(payment, lottoPrizes);

        ResultView.printStatistic(lottoStatistics);
    }

    private static void validate(final int payment, final int manualLottoCount) {
        if (payment < manualLottoCount * LOTTO_PRICE) {
            throw new IllegalArgumentException("don't have enough money to buy a lotto. Exit the game.");
        }
    }

    private static void newLine() {
        System.out.println();
    }

    private static int getAutoNumberOfPurchases(final int payment, final int manualLottoCount) {
        final int manualLottoPayment = manualLottoCount * LOTTO_PRICE;
        final int autoNumberOfPurchases = (payment - manualLottoPayment) / LOTTO_PRICE;
        return autoNumberOfPurchases;
    }
}
