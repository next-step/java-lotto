package view;

import domain.Lotto;
import domain.LottoRank;
import util.Calculator;
import util.Console;

import java.util.Map;

public class ResultView {
    private static final int THOUSAND_UNiTS = 1000;
    private static final int DEFAULT = 1;

    public static int purchaseLottoCount(int money) {
        int lottoCount = money / THOUSAND_UNiTS;
        Console.print(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public static void printLotto(Lotto lotto) {
        Console.print(lotto.toString());
    }

    public static void statisticsWinner(Map<LottoRank, Integer> produceResult) {
        Console.print("당첨 통계\n------");
        Console.print("3개 일치 (" + LottoRank.FIFTH.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(produceResult.get(LottoRank.FIFTH)) + "개");
        Console.print("4개 일치 (" + LottoRank.FOURTH.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(produceResult.get(LottoRank.FOURTH)) + "개");
        Console.print("5개 일치 (" + LottoRank.THIRD.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(produceResult.get(LottoRank.THIRD)) + "개");
        Console.print("5개 일치, 보너스볼 일치 (" + LottoRank.SECOND.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(produceResult.get(LottoRank.SECOND)) + "개");
        Console.print("6개 일치 (" + LottoRank.FIRST.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(produceResult.get(LottoRank.FIRST)) + "개");
    }

    public static void printYield(double yield) {
        Console.print("총 수익률은 " + yield + "입니다.");
    }
}
