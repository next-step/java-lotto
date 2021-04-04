package lotto.view;

import lotto.domain.Dto.RankCountDto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String GOT_TICKETS = "수동으로 %d장, 자동으로 %d장을 구매했습니다";
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

    public static void purchaseTickets(int manualNumberOfTicket, int autoNumberOfTickets) {
        System.out.printf((GOT_TICKETS) + "%n", manualNumberOfTicket, autoNumberOfTickets);
    }

    public static void lottoNumbers(List<LottoNumber> lottoNumbers) {
        String numbers = lottoNumbers.stream()
                .map(LottoNumber::lottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
        System.out.println(OPEN_BRACKET + numbers + CLOSED_BRACKET);
    }

    public static void statistics(List<RankCountDto> ranksCount) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(BOUNDARY);
        for (RankCountDto rankCount : ranksCount) {
            String bonus = bonus(rankCount);
            System.out.printf((MATCH_PRIZE_COUNT) + "%n", rankCount.matchedCountStandard(), bonus, rankCount.prize(), rankCount.matchedCountAfterComparison());
        }
    }

    private static String bonus(RankCountDto rank) {
        if (rank.hasBonus()) {
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
