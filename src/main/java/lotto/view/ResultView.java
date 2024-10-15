package lotto.view;

import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.Result;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String BUY_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    public static final String TOTAL_EARNING_RATE_FORMAT = "총 수익률은 %.2f입니다.";
    public static final String LINE_BREAK = "\n";
    public static final String WINNING_STATISTICS_TITLE = "\n당첨 통계\n---------";

    public static void printBuyerLottosInfo(Buyer buyer) {
        System.out.println(buyCountMessage(buyer));
        System.out.println(buyerLottoes(buyer));
    }

    public static void printStatistics(int buyCount, Result rankings) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(rankingResults(rankings));
        System.out.println(totalEarningRate(buyCount, rankings));
    }

    private static String buyCountMessage(Buyer buyer) {
        int buyerLottoesSize = buyer.value().size();
        return String.format(BUY_COUNT_MESSAGE_FORMAT, buyerLottoesSize);
    }

    private static String buyerLottoes(Buyer buyer) {
        List<String> buyerLottoes = buyer.value().stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
        return String.join(LINE_BREAK, buyerLottoes);
    }

    private static String totalEarningRate(int buyCount, Result result) {
        return String.format(TOTAL_EARNING_RATE_FORMAT, result.statistics(buyCount));
    }

    private static String rankingResults(Result result) {
        return String.join(LINE_BREAK, result.formattedRankingResults());
    }
}
