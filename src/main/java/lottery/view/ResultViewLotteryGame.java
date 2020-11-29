package lottery.view;

import lottery.domain.LotteryResult;
import lottery.domain.LotteryTicket;

import java.util.List;

public final class ResultViewLotteryGame {
    public static final double PROFIT_STANDARD = 1.0;

    public static void displayNumberOfTickets(int numberOfTicketsToBuy) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberOfTicketsToBuy)
                .append("개를 구매했습니다.");
        System.out.println(stringBuilder);
    }

    public static void displayPurchasedTickets(List<LotteryTicket> purchasedTickets) {
        StringBuilder stringBuilder;
        for (LotteryTicket lotteryTicket : purchasedTickets) {
            stringBuilder = new StringBuilder();
            System.out.println(stringBuilder.append(lotteryTicket.toString()));
        }
    }

    public static void displayLotteryResult(LotteryResult lotteryResult, int purchaseAmount) {
        lotteryResult.toString();
        double profit = lotteryResult.getProfit(purchaseAmount);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 ");
        stringBuilder.append((double)Math.round(profit*100)/100);
        stringBuilder.append("입니다.");
        if (profit < PROFIT_STANDARD) {
            stringBuilder.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(stringBuilder);
    }
}
