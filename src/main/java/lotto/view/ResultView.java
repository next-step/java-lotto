package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public final class ResultView {

    private static final int INIT = 0;
    private static final int CRITERIA = 1;
    private static final int MINUS_ONE = -1;
    private static final String SEPARATOR = ", ";
    private static final String RIGHT_SQUARE_BRACKET = "[";
    private static final String LEFT_SQUARE_BRACKET = "]";

    public void printLottoCount(final int count) {
        System.out.println(count + "개를 구매했습니다.");
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
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        for (int i = INIT; i < lottoNumbers.size() + MINUS_ONE; i++) {
            System.out.print(lottoNumbers.get(i).getNumber() + SEPARATOR);
        }

        System.out.print(lottoNumbers.get(lottoNumbers.size() + MINUS_ONE).getNumber());
    }

    public void printStatistics(final Map<Rank, MatchingCount> winnings) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + winnings.getOrDefault(Rank.FOURTH, new MatchingCount()).getMatchingCount() + "개");
        System.out.println("4개 일치 (50000원)- " + winnings.getOrDefault(Rank.THIRD, new MatchingCount()).getMatchingCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + winnings.getOrDefault(Rank.SECOND, new MatchingCount()).getMatchingCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + winnings.getOrDefault(Rank.FIRST, new MatchingCount()).getMatchingCount() + "개");
    }

    public void printEarningsRate(final double earningsRate) {
        System.out.print("총 수익률은 " + earningsRate + "입니다.");

        if (earningsRate < CRITERIA) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
