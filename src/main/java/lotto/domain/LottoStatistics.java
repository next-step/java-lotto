package lotto.domain;

import java.util.List;

public class LottoStatistics {

    private LottoStatistics() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static LottoWinningResults winningStatistics(
            List<List<Integer>> lottoResults,
            List<Integer> lastWeekWinningNumbers
    ) {
        LottoWinningResults lottoWinningResults = new LottoWinningResults();
        lottoResults.stream().forEach(lottoResult -> {
            int winningCount = (int) lottoResult.stream()
                    .filter(lastWeekWinningNumbers::contains)
                    .count();
            lottoWinningResults.incrementWinningResults(winningCount);
        });
        return lottoWinningResults;
    }
}
