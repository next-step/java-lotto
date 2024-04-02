package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.HashMap;

public class ResultView {
    public static void printPassiveAndAutoCount(int passive, int auto) {
        System.out.println("수동으로 " + passive + "장, 자동으로 " +  auto + "장을 구매했습니다.");
    }

    public static void printLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printResult(HashMap<Rank, Integer> matchResult, double revenue) {
        System.out.println("당첨 통계\n" + "-".repeat(9));
        for (Rank rank : Rank.values()) {
            exceptNone(rank, matchResult);
        }
        System.out.println("총 수익률은 " + revenue + "입니다.");
    }

    private static void exceptNone(Rank rank, HashMap<Rank, Integer> matchResult) {
        if (rank != Rank.NONE)
            System.out.println(rank.getMatchCount() + "개 일치" + printBonusResult(rank) + "(" + rank.getPrize() + ") - " + matchResult.get(rank) + "개");
    }

    private static String printBonusResult(Rank rank) {
        if (rank == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
