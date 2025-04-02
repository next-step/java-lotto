package lotto.view;

import lotto.domain.*;

import java.util.Map;
import java.util.Set;

public class OutputView {
    public static void printLottoList(Lottos lottos) {
        String messageFormat = "\n수동으로 %d장, 자동으로 %d장 구매했습니다.";
        System.out.println(String.format(messageFormat, lottos.countManualLotto(), lottos.countAutoLotto()));

        for (Lotto lotto : lottos.getLottos()) {
            Set<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NO_PRIZE) {
                continue;
            }

            int matchCount = rank.getMatchCount();
            int prize = rank.getPrize();

            Map<Rank, Integer> lottoStatistics = lottoResult.getLottoStatistics();
            int winningLottoCount = lottoStatistics.get(rank);

            System.out.println(String.format("%d개 일치 (%d원) - %d개", matchCount, prize, winningLottoCount));
        }

        System.out.println(String.format("총 수익률은 %.2f 입니다.", lottoResult.getROI()));
    }

}
