package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningType;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            List<Integer> lottoNumbers = lotto.getNumbers();
            Collections.sort(lottoNumbers);
            System.out.println("[" + StringUtils.join(lottoNumbers, ", ") + "]");
        });
    }

    public static void printStatistics(Map<WinningType, Integer> statistics) {
        statistics.forEach((winningType, count)
                -> {
            if (winningType != WinningType.NOT_WINNING) {
                System.out.println(winningType.getMatchCount() + "개 일치 (" + winningType.getWinningAmount() + "원)- " + count + "개");
            }
        });
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }
}
