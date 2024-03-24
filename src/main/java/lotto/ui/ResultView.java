package lotto.ui;

import lotto.domain.*;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ResultView {

    public static void printLottoTickets(IssuedLottoTickets issuedLottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatLottoTicketsCount(issuedLottoTickets)).append(System.lineSeparator());
        stringBuilder.append(formatLottoTickets(issuedLottoTickets.getAuto()));
        stringBuilder.append(formatLottoTickets(issuedLottoTickets.getManual())).append(System.lineSeparator());
        System.out.println(stringBuilder);
    }

    private static String formatLottoTicketsCount(IssuedLottoTickets issuedLottoTickets) {
        return MessageFormat.format("수동으로 {0}장, 자동으로 {1}개를 구매했습니다.",
                issuedLottoTickets.manualSize(), issuedLottoTickets.autoSize());
    }

    private static String formatLottoTickets(LottoTickets lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket ticket : lottoTickets.get()) {
            stringBuilder.append("[")
                    .append(formatLottoNumber(ticket))
                    .append("]")
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static String formatLottoNumber(LottoTicket ticket) {
        return ticket.get().stream()
                .map(number -> Integer.toString(number.get()))
                .collect(Collectors.joining(", "));
    }

    public static void printLottoStatistics(LottoStatistics statistics) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계").append(System.lineSeparator());
        stringBuilder.append("---------").append(System.lineSeparator());
        stringBuilder.append(formatRanks(statistics)).append(System.lineSeparator());
        stringBuilder.append(formatProfitRate(statistics)).append(System.lineSeparator());
        System.out.println(stringBuilder);
    }

    private static String formatRanks(LottoStatistics statistics) {
        List<Rank> ranks = getRanksWithoutMISS();

        StringBuilder stringBuilder = new StringBuilder();
        for (Rank rank : ranks) {
            stringBuilder.append(formatStatistic(statistics, rank)).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static List<Rank> getRanksWithoutMISS() {
        return Arrays.stream(Rank.values())
                .filter(Predicate.not(it -> it == Rank.MISS))
                .sorted(Comparator.comparing(Rank::getPrize))
                .collect(Collectors.toUnmodifiableList());
    }

    private static String formatStatistic(LottoStatistics statistics, Rank rank) {
        return MessageFormat.format("{0} ({1}원) - {2}개"
                , formatRankMatchCount(rank), rank.getPrize(), statistics.getRankCount(rank));
    }

    private static String formatRankMatchCount(Rank rank) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MessageFormat.format("{0}개 일치", rank.getMatchCount()));
        if (rank.isBonus()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        return stringBuilder.toString();
    }

    public static String formatProfitRate(LottoStatistics statistics) {
        return MessageFormat.format("총 수익률은 {0}입니다.", statistics.calculateProfitRate());
    }

    public static void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

}
