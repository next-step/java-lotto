package lotto.ui;

import lotto.domain.LottoPrize;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.text.MessageFormat;
import java.util.List;

public class ResultView {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        String message = formatLottoTicketCount(lottoTickets) + formatLottoTicketNumbers(lottoTickets);
        System.out.println(message);
    }

    private static StringBuilder formatLottoTicketCount(LottoTickets lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatPurchaseCount(lottoTickets.size()));
        stringBuilder.append(System.lineSeparator());
        return stringBuilder;
    }

    private static String formatLottoTicketNumbers(LottoTickets lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket ticket : lottoTickets.get()) {
            stringBuilder.append(ticket.get()).append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    private static String formatPurchaseCount(int count) {
        return MessageFormat.format("{0}개를 구매했습니다.", count);
    }

    public static void printLottoStatistics(LottoStatistics statisticsMap, int purchaseAmount) {
        String message = formatLottoPrizes(statisticsMap) + formatProfitRate(statisticsMap, purchaseAmount);
        System.out.println(message);
    }

    private static String formatLottoPrizes(LottoStatistics statisticsMap) {
        List<LottoPrize> prizes = LottoPrize.getLottoPrizes();

        StringBuilder stringBuilder = new StringBuilder();
        for (LottoPrize prize : prizes) {
            stringBuilder.append(formatStatistic(statisticsMap, prize)).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static String formatStatistic(LottoStatistics statisticsMap, LottoPrize prize) {
        return MessageFormat.format("{0}개 일치 ({1}원) - {2}개"
                , prize.getMatchCount(), prize.getMatchCount(), statisticsMap.getMatchCount(prize));
    }

    public static String formatProfitRate(LottoStatistics statisticsMap, int purchaseAmount) {
        return MessageFormat.format("총 수익률은 {0}입니다.", statisticsMap.calculateProfitRate(purchaseAmount));
    }

    public static void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public static void printException(Exception e) {
        printException(e.getMessage());
    }
}
