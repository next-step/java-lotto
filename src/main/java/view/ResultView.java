package view;

import lotto.Lotto;

import java.util.List;

public class ResultView {
    public static void printLottoNumber(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size()+"개를 구입 했습니다.");
        lottoTickets.forEach(i ->
                System.out.println(i.printLottoNumber())
        );
    }

    public static void printWinningResult(int[] winners) {
        System.out.println("3개 일치 (5000원) - "+winners[4]+"개");
        System.out.println("4개 일치 (50000원) - "+winners[3]+"개");
        System.out.println("5개 일치 (1500000원) - "+winners[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - "+winners[1]+"개");
        System.out.println("6개 일치 (2000000000원) - "+winners[0]+"개");
    }

    public static void printProfit(int[] winners, int amount) {
        float winningPrice =
                ((float) (winners[0]*2000000000 +
                        winners[1]*30000000 +
                        winners[2]*1500000 +
                        winners[3]*50000 +
                        winners[4]*5000)/amount-1)*100;

        System.out.println("총 수익율은 "+winningPrice+"%입니다");
    }
}
