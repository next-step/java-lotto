package view;

import domain.Lotto;
import domain.LottoRank;
import util.Calculator;
import util.Console;

import java.util.Map;

public class ResultView {
    private static final int DEFAULT = 1;

    public static void purchaseLottoCount(int manualLottoPaper, int autoLottoPaper) {
        Console.print("수동으로 " + manualLottoPaper + "장, 자동으로 " + autoLottoPaper + "개를 구매했습니다.");
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
