package view;

import domain.LottoRank;
import util.Calculator;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int THOUSAND_UNiTS = 1000;
    private static final int DEFAULT = 1;

    public static int purchaseLottoCount(int money) {
        int lottoCount = money / THOUSAND_UNiTS;
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public static void printLotto(List<Integer> lotto) {
        System.out.println(lotto.toString());
    }

    public static void statisticsWinner(Map<LottoRank, Integer> produceResult) {
        System.out.println("당첨 통계\n------");
        System.out.println("3개 일치 (" + LottoRank.THREE.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(produceResult.get(LottoRank.THREE)) + "개");
        System.out.println("4개 일치 (" + LottoRank.FOUR.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(produceResult.get(LottoRank.FOUR)) + "개");
        System.out.println("5개 일치 (" + LottoRank.FIVE.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(produceResult.get(LottoRank.FIVE)) + "개");
        System.out.println("6개 일치 (" + LottoRank.SIX.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(produceResult.get(LottoRank.SIX)) + "개");
    }

    public static void printYield(double yield) {
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}
