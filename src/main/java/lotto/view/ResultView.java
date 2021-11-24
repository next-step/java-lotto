package lotto.view;

import lotto.model.domain.LotteryGameResultDto;
import lotto.model.domain.Rank;
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

    public static void printStatistics(LotteryGameResultDto result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        result.getResults().forEach(
                (rank, count) -> System.out.println(printRank(rank, count))
        );
        System.out.println(getProfitResult(result));
    }

    private static String printRank(Rank rank, int count) {
        if(rank.haveBonus()) return String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개", rank.getCountOfMatch(), rank.getWinningMoney(), count);
        return String.format("%d개 일치 (%d원)- %d개", rank.getCountOfMatch(), rank.getWinningMoney(), count);
    }

    private static String getProfitResult(LotteryGameResultDto result){
        String profitString = String.format("총 수익률은 %.2f 입니다.", result.getProfit());
        String isLossString = result.isLoss() ? "손해" : "이익";
        return profitString + "(기준이 1이기 때문에 결과적으로 " + isLossString + "라는 의미임)";
    }

    private static String printTicket(LotteryTicket ticket) {
        List<String> list = ticket.getNumbers().stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.toList());
        return "[" + String.join(", ", list) + "]";
    }
}