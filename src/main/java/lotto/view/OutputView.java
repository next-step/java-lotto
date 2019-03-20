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
        System.out.println("        ------ 당첨통계");
        System.out.println("3개 일치 (5000원)-       " +lotteryResults.getLottoResultMap().get(LottoRank.FOURTH) + "개");
        System.out.println("4개 일치 (50000원)-      " +lotteryResults.getLottoResultMap().get(LottoRank.THIRD) + "개");
        System.out.println("5개 일치 (1500000원)-    " +lotteryResults.getLottoResultMap().get(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " +lotteryResults.getLottoResultMap().get(LottoRank.FIRST) + "개");
        System.out.println("총 수익률은" + lotteryResults.getProfit()  + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임) ");


    }


}
