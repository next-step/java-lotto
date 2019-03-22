package lotto.view;

import lotto.LotteryResults;
import lotto.LottoRank;
import lotto.LottoTicket;

import java.util.List;

public class OutputView {


    public static void printTicketCount(int amount) {
        System.out.println(amount / 1000 + "개를 구매했습니다.");
    }


    public static void printBuyLottoTickets(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }


    public static void printLotteryResult(LotteryResults lotteryResults) {
        String format = "%d개 일치 (%d원)-  %d개\n";
        System.out.println("        ------ 당첨통계");
        System.out.printf(
            format, LottoRank.FOURTH.getCountOfMatch(), LottoRank.FOURTH.getWinningMoney(), lotteryResults.getLottoResults().get(LottoRank.FOURTH));
        System.out.printf(
            format, LottoRank.THIRD.getCountOfMatch(), LottoRank.THIRD.getWinningMoney(), lotteryResults.getLottoResults().get(LottoRank.THIRD));
        System.out.printf(
            format, LottoRank.SECOND.getCountOfMatch(), LottoRank.SECOND.getWinningMoney(), lotteryResults.getLottoResults().get(LottoRank.SECOND));
        System.out.printf(
            format, LottoRank.FIRST.getCountOfMatch(), LottoRank.FIRST.getWinningMoney(), lotteryResults.getLottoResults().get(LottoRank.FIRST));
        System.out.println(String.format("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lotteryResults.getProfit()));

    }


}
