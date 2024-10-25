package lotto.dto;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.settings.LottoSettings;
import lotto.domain.Rank;

public class RankResult {
    private final List<Rank> ranks;

    public RankResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int count(LottoRank lottoRank) {
        return (int) ranks.stream().filter(r -> r.equals(lottoRank)).count();
    }

    public double calcRate(){
        return calcPrice() / purchaseAmount();
    }

    private double purchaseAmount() {
        return (ranks.size() * LottoSettings.DEFAULT_PRICE.value());
    }

    private int calcPrice() {
        return this.ranks.stream().mapToInt(Rank::price).sum();
    }
}
