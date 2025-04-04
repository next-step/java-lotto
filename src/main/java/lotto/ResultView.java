package lotto;

import java.util.Map;

public class ResultView {

    public static void showPurchaseResult(LottoTicket[] lottoTickets) {
        System.out.println(lottoTickets.length + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void showStatistics(Map<LottoPrize, Integer> lottoPrizes, double winningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Map.Entry<LottoPrize, Integer> entry : lottoPrizes.entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue() + "개");
        }
        System.out.println("총 수익률은 " + winningRate + "입니다.");
    }

}
