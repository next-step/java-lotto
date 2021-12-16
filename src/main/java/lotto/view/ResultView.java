package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Arrays;

public abstract class ResultView {
    private static final String LOTTO_RESULT_RANK_DEFAULT = " (%d원)- %d개\n";
    private static final String LOTTO_RESULT_RANK_SECOND = ", 보너스 볼 일치(%d원) - %d개\n";

    public static void printPassiveAndActiveLottos(Lottos lottos, int passiveLottosCount) {
        int purchasedLotto = lottos.numberOfLotto();
        System.out.println();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", passiveLottosCount, purchasedLotto - passiveLottosCount);
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        Arrays.stream(Rank.values()).filter(rank -> rank != Rank.MISS).forEach(rank -> {
            System.out.printf("%d개 일치", rank.matchedCount());
            System.out.printf(lottoResultRank(rank), rank.winningAmount(), lottoResult.numberOfLotto(rank));
        });
    }

    private static String lottoResultRank(Rank rank) {
        if (rank == Rank.SECOND) {
            return LOTTO_RESULT_RANK_SECOND;
        }
        return LOTTO_RESULT_RANK_DEFAULT;
    }

    public static void printProfitRate(LottoResult lottoResult) {
        double profitRate = lottoResult.profitRate();
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
        if (profitRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
