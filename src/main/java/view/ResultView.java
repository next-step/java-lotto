package view;

import lotto.Lotto;
import lotto.Winners;

import java.util.List;

public class ResultView {
    public static void printLottoNumber(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구입 했습니다.");
        lottoTickets.forEach(i -> System.out.println(i.printLottoNumber()));
    }

    public static void printWinningResult(Winners winners) {
        System.out.println("3개 일치 (5000원) - " + winners.getFifth() + "개");
        System.out.println("4개 일치 (50000원) - " + winners.getForth() + "개");
        System.out.println("5개 일치 (1500000원) - " + winners.getThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winners.getSecond() + "개");
        System.out.println("6개 일치 (2000000000원) - " + winners.getFirst() + "개");
    }

    public static void printProfit(Winners winners, int amount) {
        float winningPrice = ((float) (winners.getProfit() / amount - 1) * 100);

        System.out.println("총 수익율은 " + winningPrice + "%입니다");
    }
}
