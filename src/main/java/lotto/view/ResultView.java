package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String HYPHEN = "---------";
    private static final String LOTTO_RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String LOTTO_RESULT_PROFIT_FORMAT = "총 수익률은 %.2f입니다.";

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
        System.out.println(HYPHEN);
    }

    public static void printResult(LottoResult lottoResult){
        Map<LottoRank, Integer> resultData = lottoResult.getLottoResult();

        for (LottoRank lottoRank : mapSort(resultData)) {
            System.out.println(String.format(
                    LOTTO_RESULT_FORMAT,
                    lottoRank.getMatchCount(),
                    lottoRank.getPrizeMoney(),
                    resultData.get(lottoRank)
            ));
        }
    }

    public static void printProfit(double profitPercent){
        System.out.print(String.format(LOTTO_RESULT_PROFIT_FORMAT, profitPercent));
    }

    private static List<LottoRank> mapSort(Map<LottoRank, Integer> resultData) {
        return resultData.keySet().stream()
                .sorted(Comparator.comparingInt(Enum::ordinal))
                .toList();
    }
}
