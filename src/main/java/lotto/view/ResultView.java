package lotto.view;

import lotto.domain.LottoNumber;
import lotto.enums.WinningRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String GOT_TICKETS = "%d개를 구매했습니다";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSED_BRACKET = "]";
    private static final String DELIMITER = ", ";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String BOUNDARY = "---------";
    private static final String MATCH_PRIZE_COUNT = "%d개 일치%s(%d원)- %d개";
    private static final String MATCH_BONUS = ", 보너스 볼 일치";
    private static final String BLANK = " ";
    private static final String PLUS_PROFIT_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String MINUS_PROFIT_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void purchaseTickets(int numberOfTickets) {
        System.out.printf((GOT_TICKETS) + "%n", numberOfTickets);
    }

    public static void lottoNumbers(List<LottoNumber> lottoNumbers) {
        String numbers = lottoNumbers.stream()
                .map(LottoNumber::lottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
        System.out.println(OPEN_BRACKET + numbers + CLOSED_BRACKET);
    }

    public static void statistics(Map<WinningRank, Integer> rankCount) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(BOUNDARY);
        for (WinningRank rank : rankCount.keySet()) {
            String bonus = bonus(rank);
            System.out.printf((MATCH_PRIZE_COUNT) + "%n", rank.matchedCount().matchedCount(), bonus, rank.prize().prize(), rankCount.get(rank));
        }
    }

    private static String bonus(WinningRank rank) {
        if (rank.equals(WinningRank.SECOND_PLACE)) {
            return MATCH_BONUS;
        }

        return BLANK;
    }

    public static void positiveProfitRate(double profitRate) {
        System.out.printf((PLUS_PROFIT_RATE) + "%n", profitRate);
    }

    public static void negativeProfitRate(double profitRate) {
        System.out.printf((MINUS_PROFIT_RATE) + "%n", profitRate);
    }
}
