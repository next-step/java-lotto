package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.*;

public class ResultView {

    private static final String MATCH_RESULT_PRINT_FORMAT = "%d개 일치%s(%d원)- %d개\n";

    public static void printLotto(Lotto lotto) {
        List<LottoNumber> numbers = lotto.getLottoNumbers();
        System.out.println(numbers.toString());
    }

    public static void printPurchaseQuantity(int manualQuantity, int autoQuantity) {
        System.out.println("수동으로 " + manualQuantity + "장, 자동으로" + autoQuantity + "개를 구매했습니다.");
    }

    public static void printMatchStaticsInfo(Map<LottoRank, Integer> staticsMap) {
        printMatchStaticsDescription();
        printMatchResult(FIFTH, "", staticsMap);
        printMatchResult(FOURTH, "", staticsMap);
        printMatchResult(THIRD, "", staticsMap);
        printMatchResult(SECOND, ", 보너스 볼 일치", staticsMap);
        printMatchResult(FIRST, "", staticsMap);
    }

    private static void printMatchStaticsDescription() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    private static void printMatchResult(LottoRank rank, String matchBonusDesc, Map<LottoRank, Integer> staticsMap) {
        System.out.printf(MATCH_RESULT_PRINT_FORMAT, rank.getCountOfMatch(), matchBonusDesc, rank.getPrize(), staticsMap.getOrDefault(rank, 0));
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)\n", profitRate, getResultMessage(profitRate));
    }

    private static String getResultMessage(Double profitRate) {
        return profitRate.compareTo(1.0) > 0 ? "이득이" : "손해";
    }
}
