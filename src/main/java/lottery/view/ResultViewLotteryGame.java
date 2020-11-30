package lottery.view;

import lottery.domain.LotteryResult;
import lottery.domain.LotteryTicket;

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

    public static void displayPurchasedTickets(List<LotteryTicket> purchasedTickets) {
        StringBuilder stringBuilder;
        for (LotteryTicket lotteryTicket : purchasedTickets) {
            stringBuilder = new StringBuilder();
            System.out.println(stringBuilder.append(lotteryTicket.toString()));
        }
    }

    public static void displayLotteryResult(LotteryResult lotteryResult, int purchaseAmount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("---------");
        stringBuilder.append(System.getProperty( "line.separator"));

        for (Integer key : lotteryResult.getLotteryResultMap().keySet()) {
            stringBuilder.append(key);
            stringBuilder.append("개 일치 (");
            stringBuilder.append(lotteryResult.getLotteryValueMap().get(key));
            stringBuilder.append(")- ");
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
