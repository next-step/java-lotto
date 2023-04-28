package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.RankType;

import java.util.Map;
import java.util.Set;

public class ResultView {

    private static final int PROFIT_BASIS = 1;
    private static final int INIT_VALUE = 0;

    public static void printPurchasePriceInputCommand() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(long lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printAllLottoNumbers(Set<LottoNumbers> lottoNumbersSet) {
        for (LottoNumbers lottoNumbers : lottoNumbersSet) {
            System.out.println(lottoNumbers);
        }
        printNewLine();
    }

    public static void printWinningLottoNumberInputCommand() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printWinningStatics(Map<Integer, Integer> matchCounts, double totalProfitRate) {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (RankType mc : RankType.values()) {
            String phrase = mc.phrase();
            Integer matchCount = matchCounts.get(mc.matchCount());

            if (matchCount == null) {
                matchCount = INIT_VALUE;
            }
            System.out.println(phrase + "- " + matchCount + "개");
        }

        System.out.print("총 수익률은 " + String.format("%.2f", totalProfitRate) + "입니다.");
        if (totalProfitRate < PROFIT_BASIS) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static void printNewLine() {
        System.out.println();
    }
}
