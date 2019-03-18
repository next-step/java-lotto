package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class ResultView {
    public static void printLottoCounts(final int lottoCounts) {
        System.out.println(lottoCounts + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public static void printWinningStatistics(LottoTicket lottoTicket, List<Integer> winningNumbers) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        // TODO
        System.out.println(lottoTicket.announceWinningResult(winningNumbers));
    }
}
