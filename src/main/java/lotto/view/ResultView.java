package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.MatchType;

import java.util.List;

public class ResultView {

    private static final int PROFIT_BASIS = 1;

    public static void printPurchasePriceInputCommand() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(long lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printAllLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            System.out.println(lottoNumbers);
        }
    }

    public static void printWinningLottoNumberInputCommand() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }


    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinningStatics(List<Integer> matchCounts, int profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (MatchType mc : MatchType.values()) {
            System.out.println(mc.phrase() + "- " + matchCounts.get(mc.matchCountIdx()) + "개");
        }

        System.out.print("총 수익률은 " + profitRate + "입니다.");
        if (profitRate < PROFIT_BASIS) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
