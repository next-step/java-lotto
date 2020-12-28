package lotto.ui;

import lotto.LottoResult;
import lotto.LottoTickets;
import lotto.Rank;

public class OutputView {

    private static final String PURCHASE_COUNT_MESSAGE = "장을 구매 하였습니다.";

    public static void printTicketList(LottoTickets lottoTickets, int purchasePrice, int manualPurchaseCount) {
        System.out.println("수동으로 " + manualPurchaseCount + "장, 자동으로 " + purchasePrice + PURCHASE_COUNT_MESSAGE);
        for (int i = 0; i < lottoTickets.size(); i++) {
            System.out.println(lottoTickets.getLottoTicket(i).getTicket());
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("===========");

        for (Rank rank : lottoResult.getResult().keySet()) {
            System.out.println(rank.getCountOfMatch() + "개 일치(" + rank.getWinningMoney() + ") - " + lottoResult.getResult().get(rank) + "개");
        }

        System.out.println("총 수익률은 " + lottoResult.getProfitRatio() + "입니다.");
    }
}
