package lottery_auto.ui;

import lottery_auto.domain.Lotteries;
import lottery_auto.domain.WinningResult;
import lottery_auto.type.ProfitRateMessage;
import lottery_auto.type.WinningMatch;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LOTTERY_TICKET_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---------";
    private static final Double COMPARISON_CRITERIA = Double.valueOf(1);

    public static void print(int ticket, Lotteries lotteries) {
        System.out.println(ticket+LOTTERY_TICKET_MESSAGE);
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

    public static void print(WinningResult winningResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);

        List<WinningMatch> winningMatches = WinningMatch.getMeaningValue();

        winningMatches.forEach(winningMatch -> {
            int cnt = winningResult.compareMatch(winningMatch);
            StringBuilder matchMessage = new StringBuilder(String.valueOf(winningMatch))
                                        .append("개 일치 (")
                                        .append(winningMatch.getWinnings()).append("원)- ")
                                        .append(cnt).append("개");

            System.out.println(matchMessage);
        });
    }

    public static void print(Double rate){
        StringBuilder rateMsg = new StringBuilder("\n총 수익률은 ").append(rate).append("입니다.");
        System.out.print(rateMsg);
        ProfitRateMessage profitRateMessage = ProfitRateMessage.equal(rate.compareTo(COMPARISON_CRITERIA));

        System.out.println(profitRateMessage.getMessage());
    }


}
