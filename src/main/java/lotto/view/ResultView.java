package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    private static final int THREE_MATCH_MONEY = 5000;
    private static final int FOUR_MATCH_MONEY = 50000;
    private static final int FIVE_MATCH_MONEY = 1500000;
    private static final int SIX_MATCH_MONEY = 2000000000;

    public static void outputPickLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void outputLottoResult(int[] result, int paymentCost) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + THREE_MATCH_MONEY + "원) - " + result[3] + "개");
        System.out.println("4개 일치 (" + FOUR_MATCH_MONEY + "원) - " + result[4] + "개");
        System.out.println("5개 일치 (" + FIVE_MATCH_MONEY + "원) - " + result[5] + "개");
        System.out.println("6개 일치 (" + SIX_MATCH_MONEY + "원) - " + result[6] + "개");

        double rate = rateOfReturn(result, paymentCost);
        System.out.println("총 수익률은 " + rate + "입니다. (본전 1 기준)");
    }

    private static double rateOfReturn(int[] result, int paymentCost) {
        int sumReturn = THREE_MATCH_MONEY * result[3]
                + FOUR_MATCH_MONEY * result[4]
                + FIVE_MATCH_MONEY * result[5]
                + SIX_MATCH_MONEY * result[6];
        return Math.round(sumReturn / paymentCost * 100) / 100.0;
    }
}
