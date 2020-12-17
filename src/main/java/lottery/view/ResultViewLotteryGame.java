package lottery.view;

import lottery.domain.*;

import java.math.BigDecimal;
import java.util.List;

public final class ResultViewLotteryGame {
    public static final double PROFIT_STANDARD = 1.0;

    public static void displayNumberOfTickets(int numberOfTicketsToBuy) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberOfTicketsToBuy)
                .append("개를 구매했습니다.");
        System.out.println(stringBuilder);
    }

    public static void displayPurchasedTickets(LotteryTickets purchasedTickets) {
        for (LotteryTicket lotteryTicket : purchasedTickets.getLotteryTickets()) {
            System.out.println("[" + displayTicket(lotteryTicket) + "]");
        }
    }

    public static String displayTicket(LotteryTicket lotteryTicket) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LotteryNumber number : lotteryTicket.getLotteryNumbers()) {
            stringBuilder.append(number.getNumber());
            stringBuilder.append(", ");
        }
        return stringBuilder.subSequence(0, stringBuilder.length() - 2).toString();
    }

    public static void displayLotteryResult(LotteryResult lotteryResult, int purchaseAmount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("---------");
        stringBuilder.append(System.getProperty( "line.separator"));

        for (LotteryValue key : lotteryResult.getLotteryResultMap().keySet()) {
            stringBuilder.append(key.getPlace());
            stringBuilder.append("개 일치");
            if (key == LotteryValue.SECOND_PLACE) {
                stringBuilder.append(", 보너스 볼 일치");
            }
            stringBuilder.append("(");
            stringBuilder.append(key.getAmount());
            stringBuilder.append("원)- ");
            stringBuilder.append(lotteryResult.getLotteryResultMap().get(key));
            stringBuilder.append("개");
            stringBuilder.append(System.getProperty("line.separator"));
        }

        BigDecimal profit = lotteryResult.getProfit(purchaseAmount);
        stringBuilder.append("총 수익률은 ");
        stringBuilder.append(profit.toString());
        stringBuilder.append("입니다.");
        if (profit.compareTo(new BigDecimal(PROFIT_STANDARD)) < 0) {
            stringBuilder.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(stringBuilder);
    }
}
