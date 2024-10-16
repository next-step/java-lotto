package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.*;

public class ResultView {

    public static final int LOTTO_PRICE = 1000;
    public static final String MATCH_RESULT_PRINT_FORMAT = "%d개 일치%s(%d원)- %d개\n";

    public static void printLotto(Lotto lotto) {
        List<LottoNumber> numbers = lotto.getLottoNumbers();
        System.out.println(numbers.toString());
    }

    public static void printPurchaseQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printMatchStaticsInfo(Map<LottoRank, Integer> staticsMap) {
        printMatchStaticsDescription();
        System.out.printf(MATCH_RESULT_PRINT_FORMAT, FIFTH.getCountOfMatch(), "", FIFTH.getPrize(), staticsMap.getOrDefault(FIFTH, 0));
        System.out.printf(MATCH_RESULT_PRINT_FORMAT, FOURTH.getCountOfMatch(), "", FOURTH.getPrize(), staticsMap.getOrDefault(FOURTH, 0));
        System.out.printf(MATCH_RESULT_PRINT_FORMAT, THIRD.getCountOfMatch(), "", THIRD.getPrize(), staticsMap.getOrDefault(THIRD, 0));
        System.out.printf(MATCH_RESULT_PRINT_FORMAT, SECOND.getCountOfMatch(), ", 보너스 볼 일치", SECOND.getPrize(), staticsMap.getOrDefault(SECOND, 0));
        System.out.printf(MATCH_RESULT_PRINT_FORMAT, FIRST.getCountOfMatch(), "", FIRST.getPrize(), staticsMap.getOrDefault(FIRST, 0));
    }

    private static void printMatchStaticsDescription() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    public static void printProfitRate(int profitAmount, int quantity) {
        System.out.println("profitAmount = " + profitAmount);
        Double profitRate = (double) profitAmount / (quantity * LOTTO_PRICE);
        System.out.printf("총수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)\n", profitRate, getResultMessage(profitRate));
    }

    private static String getResultMessage(Double profitRate) {
        if (profitRate.compareTo(1.0) > 0) {
            return "이득이";
        }
        return "손해";
    }
}
