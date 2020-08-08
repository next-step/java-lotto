package lotto.view;

import lotto.domain.LottoRanking;
import lotto.domain.Lotto;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoResultView {

    public static void printPurchasedLottoNumbers(List<Lotto> lottos) {
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
            int winningCount = winningResultMap.getOrDefault(lottoRanking, 0);
            int matchCount = lottoRanking.getMatchCount();
            int prize = lottoRanking.getPrize();
            System.out.println(
                    MessageFormat.format("{0}개 일치 ({1}원)- {2}개", matchCount, prize, winningCount));
        }
    }

    public static void printSaveOfReturn(double saveOfReturn) {
        System.out.println(
            MessageFormat.format("총 수익률은 {0,number,#.##}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
                saveOfReturn));
    }
}
