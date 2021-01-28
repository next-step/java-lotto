package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class WinnerResult {
    private final EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
    private final int earningsRate;  // 수익률

    /**
     * @param winningNumbers   당첨번호
     * @param lottoNumbersList 구입한 로또들
     */
    public WinnerResult(LottoNumbers winningNumbers, List<LottoNumbers> lottoNumbersList) {
        analyze(winningNumbers, lottoNumbersList);  // 당첨 통계 분석
        earningsRate = 0;
    }

    private void analyze(final LottoNumbers winningNumbers, final List<LottoNumbers> lottoNumbersList) {
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            int count = lottoNumbers.getSameNumbersCount(winningNumbers);
            result.put(Rank.of(count), result.getOrDefault(Rank.of(count), 0) + 1);
        }
    }

    public EnumMap<Rank, Integer> getResult() {
        return result;
    }
}
