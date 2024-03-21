package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.MyPrinter.lineChange;
import static lotto.view.MyPrinter.printLine;

public class OutputView {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private OutputView() {}

    public static void printPurchasedLottos(Lottos lottos) {
        printPurchasedAmount(lottos.size());
        if (!lottos.isEmpty()) {
            lottos.forEach(OutputView::printPurchasedLottoNumbers);
        }
        lineChange();
    }

    private static void printPurchasedAmount(int amount) {
        printLine(String.format(Announcements.PURCHASE_AMOUNT_FORMAT, amount));
    }

    private static void printPurchasedLottoNumbers(Lotto lotto) {
        printLine(
                String.format(
                        Announcements.PURCHASED_LOTTO_NUMBER_TEMPLATE,
                        joinLottoNumbers(lotto.numbers())));
    }

    private static String joinLottoNumbers(List<LottoNumber> numbers) {
        return numbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.value()))
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
    }

    private abstract static class Announcements {
        static final String PURCHASE_AMOUNT_FORMAT = "%d개를 구매했습니다.";
        static final String PURCHASED_LOTTO_NUMBER_TEMPLATE = "[%s]";
    }
}
