package lotto.view;

import lotto.LottoRank;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.ProfitRate;

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

    public static void printLottoNumber(LottoTicket lottoTicket) {
        Set<LottoNumber> lottoNumberSet = lottoTicket.getLottoTicket();

        String result = "[" + lottoNumberSet.stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.getLottoNumber()))
                .collect(Collectors.joining(", ")) + "]";

        System.out.println(result);
    }

    public static void printWinningStatistics(LottoResult lottoResult) {

        Map<LottoRank, Integer> result = lottoResult.getLottoResult();

        System.out.println("당첨 통계");

        System.out.println("--------");

        System.out.println("3개 일치 (5000원)- " + result.getOrDefault(LottoRank.FIFTH, DEFAULT_COUNT) + "개");
        System.out.println("4개 일치 (50000원)- " + result.getOrDefault(LottoRank.FOURTH, DEFAULT_COUNT) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.getOrDefault(LottoRank.THIRD, DEFAULT_COUNT) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + result.getOrDefault(LottoRank.SECOND, DEFAULT_COUNT) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.getOrDefault(LottoRank.FIRST, DEFAULT_COUNT) + "개");
    }

    public static void printProfitRate(ProfitRate profitRate) {
        System.out.println("총 수익률은 " + Math.floor(profitRate.value() * 100) / 100.0 + "입니다.");
    }
}
