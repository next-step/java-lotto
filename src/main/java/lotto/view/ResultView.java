package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public final class ResultView {

    private static final int INIT = 0;
    private static final int CRITERIA = 1;
    private static final String SEPARATOR = ", ";
    private static final String RIGHT_SQUARE_BRACKET = "[";
    private static final String LEFT_SQUARE_BRACKET = "]";

    public void printLottoCount(final int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public void printLottos(final Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.print(RIGHT_SQUARE_BRACKET);
            printLotto(lotto);
            System.out.println(LEFT_SQUARE_BRACKET);
        }
        System.out.println();
    }

    public void printLotto(final Lotto lotto) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(lotto.getLottoNumbers());
        ;

        int lottoNumberCount = lottoNumbers.size() - 1;

        for (int i = INIT; i < lottoNumberCount; i++) {
            System.out.print(lottoNumbers.get(i).getValue() + SEPARATOR);
        }

        System.out.print(lottoNumbers.get(lottoNumberCount).getValue());
    }

    public void printStatistics(final Result result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.values()) {
            printRankInfo(result, rank);
        }
    }

    private void printRankInfo(final Result result, Rank rank) {
        if (rank == Rank.FIFTH) {
            System.out.printf("3개 일치 (5000원) - %d개%n", result.getRankHitsCount(rank));
        }
        if (rank == Rank.FOURTH) {
            System.out.printf("4개 일치 (50000원) - %d개%n", result.getRankHitsCount(rank));
        }
        if (rank == Rank.THIRD) {
            System.out.printf("5개 일치 (1500000원) - %d개%n", result.getRankHitsCount(rank));
        }
        if (rank == Rank.SECOND) {
            System.out.printf("5개 일치, 보너스 볼 일치(30000000원) - %d개%n", result.getRankHitsCount(rank));
        }
        if (rank == Rank.FIRST) {
            System.out.printf("6개 일치 (2000000000원) - %d개%n", result.getRankHitsCount(rank));
        }
    }

    public void printEarningsRate(final Result result) {
        double earningsRate = result.calculateTotalWinningMoney();
        System.out.printf("총 수익률은 %s입니다.", String.format("%.2f", earningsRate));

        if (earningsRate < CRITERIA) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
