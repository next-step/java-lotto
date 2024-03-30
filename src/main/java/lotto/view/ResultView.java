package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.ManualLottoCount;
import lotto.domain.WinnerPrize;

public class ResultView {
    public static void printLottoTickets(LottoTickets lottoTickets, ManualLottoCount manualLottoCount) {
        System.out.println("수동으로 " + manualLottoCount.value() + "장, 자동으로 " + (lottoTickets.size() - manualLottoCount.value()) + "개를 구매했습니다.");
        lottoTickets.getLottoTicketList().forEach(System.out::println);
        System.out.println();
    }

    public static void printLottoResult(LottoResult lottoResult) {
        printWinningStatistics(lottoResult);
        printEarningsRate(lottoResult.earningsRate());
    }

    private static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + lottoResult.winnerCount(WinnerPrize.FIFTH) + "개");
        System.out.println("4개 일치 (50000원) - " + lottoResult.winnerCount(WinnerPrize.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원) - " + lottoResult.winnerCount(WinnerPrize.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + lottoResult.winnerCount(WinnerPrize.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " + lottoResult.winnerCount(WinnerPrize.FIRST) + "개");
    }

    private static void printEarningsRate(double earningsRate) {
        System.out.println("총 수익률은 " + earningsRate + "입니다.");
    }
}
