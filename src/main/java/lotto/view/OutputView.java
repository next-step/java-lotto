package lotto.view;

import lotto.Lotto;
import lotto.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.numbers());
        }
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank rank : LottoRank.values()) {
            int count = statistics.getOrDefault(rank, 0);
            System.out.println(rank.matchCount() + "개 일치 (" + rank.prizeMoney() + "원) - " + count + "개");
        }
    }

    public static void printYield(float yield) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", yield);
    }
}
