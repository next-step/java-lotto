package lotto.view;

import lotto.prize.LottoPrize;
import lotto.result.LottoResult;

import java.util.Map;

public class ResultView {
    private static final int MIN_WINNING_MATCH_COUNT = 3;

    public void showLottoResult(Map<LottoResult, Integer> result, LottoPrize lottoPrize) {

        System.out.println("\n당첨 통계");
        System.out.println("---------");

        result.keySet().stream()
                .filter(lottoResult -> lottoResult.getMatchedLottoNumbersCount() >= MIN_WINNING_MATCH_COUNT)
                .forEach(lottoResult ->
                        System.out.printf("%d개 일치 (%d)원- %d개%n",
                                lottoResult.getMatchedLottoNumbersCount(),
                                lottoPrize.getLottoPrize(lottoResult),
                                result.get(lottoResult))
                );


    }
}
