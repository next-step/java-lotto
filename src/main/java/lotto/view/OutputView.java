package lotto.view;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Rank;

public class OutputView {

    private static final String ENTER = "\n";
    private static final String DELIMITER = ", ";
    private static final String PURCHASE_AMOUNT_MANAGER_LOG = "%d개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSED_BRACKET = "]";
    private static final String COUNT_MATCH = "%d개 일치 (%d원)- %d개";
    private static final String BONUS_MATCH = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";

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

    public static void printWinningResult(WinningResult winningResult) {
        Map<Rank, Integer> result = winningResult.getResult();
        
        Iterator iterator = result.keySet().iterator();
        while (iterator.hasNext()) {
            Rank rank = (Rank) iterator.next();
            int matchCount = rank.getMatchCount(); // 몇등
            Integer count = result.get(rank); // 몇개
            if (matchCount < 3) {
                continue;
            }
            long prize = rank.getPrize(); // 얼마

            if (rank == Rank.SECOND) {
                System.out.print(String.format(BONUS_MATCH, matchCount, prize, count) + ENTER);
                continue;
            }
            System.out.print(String.format(COUNT_MATCH, matchCount, prize, count) + ENTER);
        }
    }
}
