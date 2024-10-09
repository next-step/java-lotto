package lotto;

import java.util.Map;

public class ResultView {

    public static final int MIN_MATCHED_NUMBERS = 3;

    public void showResult(Map<LottoResult, Integer> result) {

        System.out.println("\n당첨 통계");
        System.out.println("---------");

        result.keySet().stream()
                .filter(lottoResult -> lottoResult.getMatchedLottoNumbersCount() >= MIN_MATCHED_NUMBERS)  // 필터 조건
                .forEach(lottoResult ->
                        System.out.printf("%d개 일치 - %d개%n",
                                lottoResult.getMatchedLottoNumbersCount(),
                                result.get(lottoResult))
                );


    }
}
