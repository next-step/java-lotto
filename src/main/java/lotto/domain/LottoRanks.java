package lotto.domain;

import java.util.List;
import lotto.domain.constant.LottoRank;

public class LottoRanks {

    private static final int LOTTO_PRICE = 1_000;

    private final List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public double rate() {
        return lottoRanks.stream()
            .mapToInt(LottoRank::getWinningAmount)
            .map(winningAmount -> winningAmount / LOTTO_PRICE)
            .average()
            .orElseThrow(IllegalArgumentException::new);
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }
}
