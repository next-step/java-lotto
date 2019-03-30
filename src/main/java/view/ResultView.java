package view;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoResult;
import util.Calculator;
import util.Console;

import java.util.Map;

public class ResultView {
    private static final int DEFAULT = 1;

    public static void purchaseLottoCount(int manualLottoPaper, int autoLottoPaper) {
        Console.print("수동으로 " + manualLottoPaper + "장, 자동으로 " + autoLottoPaper + "장을 구매했습니다.");
    }

    public static void printLotto(Lotto lotto) {
        Console.print(lotto.toString());
    }

    public static void statisticsWinner(LottoResult lottoResult) {
        Console.print("당첨 통계\n------");
        Console.print("3개 일치 (" + LottoRank.FIFTH.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(lottoResult.lottoMatchCount(LottoRank.FIFTH)) + "개");
        Console.print("4개 일치 (" + LottoRank.FOURTH.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(lottoResult.lottoMatchCount(LottoRank.FOURTH)) + "개");
        Console.print("5개 일치 (" + LottoRank.THIRD.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(lottoResult.lottoMatchCount(LottoRank.THIRD)) + "개");
        Console.print("5개 일치, 보너스볼 일치 (" + LottoRank.SECOND.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(lottoResult.lottoMatchCount(LottoRank.SECOND)) + "개");
        Console.print("6개 일치 (" + LottoRank.FIRST.calculatePrize(DEFAULT) + "원)-"
                + Calculator.nullToZero(lottoResult.lottoMatchCount(LottoRank.FIRST)) + "개");
    }

    public static void printYield(double yield) {
        Console.print("총 수익률은 " + yield + "입니다.");
    }
}
