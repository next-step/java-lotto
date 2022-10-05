package step2;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static final String RESULT_TEXT = "\n당첨 통계\n---------";
    public static final String BUY_TEXT = "개를 구매했습니다.";
    public static final String THREE_TEXT = "3개 일치 (5000원)- ";
    public static final String FOUR_TEXT = "4개 일치 (50000원)- ";
    public static final String FIVE_TEXT = "5개 일치 (1500000원)- ";
    public static final String SIX_TEXT = "6개 일치 (2000000000원)- ";
    public static final String COUNT_TEXT = "개";
    public static final String LOSS_TEXT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoCount(int lottoNum) {
        System.out.println(lottoNum + BUY_TEXT);
    }

    public static void printLottoNum(List<List<Integer>> lottoArray) {
        for (List<Integer> lotto : lottoArray) {
            System.out.println(lotto.toString());
        }
    }

    public static void printDrawResult(int[] resultArray) {
        System.out.println(RESULT_TEXT);
        System.out.println(THREE_TEXT + resultArray[3] + COUNT_TEXT);
        System.out.println(FOUR_TEXT + resultArray[4] + COUNT_TEXT);
        System.out.println(FIVE_TEXT + resultArray[5] + COUNT_TEXT);
        System.out.println(SIX_TEXT + resultArray[6] + COUNT_TEXT);
    }

    public static void printPercentage(float percentage) {
        System.out.print("총 수익률은" + String.format("%.2f", percentage) + "입니다.");
        if (percentage < 1) {
            System.out.print(LOSS_TEXT);
        }
    }
}
