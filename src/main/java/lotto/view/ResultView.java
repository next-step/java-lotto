package lotto.view;

import lotto.LottoRank;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static String COUNT_OF_LOTTO_QUESTION = "개를 구입했습니다.";
    private static int DEFAULT_COUNT = 0;

    private ResultView() {

    }

    public static void countOfLotto(int lottoCount) {
        System.out.println(lottoCount + COUNT_OF_LOTTO_QUESTION);
    }

    public static void printLottoNumber(LottoNumbers lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = lottoNumbers.getLottoNumbers();

        String result = "[" + lottoNumberSet.stream()
                .map(lottoNumber -> lottoNumber.value())
                .collect(Collectors.joining(", ")) + "]";

        System.out.println(result);
    }

    public static void printWinningStatistics(LottoResult lottoResult) {

        Map<LottoRank, Integer> result = lottoResult.getLottoResult();

        System.out.println("당첨 통계");

        System.out.println("--------");

        System.out.println("3개 일치 (5000원)- " + result.getOrDefault(LottoRank.THREE_MATCH, DEFAULT_COUNT) + "개");
        System.out.println("4개 일치 (50000원)- " + result.getOrDefault(LottoRank.FOUR_MATCH, DEFAULT_COUNT) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.getOrDefault(LottoRank.FIVE_MATCH, DEFAULT_COUNT) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + result.getOrDefault(LottoRank.FIVE_MATCH_WITH_BONUS, DEFAULT_COUNT) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.getOrDefault(LottoRank.ALL_MATCH, DEFAULT_COUNT) + "개");
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + Math.floor(profitRate * 100) / 100.0 + "입니다.");
    }
}
