package lottery_auto.ui;

import lottery_auto.domain.Lotteries;
import lottery_auto.domain.WinningResult;
import lottery_auto.type.ProfitRateMessage;
import lottery_auto.type.WinningMatch;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LOTTERY_TICKET_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---------";
    private static final Double COMPARISON_CRITERIA = Double.valueOf(1);
    private static final String LOTTERY_MATCH_MESSAGE = "%d개 일치( %d원)- %d 개";
    private static final String PROFIT_RATE_MESSAGE = "\n총 수익률은 %.2f 입니다.";

    public static void print(int ticket, Lotteries lotteries) {
        System.out.println(String.format(LOTTERY_TICKET_MESSAGE, ticket));
        System.out.println(lotteries.toString());
    }

    public static void print(List<Integer> winningCount) {
        System.out.println(WINNING_NUMBER_MESSAGE);

        String winningNumber = winningCount.stream()
                            .map(Objects::toString)
                            .collect(Collectors.toList())
                            .toString();

        System.out.println(winningNumber);
    }

    public static void print(WinningResult winningResult, BigDecimal amount) {
        System.out.println(WINNING_STATISTICS_MESSAGE);

        List<WinningMatch> winningMatches = WinningMatch.bringExceptNonValue();
        winningMatches.forEach(winningMatch -> {
            int cnt = winningResult.compareMatch(winningMatch);
            System.out.println(String.format(LOTTERY_MATCH_MESSAGE,winningMatch.getCount(),winningMatch.getWinnings(),cnt));
        });

        print(winningResult.calculateProfit(amount));
    }

    private static void print(Double rate){
        System.out.print(String.format(PROFIT_RATE_MESSAGE,rate));
        ProfitRateMessage profitRateMessage = ProfitRateMessage.equal(rate.compareTo(COMPARISON_CRITERIA));

        System.out.println(profitRateMessage.getMessage());
    }


}
