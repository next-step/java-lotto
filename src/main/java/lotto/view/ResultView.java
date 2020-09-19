package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotto(List<Lotto> buyLotto) {
        for(Lotto lotto : buyLotto) {
            System.out.println("[" + String.join(",", lotto.getLottoNumber()) + "]");
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> rank) {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + rank.get(Rank.FOURTH) + "개");
        System.out.println("4개 일치 (50000원) - " + rank.get(Rank.THIRD) + "개");
        System.out.println("5개 일치 (1500000원) - " + rank.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " + rank.get(Rank.FIRST) + "개");
    }

    public static void printTotalYield(String totalYield) {
        System.out.println("총 수익률은 " + totalYield + "입니다.");
    }
}
