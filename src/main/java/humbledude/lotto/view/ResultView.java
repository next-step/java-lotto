package humbledude.lotto.view;

import humbledude.lotto.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

    public static void printNumberOfPurchased(long howMany) {
        System.out.println(howMany + " 개를 구매했습니다.");
    }

    public static void printLottoNumber(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            ResultView.printLottoNumber(ticket);
        }
    }

    public static void printLottoNumber(LottoTicket ticket) {
        String stringNumbers = ticket.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("[" + stringNumbers + "]");

    }

    public static void printStatistics(AccountManager accountManager) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Stream.of(LottoPrize.FOURTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST)
                .forEachOrdered(prize -> printResultMessageForEachPrize(prize, accountManager.getResultMap()));

        String profitOrLossMessage = getMessageProfitOrLoss(accountManager.getProfitRate());
        String msg = String.format("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)",
                accountManager.getProfitRate(),
                profitOrLossMessage);
        System.out.println(msg);
    }

    private static void printResultMessageForEachPrize(LottoPrize prize, Map<LottoPrize, List<LottoTicket>> result) {
        System.out.printf("%d개 일치 (%d원) - %d개%n",
                prize.getMatchedCount(),
                prize.getPrize(),
                result.getOrDefault(prize, Collections.EMPTY_LIST).size());
    }

    private static String getMessageProfitOrLoss(double profitRate) {
        if (profitRate == 1) {
            return "쌤쌤이";
        }
        if (profitRate < 1) {
            return "손해";
        }
        return "이익이";
    }
}
