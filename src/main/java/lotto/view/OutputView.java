package lotto.view;

import lotto.domain.LottoMatcher;
import lotto.domain.LottoNumberResult;

import java.math.BigDecimal;
import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void outputBuyCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void outputLottoNumbers(List<LottoNumberResult> lottoNumbers) {
        lottoNumbers.forEach(number -> System.out.println(number));
        System.out.println(System.lineSeparator());
    }

    public static void output() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void outputRankingStatistics(List<LottoMatcher> lottoMatchers) {
        List<LottoMatcher> rankingMatchers = LottoMatcher.findRankingMatchers();
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoMatcher lottoMatcher : rankingMatchers) {
            long matchCount = lottoMatchers.stream()
                    .filter(matcher -> matcher == lottoMatcher)
                    .count();

            stringBuilder.append(combineRanking(matchCount, lottoMatcher));
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static String combineRanking(long count, LottoMatcher lottoMatcher) {
        String containsBonusBallString = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
        String notContainsBonusBallString = "%d개 일치 (%d원) - %d개";
        if (lottoMatcher.isMatchBonusBall()) {
            return String.format(containsBonusBallString, lottoMatcher.getMatchingCount(), lottoMatcher.getPrice().intValue(), count);
        }
        return String.format(notContainsBonusBallString, lottoMatcher.getMatchingCount(), lottoMatcher.getPrice().intValue(), count);
    }

    public static void outputEarningRate(BigDecimal earningRate) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", earningRate));
    }
}
