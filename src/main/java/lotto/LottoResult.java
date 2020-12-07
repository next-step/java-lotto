package lotto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

    private static final int PRICE_PER_SHEET = 1_000;

    private final Map<Rank, Integer> result = new LinkedHashMap<>();
    private final int purchasePrice;

    public LottoResult(int lottoTicketCount) {
        this.purchasePrice = lottoTicketCount * PRICE_PER_SHEET;

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void saveLottoResult(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);
        result.put(rank, result.get(rank) + 1);
    }

    public int getProfitRatio() {
        int profitAmount = 0;

        for (Rank rank : result.keySet()) {
            profitAmount += rank.getWinningMoney() * result.get(rank);
        }

        return profitAmount / purchasePrice;
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return purchasePrice == that.purchasePrice &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, purchasePrice);
    }
}
