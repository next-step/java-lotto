package lotto.view;

import lotto.domain.LottoNumberResult;
import lotto.domain.constant.LottoRank;
import lotto.domain.LottoResult;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String HYPHEN = "---------";
    private static final String LOTTO_RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String LOTTO_RESULT_PROFIT_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String LOTTO_RESULT_ONE_PERCENT_BELOW_FORMAT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
        System.out.println(HYPHEN);
    }

    public static void printResult(LottoResult lottoResult) {
        List<LottoNumberResult> resultData = lottoResult.lottoNumberResult();

        for (LottoNumberResult resultDatum : resultData) {
            System.out.println(String.format(
                    LOTTO_RESULT_FORMAT,
                    resultDatum.getLottoRank().getMatchCount(),
                    resultDatum.getLottoRank().getPrizeMoney(),
                    resultDatum.getMatchCount()
            ));
        }
    }

    public static void printProfit(double profitPercent) {
        System.out.print(String.format(LOTTO_RESULT_PROFIT_FORMAT, profitPercent));
        onePercentBelow(profitPercent);
    }

    private static void onePercentBelow(double profitPercent) {
        if (profitPercent < 1) {
            System.out.println(LOTTO_RESULT_ONE_PERCENT_BELOW_FORMAT);
        }
    }

    private static List<LottoRank> mapSort(Map<LottoRank, Integer> resultData) {
        return resultData.keySet().stream()
                .sorted(Comparator.comparingInt(Enum::ordinal))
                .toList();
    }
}
