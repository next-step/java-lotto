package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.ticket.PurchaseTicket;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.rank.Rank;

public class OutputView {

    private static final String ENTER = "\n";
    private static final String DELIMITER = ", ";
    private static final String PURCHASE_AMOUNT_MANAGER_LOG = "수동으로 %d개, 자동으로 %d개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSED_BRACKET = "]";
    private static final String WINNING_RESULT_HEAD_LOG = "당첨통계" + ENTER + "---------";
    private static final String COUNT_MATCH = "%d개 일치 (%d원)- %d개";
    private static final String BONUS_MATCH = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String YIELD = "총 수익률은 %.1f입니다.";

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public void printPurchaseAmount(PurchaseTicket ticket) {
        int buyManualCount = ticket.getBuyManualCount();
        int buyAutoCount = ticket.getBuyAutoCount();
        printMessage(ENTER + String.format(PURCHASE_AMOUNT_MANAGER_LOG, buyManualCount, buyAutoCount) + ENTER);
    }

    public void printPurchaseTicket(Lottos lottoRepository) {
        List<Lotto> lottos = lottoRepository.getLottos();
        for (Lotto lotto : lottos) {
            printMessage(lotto.getNumbers().stream()
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, OPEN_BRACKET, CLOSED_BRACKET)) + ENTER);
        }
        printMessage(ENTER);
    }

    public void printWinningResult(WinningResult winningResult) {
        printMessage(ENTER + WINNING_RESULT_HEAD_LOG + ENTER);
        printMatchCount(winningResult.getResult());
        printYield(winningResult.getYield());
    }

    private void printMatchCount(Map<Rank, Integer> result) {
        for (Rank rank : result.keySet()) {
            if (rank == Rank.NONE) {
                continue;
            }
            printCountByRank(rank, result.get(rank));
        }
    }

    private void printCountByRank(Rank rank, int count) {
        int matchCount = rank.getMatchCount();
        long prize = rank.getPrize();

        if (rank == Rank.SECOND) {
            printMessage(String.format(BONUS_MATCH, matchCount, prize, count) + ENTER);
            return;
        }
        printMessage(String.format(COUNT_MATCH, matchCount, prize, count) + ENTER);
    }

    private void printYield(double yield) {
        printMessage(String.format(YIELD, yield) + ENTER);
    }
}
