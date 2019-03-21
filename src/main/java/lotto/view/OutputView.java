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
        System.out.println("3개 일치 (" + LottoRank.FOURTH + "원)-       " + lotteryResults.getLottoResults().get(LottoRank.FOURTH) + "개");
        System.out.println("4개 일치 (" + LottoRank.THIRD + "원)-      " + lotteryResults.getLottoResults().get(LottoRank.THIRD) + "개");
        System.out.println("5개 일치 (" + LottoRank.SECOND + "원)-    " + lotteryResults.getLottoResults().get(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 ("+LottoRank.FIRST+"원)- " + lotteryResults.getLottoResults().get(LottoRank.FIRST) + "개");
        System.out.println(String.format("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lotteryResults.getProfit()));

    }




}
