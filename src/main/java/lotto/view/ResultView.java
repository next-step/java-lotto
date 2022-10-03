package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.List;

public class ResultView {

    public static final String LEFT_BRACKET = "[";
    public static final String RIGHT_BRACKET = "]";
    public static final String COMMA_EMPTY_STRING = ", ";

    private ResultView() {}

    public static void availablePurchasePrint(final long count) {

        System.out.printf("%d개를 구매했습니다.", count);
    }

    public static void autoLottoNumberPrint(final LottoNumbers lottoNumbers) {

        blank();
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            appendResult(lottoNumber.getLottoNumber());
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
        for (Integer rank : WinningPrize.init().keySet()) {
            final WinningPrize winningPrice = WinningPrize.from(rank);
            int resultCount = winningResult.getResultCount(winningPrice);
            resultStepPrint(winningPrice, resultCount);
            blank();
        }
    }

    private static void winningStatisticsTitlePrint() {

        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void resultStepPrint(final WinningPrize winningPrice, final int rankCount) {

        System.out.printf("%d개 일치 (%s원)- %d개", winningPrice.getCountOfMatch(), winningPrice.getPrice(), rankCount);
    }

    public static void winningPrizeRatePrint(final ProfitRate profitRate) {

        System.out.printf("총 수익률은 %s 입니다." + check(profitRate), profitRate.getProfitRate());
    }

    private static String check(final ProfitRate profitRate) {

        if (profitRate.canProfit()) {
            return "";
        }
        return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }

    private static void blank() {

        System.out.println();
    }
}
