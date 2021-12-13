package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResults {
    private static final int MIN_RANK_MATCH_COUNT = 3;

    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults of(List<Lotto> lottos, PrizeLotto prizeLotto) {
        List<LottoResult> lottoResults1 = Arrays.stream(Rank.values())
                .map(rank -> new LottoResult(rank, Collections.frequency(lottoRanks(lottos, prizeLotto), rank)))
                .collect(Collectors.toList());
        return new LottoResults(lottoResults1);
    }

    private static List<Rank> lottoRanks(List<Lotto> lottos, PrizeLotto prizeLotto) {
        return lottos.stream()
                .filter(lotto -> lotto.matchCountLottoNumbers(prizeLotto) >= MIN_RANK_MATCH_COUNT)
                .map(lotto -> Rank.valueOf(lotto.matchCountLottoNumbers(prizeLotto), prizeLotto.matchBonusNumber(lotto)))
                .collect(Collectors.toList());
    }

    public float totalEarnRate(int purchaseAmount) {
        return Math.round(totalEarnMoney() / purchaseAmount * 100) / 100.F;
    }

    public double totalEarnMoney() {
        return lottoResults.stream()
                .mapToDouble(lottoResult -> lottoResult.sumResult())
                .sum();
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}
