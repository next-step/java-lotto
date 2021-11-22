package lotto.view;

import lotto.model.domain.Winning;
import lotto.model.ticket.LotteryTicket;
import lotto.model.ticket.LotteryTickets;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printLotteryCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printTickets(LotteryTickets lotteryTickets) {
        lotteryTickets.getTickets()
                .forEach((ticket) -> System.out.println(printTicket(ticket)));
    }

    public static void printResult(int amount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for(Winning winning : Winning.values()){
            System.out.println(printWinning(winning));
        }
        System.out.println(getProfitResult(amount));
    }

    private static String printWinning(Winning winning) {
        return winning.getMatch() + "개 일치 (" + winning.getPrice() +" 원)- " + winning.getCount() +"개";
    }

    private static String getProfitResult(int amount){
        double profit = Winning.getProfit(amount);
        String profitString = String.format("총 수익률은 %.2f 입니다.", profit);
        String isLossString = Winning.isLoss(profit) ? "손해" : "이익";
        return profitString + "(기준이 1이기 때문에 결과적으로 " + isLossString + "라는 의미임)";
    }

    private static String printTicket(LotteryTicket ticket) {
        List<String> list = ticket.getNumbers().stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.toList());
        return "[" + String.join(", ", list) + "]";
    }
}