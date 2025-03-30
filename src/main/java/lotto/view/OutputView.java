package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
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
