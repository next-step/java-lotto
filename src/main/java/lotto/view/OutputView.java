package lotto.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class OutputView {

    private static final String ENTER = "\n";
    private static final String DELIMITER = ", ";
    private static final String PURCHASE_AMOUNT_MANAGER_LOG = "%d개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSED_BRACKET = "]";

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printPurchaseAmount(int ticketCount) {
        printMessage(String.format(PURCHASE_AMOUNT_MANAGER_LOG, ticketCount) + ENTER);
    }

    public static void printPurchaseTicket(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printMessage(lotto.getNumbers().stream()
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .map(number -> number.getNumber())
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, OPEN_BRACKET, CLOSED_BRACKET)) + ENTER);
        }
        printMessage(ENTER);
    }
}
