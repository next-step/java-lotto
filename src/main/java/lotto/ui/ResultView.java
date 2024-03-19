package lotto.ui;

import lotto.domain.LottoInformation;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.text.MessageFormat;
import java.util.List;

public class ResultView {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(formatPurchaseCount(lottoTickets.size())).append(System.lineSeparator());

        for (LottoTicket ticket : lottoTickets.get()) {
            stringBuilder.append(ticket).append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());

        System.out.println(stringBuilder);
    }

    private static String formatPurchaseCount(int count) {
        return MessageFormat.format("{0}개를 구매했습니다.", count);
    }

    public static void printLottoStatistics(LottoStatistics statisticsMap, int purchaseAmount) {
        List<Integer> matchCounts = LottoInformation.getMatchCounts();

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer matchCount : matchCounts) {
            stringBuilder.append(formatStatistic(statisticsMap, matchCount)).append(System.lineSeparator());
        }
        stringBuilder.append(formatProfitRate(statisticsMap, purchaseAmount));

        System.out.println(stringBuilder);
    }

    private static String formatStatistic(LottoStatistics statisticsMap, Integer matchCount) {
        return MessageFormat.format("{0}개 일치 ({1}원) - {2}개"
                , matchCount, LottoInformation.getWinAmount(matchCount), statisticsMap.getMatchedLottoCount(matchCount));
    }

    public static String formatProfitRate(LottoStatistics statisticsMap, int purchaseAmount) {
        return MessageFormat.format("총 수익률은 {0}입니다.", LottoInformation.calculateProfitRate(statisticsMap, purchaseAmount));
    }

    public static void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public static void printException(Exception e) {
        printException(e.getMessage());
    }
}
