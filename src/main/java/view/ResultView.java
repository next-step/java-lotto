package view;

import lotto.utils.Const;
import lotto.vo.LotteryNumbers;
import lotto.vo.Money;
import lotto.vo.Rank;
import lotto.vo.Ranks;

public class ResultView {
    public static final int WIN_STANDARD = 1;

    public void printPurchaseTicketCount() {
        System.out.println(String.format("%s개를 구매했습니다.", 14));
    }

    public void winningNumberStatistics() {
        System.out.println("당첨통계");
        System.out.println("---------");
    }

    public String perStatistics(int matchedNumber, int winningAmount, int winningNumber) {
        return String.format("%d개 일치(%d원)- %d개", matchedNumber, winningAmount, winningNumber);
    }

    public void revenueRate(double rate) {
        String benefitResult = rate >= WIN_STANDARD ? "이득이" : "손해";
        System.out.println(String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", String.valueOf(rate), benefitResult));
    }
}
