package lotto.ui;

import lotto.domain.LottoStatistic;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

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

    public static void printLottoStatistics(Map<Integer, Integer> statisticsMap) {
        List<Integer> matchCounts = LottoStatistic.getMatchCounts();
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer matchCount : matchCounts) {
            stringBuilder.append(formatStatistic(statisticsMap, matchCount)).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static String formatStatistic(Map<Integer, Integer> statisticsMap, Integer matchCount) {
        return MessageFormat.format("{0}개 일치 ({1}원) - {2}개"
                , matchCount, LottoStatistic.getWinningAmount(matchCount), statisticsMap.get(matchCount));
    }
}
