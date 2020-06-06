package lotto.ui;

import lotto.domain.lotto.LottoTicket;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.getLottoTicket()
                .forEach(ticket -> System.out.println(ticket.toString()));

    }

    public static void printWinningRate(double winningRate) {
        System.out.println("총 수익률은 " + winningRate + "입니다.");
        if (winningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해의 의미임)");
        }
    }

    public static void printWinningResult() {
        System.out.println("\n당첨 통계\n————");
    }

    public static void printWinningResult(int match, int price, int winningCount) {
        System.out.println(match + "개 일치(" + price + "원) - " + winningCount + "개");
    }

}
