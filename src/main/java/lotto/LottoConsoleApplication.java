package lotto;

import lotto.exception.LackMoneyException;
import lotto.model.LottoShop;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.model.LottoShop.LOTTO_PRICE;
import static lotto.model.LottoShop.getInstance;

public class LottoConsoleApplication {
    private static final LottoShop LOTTO_SHOP = getInstance();

    public static void main(String[] args) {
        final int payment = InputView.inputPayment();
        final int manualLottoCount = InputView.inputManualLottoCount();

        validate(payment, manualLottoCount);

        final int autoNumberOfPurchases = getAutoNumberOfPurchases(payment, manualLottoCount);

        printGameInformation(payment,
                             manualLottoCount,
                             autoNumberOfPurchases,
                             LOTTO_SHOP.buy(payment,
                                            autoNumberOfPurchases,
                                            InputView.inputManualLottoNumbers(manualLottoCount)));
    }

    private static void validate(final int payment, final int manualLottoCount) {
        if (payment < manualLottoCount * LOTTO_PRICE) {
            throw new LackMoneyException();
        }
    }

    private static int getAutoNumberOfPurchases(final int payment, final int manualLottoCount) {
        return (payment - manualLottoCount * LOTTO_PRICE) / LOTTO_PRICE;
    }

    private static void printGameInformation(final int payment, final int manualLottoCount, final int autoNumberOfPurchases, final Lottos lottos) {
        ResultView.printGameCount(manualLottoCount, autoNumberOfPurchases);
        ResultView.printLottoNumber(lottos);
        ResultView.printStatistic(LottoStatistics.from(payment,
                                                       WinningLotto.from(InputView.inputWinningNumbers(),
                                                                         InputView.inputBonusNumber()).matchResults(lottos)));
    }
}
