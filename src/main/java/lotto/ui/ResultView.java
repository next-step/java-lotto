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
        stringBuilder.append(formatLottoTicketsCount(issuedLottoTickets));
        stringBuilder.append(formatLottoTickets(issuedLottoTickets.getAutoLottoTickets()));
        stringBuilder.append(formatLottoTickets(issuedLottoTickets.getManualLottoTickets()));
        System.out.println(stringBuilder);
    }

    private static String formatLottoTickets(LottoTickets tickets) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatLottoTicketNumbers(tickets))
                    .append(System.lineSeparator());
        return stringBuilder.toString();
    }

    private static String formatLottoTicketsCount(IssuedLottoTickets issuedLottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MessageFormat.format("수동으로 {0}장, 자동으로 {1}개를 구매했습니다.",
                issuedLottoTickets.manualLottoTicketsSize(), issuedLottoTickets.autoLottoTicketsSize()));
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
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
            stringBuilder.append("[")
                    .append(formatLottoNumber(ticket))
                    .append("]")
                    .append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    private static String formatLottoNumber(LottoTicket ticket) {
        return ticket.get().stream()
                .map(number -> Integer.toString(number.get()))
                .collect(Collectors.joining(", "));
    }

    private static String formatPurchaseCount(int count) {
        return MessageFormat.format("{0}개를 구매했습니다.", count);
    }

    public static void printLottoStatistics(LottoStatistics statistics) {
        String message = formatRanks(statistics) + formatProfitRate(statistics);
        System.out.println(message);
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
        if (Rank.SECOND == rank) {
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

    public static void printException(Exception e) {
        printException(e.getMessage());
    }
}
