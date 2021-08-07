package lotto;

import lotto.exception.LackMoneyException;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.model.LottoShop.getInstance;

public class LottoConsoleApplication {
    private static final LottoShop LOTTO_SHOP = getInstance();

    public static void main(String[] args) {
        final Money payment = Money.from(InputView.inputPayment());
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

    private static void validate(final Money payment, final int manualLottoCount) {
        if (payment.isLackMoney(manualLottoCount)) {
            throw new LackMoneyException();
        }
    }

    private static int getAutoNumberOfPurchases(final Money payment, final int manualLottoCount) {
        return payment.subtraction(Money.convert(manualLottoCount)).getNumberOfPurchases();
    }

    private static void printGameInformation(final Money payment, final int manualLottoCount, final int autoNumberOfPurchases, final Lottos lottos) {
        ResultView.printGameCount(manualLottoCount, autoNumberOfPurchases);
        ResultView.printLottoNumber(lottos);
        ResultView.printStatistic(LottoStatistics.from(payment,
                                                       WinningLotto.from(InputView.inputWinningNumbers(),
                                                                         InputView.inputBonusNumber()).matchResults(lottos)));
    }
}
