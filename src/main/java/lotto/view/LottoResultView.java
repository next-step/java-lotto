package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.Lottos;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;

public class LottoResultView {

    public static void printLottoCount(int manualCount, int autoCount) {
        System.out.println(
                MessageFormat.format("수동으로 {0}장, 자동으로 {1}개를 구매했습니다.", manualCount, autoCount));
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos) {
            int[] numbers = lotto.toArray();
            Arrays.sort(numbers);
            System.out.println(Arrays.toString(numbers));
        }
        System.out.println();
    }

    public static void printWinningResult(Map<LottoRanking, Integer> rankingMap) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking != LottoRanking.NOT_MATCH)
                .forEach(ranking -> printLottoRanking(ranking, rankingMap.getOrDefault(ranking, 0)));
    }

    public static void printSaveOfReturn(double saveOfReturn) {
        System.out.println(
            MessageFormat.format("총 수익률은 {0,number,#.##}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
                saveOfReturn));
    }

    private static void printLottoRanking(LottoRanking ranking, int winningCount) {
        String messageFormat = ranking == LottoRanking.BONUS
                ? "{0}개 일치, 보너스 볼 일치({1}원)- {2}개"
                : "{0}개 일치 ({1}원)- {2}개";
        System.out.println(
                MessageFormat.format(messageFormat,
                        ranking.countOfMatch(),
                        ranking.prize(),
                        winningCount));
    }

}
