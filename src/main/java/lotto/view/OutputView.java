package lotto.view;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Rank;

public class OutputView {

    private static final String SPLITTER = ", ";
    private static final String MESSAGE_BOUGHT_TICKET = "%d 개를 구매했습니다.";
    private static final String MESSAGE_TICKET_START = "[";
    private static final String MESSAGE_TICKET_END = "]";
    private static final String MESSAGE_STATISTICS_TITLE = "당첨 통계";
    private static final String MESSAGE_STATISTICS_DIVIDER = "---------";
    private static final String MESSAGE_RESULT = "총 수익률은 %.2f 입니다.";
    private static final String MESSAGE_RANK = "%d개 일치 (%d원)- %d개";
    private static final String MESSAGE_RANK_BONUS = "%d개 일치, 보너스 볼 일치(%d원)- %d개";


    private OutputView() {}

    public static void printBuyingTickets(final int amount) {
        System.out.println(String.format(MESSAGE_BOUGHT_TICKET, amount));
    }

    public static void printLottoTicket(final LottoNumbers numbers) {
        System.out.print(MESSAGE_TICKET_START);
        System.out.print(
            numbers.get().stream()
                .map(LottoNumber::value)
                .map(String::valueOf)
                .collect(Collectors.joining(SPLITTER))
        );
        System.out.println(MESSAGE_TICKET_END);
    }

    public static void printStatistics(final Map<Rank, Integer> prizeMap) {
        System.out.println(MESSAGE_STATISTICS_TITLE);
        System.out.println(MESSAGE_STATISTICS_DIVIDER);

        Arrays.stream(Rank.values())
            .forEach(rank -> printRank(rank, prizeMap));
    }

    public static void printResult(final BigDecimal calculateRatio) {
        System.out.println(String.format(MESSAGE_RESULT, calculateRatio));
    }

    private static void printRank(final Rank rank, final Map<Rank, Integer> prizeMap) {
        if (rank == Rank.NONE) {
            return;
        }

        if (rank == Rank.SECOND) {
            printBonusRank(rank, prizeMap);
            return;
        }

        System.out.println(String.format(MESSAGE_RANK, rank.getMatches(),rank.getPrize(),prizeMap.getOrDefault(rank, 0)));
    }

    private static void printBonusRank(final Rank rank, final Map<Rank, Integer> prizeMap) {
        System.out.println(String.format(MESSAGE_RANK_BONUS, rank.getMatches(),rank.getPrize(),prizeMap.getOrDefault(rank, 0)));
    }
}
