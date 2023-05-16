package lotto.domain;

import java.util.*;

public class WinnerNumbers {

    private final Set<LottoNumber> numbers;

    public WinnerNumbers(String lottoNumbers) {
        this(LottoNumbersParser.parseToSet(lottoNumbers));
    }

    public WinnerNumbers(Set<LottoNumber> lottoNumbers) {
        LottoValidator.validLottoNumbers(lottoNumbers);
        this.numbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public LottoResults matchLottos(List<Lotto> lottos) {
        Map<Rank, Integer> winningStats = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> winningStats.put(rank, 0));
        lottos.forEach(lotto -> this.markResult(winningStats, lotto));
        return new LottoResults(winningStats);
    }

    private void markResult(Map<Rank, Integer> winningStats, Lotto lotto) {
        int matchCount = this.matchCount(lotto);
        this.markRank(winningStats, matchCount);
    }

    private int matchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    private void markRank(Map<Rank, Integer> winningStats, int matchCount) {
        Rank rank = Rank.findByMatchCount(matchCount);
        winningStats.compute(rank, (k, v) -> v + 1);
    }
}
