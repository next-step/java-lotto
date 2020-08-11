package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.Lottos;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;

public class LottoResultView {

    public static void printPurchasedLottoNumbers(Lottos lottos) {
        System.out.println(MessageFormat.format("{0}개를 구매했습니다", lottos.size()));
        for (Lotto lotto : lottos) {
            int[] numbers = lotto.toArray();
            Arrays.sort(numbers);
            System.out.println(Arrays.toString(numbers));
        }
        System.out.println();
    }

    public static void printWinningResult(Map<LottoRanking, Integer> winningResultMap) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---------");
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            if (lottoRanking == LottoRanking.NOT_MATCH) {
                continue;
            }
            int winningCount = winningResultMap.getOrDefault(lottoRanking, 0);
            System.out.println(printLottoRanking(lottoRanking, winningCount));
        }
    }

    public static void printSaveOfReturn(double saveOfReturn) {
        System.out.println(
            MessageFormat.format("총 수익률은 {0,number,#.##}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
                saveOfReturn));
    }

    private static String printLottoRanking(LottoRanking ranking, int winningCount) {
        int matchCount = ranking.countOfMatch();
        int prize = ranking.prize();
        return ranking == LottoRanking.BONUS
            ? MessageFormat.format("{0}개 일치, 보너스 볼 일치({1}원)- {2}개", matchCount, prize, winningCount)
            : MessageFormat.format("{0}개 일치 ({1}원)- {2}개", matchCount, prize, winningCount);

    }
}
