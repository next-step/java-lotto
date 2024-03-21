package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.WinnerPrize;
import lotto.domain.WinningNumbers;

public class ResultView {
    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.getLottoTicketList().forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningStatistics(LottoTickets lottoTickets, WinningNumbers winningNumbers, LottoNumber bonusBall) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + lottoTickets.winnerCount(WinnerPrize.FIFTH, winningNumbers, bonusBall) + "개");
        System.out.println("4개 일치 (50000원) - " + lottoTickets.winnerCount(WinnerPrize.FOURTH, winningNumbers, bonusBall) + "개");
        System.out.println("5개 일치 (1500000원) - " + lottoTickets.winnerCount(WinnerPrize.THIRD, winningNumbers, bonusBall) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + lottoTickets.winnerCount(WinnerPrize.SECOND, winningNumbers, bonusBall) + "개");
        System.out.println("6개 일치 (2000000000원) - " + lottoTickets.winnerCount(WinnerPrize.FIRST, winningNumbers, bonusBall) + "개");
    }

    public static void printEarningsRate(LottoTickets lottoTickets, WinningNumbers winningNumbers, LottoNumber bonusBall) {
        System.out.println("총 수익률은 " + lottoTickets.earningsRate(winningNumbers, bonusBall) + "입니다.");
    }

}
