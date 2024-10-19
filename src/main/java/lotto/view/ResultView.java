package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Winning;
import lotto.domain.WinningCalculator;

public class ResultView {
    public static void printTicketCount(int size) {
        System.out.println(size + "개를 구매했습니다.");
    }

    public static void printTickets(LottoTickets lottoTickets) {
        for (LottoTicket ticket : lottoTickets.getLottoTickets()) {
            System.out.println(ticket.getLottoNumbers());
        }
    }

    public static void printWinningResult(WinningCalculator winningCalculator) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        winningCalculator.getWinningCountMap().forEach((winning, count) -> {
            String description = getWinningDescription(winning);
            System.out.println(description + " - " + count + "개");

        });

        double rateOfReturn = winningCalculator.calculateRateOfReturn();
        System.out.printf("총 수익률은 %.2f%%입니다.%n", rateOfReturn);
        if (rateOfReturn < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n");
        }
    }

    private static String getWinningDescription(Winning winning) {
        if (winning == Winning.SECOND) {
            return winning.getMatchCount() + "개 일치, 보너스 볼 일치 (" + winning.getPrize() + "원)";
        }
        return winning.getMatchCount() + "개 일치 (" + winning.getPrize() + "원)";
    }
}
