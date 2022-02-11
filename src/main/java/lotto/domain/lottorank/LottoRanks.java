package lotto.domain.lottorank;

import java.util.List;
import java.util.stream.Collectors;

public class LottoRanks {

    private final List<LottoRank> lottoRanks;

    public LottoRanks(final List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public List<Integer> getAmounts() {
        return this.lottoRanks.stream()
                .map(LottoRank::getAmount)
                .collect(Collectors.toList());
    }

    public List<LottoRank> get() {
        return this.lottoRanks;
    }
}
