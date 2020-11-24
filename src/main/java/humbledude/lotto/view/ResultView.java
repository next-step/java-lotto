package humbledude.lotto.view;

import humbledude.lotto.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    private static final String EMPTY_STR = "";
    private static final String MSG_NUMBER_OF_PURCHASED = "%d개를 구매했습니다.\n";
    private static final String MSG_STATISTICS_TITLE = "당첨 통계\n--------------";
    private static final String MSG_STATISTICS_FOR_EACH_PRIZE = "%d개 일치%s (%d원) - %d개%n";
    private static final String MSG_STATISTICS_FOR_EACH_PRIZE_BONUS = ", 보너스 볼 일치";
    private static final String MSG_STATISTICS_FOOTER = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String MSG_STATISTICS_FOOTER_PROFIT = "이익이";
    private static final String MSG_STATISTICS_FOOTER_LOSS = "손해";
    private static final String MSG_STATISTICS_FOOTER_SAME = "쌤쌤이";

    public static void printNumberOfPurchased(long howMany) {
        System.out.printf(MSG_NUMBER_OF_PURCHASED, howMany);
    }

    public static void printLottoNumber(List<LottoNumbers> tickets) {
        for (LottoNumbers ticket : tickets) {
            ResultView.printLottoNumber(ticket);
        }
    }

    public static void printLottoNumber(LottoNumbers ticket) {
        String stringNumbers = ticket.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("[" + stringNumbers + "]");

    }

    public static void printStatistics(AccountManager accountManager) {
        System.out.println(MSG_STATISTICS_TITLE);
        Stream.of(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST)
                .forEachOrdered(prize -> printResultMessageForEachPrize(prize, accountManager.getResultMap()));

        String profitOrLossMessage = getMessageProfitOrLoss(accountManager.getProfitRate());
        String msg = String.format(MSG_STATISTICS_FOOTER,
                accountManager.getProfitRate(),
                profitOrLossMessage);
        System.out.println(msg);
    }

    private static void printResultMessageForEachPrize(LottoPrize prize, Map<LottoPrize, List<LottoNumbers>> result) {
        System.out.printf(MSG_STATISTICS_FOR_EACH_PRIZE,
                prize.getMatchedCount(),
                getMessageBonusCheck(prize.isCheckBonus()),
                prize.getPrize(),
                result.getOrDefault(prize, Collections.EMPTY_LIST).size());
    }

    private static String getMessageBonusCheck(boolean checkBonus) {
        if (checkBonus) {
            return MSG_STATISTICS_FOR_EACH_PRIZE_BONUS;
        }
        return EMPTY_STR;
    }

    private static String getMessageProfitOrLoss(double profitRate) {
        if (profitRate == 1) {
            return MSG_STATISTICS_FOOTER_SAME;
        }
        if (profitRate < 1) {
            return MSG_STATISTICS_FOOTER_LOSS;
        }
        return MSG_STATISTICS_FOOTER_PROFIT;
    }
}
