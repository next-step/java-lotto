package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultView {

    public static final String LEFT_BRACKET = "[";
    public static final String RIGHT_BRACKET = "]";
    public static final String COMMA_EMPTY_STRING = ", ";
    public static final String EMPTY = "";

    private ResultView() {}

    public static void availablePurchasePrint(final long count) {

        System.out.printf("%d개를 구매했습니다.", count);
    }

    public static void autoLottoNumberPrint(final Lottos lottos) {

        blank();
        for (Lotto lotto : lottos.getLottos()) {
            appendResult(lotto.getLotto());
        }
    }

    private static void appendResult(final List<Number> lottoNumber1) {

        final StringBuilder result = new StringBuilder();
        result.append(LEFT_BRACKET);
        int index = 1;
        for (Number number : lottoNumber1) {
            appendNumber(lottoNumber1, result, index, number);
            index++;
        }
        result.append(RIGHT_BRACKET);
        System.out.println(result);
    }

    private static void appendNumber(final List<Number> lottoNumber1, final StringBuilder result, final int index, final Number number) {

        result.append(number.getNumber());
        if (lottoNumber1.size() != index) {
            result.append(COMMA_EMPTY_STRING);
        }
    }

    public static void winningResultPrint(final WinningResult winningResult) {

        winningStatisticsTitlePrint();
        final List<WinningPrize> keySet = sort();
        for (WinningPrize winningPrize : keySet) {
            if (skip(winningPrize)) continue;
            resultStepPrint(winningPrize, winningResult.getResultCount(winningPrize));
            blank();
        }
    }

    private static List<WinningPrize> sort() {

        final List<WinningPrize> winningPrizes = new ArrayList<>(WinningPrize.init().keySet());
        Collections.sort(winningPrizes);
        Collections.reverse(winningPrizes);
        return winningPrizes;
    }

    private static boolean skip(final WinningPrize winningPrize) {

        return winningPrize == WinningPrize.MISS;
    }

    private static void winningStatisticsTitlePrint() {

        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void resultStepPrint(final WinningPrize winningPrice, final int rankCount) {

        System.out.printf("%d개 일치" +bonusCheck(winningPrice)+ " (%s원)- %d개", winningPrice.getCountOfMatch(), winningPrice.getPrice(), rankCount);
    }

    private static String bonusCheck(final WinningPrize winningPrize) {

        if (winningPrize.isMatchOfBonus()) {
            return ", 보너스 볼 일치";
        }
        return EMPTY;
    }

    public static void winningPrizeRatePrint(final ProfitRate profitRate) {

        System.out.printf("총 수익률은 %s 입니다." + check(profitRate), profitRate.getProfitRate());
    }

    private static String check(final ProfitRate profitRate) {

        if (profitRate.canProfit()) {
            return EMPTY;
        }
        return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }

    private static void blank() {

        System.out.println();
    }
}
