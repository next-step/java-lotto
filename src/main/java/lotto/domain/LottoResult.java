package lotto.domain;

import lotto.enums.Rank;
import lotto.service.LottoGame;

import java.util.List;
import java.util.Objects;

public class LottoResult {

    private final List<Rank> results;
    private final double returnRate;

    public LottoResult(List<Rank> results, int buyPrice) {
        this.results = results;
        this.returnRate = Math.round((double) getPriceTotal() / buyPrice * 100.0) / 100.0;
    }

    public double getReturnRate() {
        return returnRate;
    }

    int getPriceTotal() {
        int result = 0;
        for (Rank rank : this.results) {
            result += rank.getPrice();
        }
        return result;
    }

    public int getWinnerCount(Rank rank) {
        return (int) results.stream()
                .filter(result -> result == rank)
                .count();
    }

    public static LottoResult getLottoResult(Lottos lottos, WinnerLotto winnerLotto) {
        return new LottoResult(lottos.getRanks(winnerLotto), lottos.getSize() * LottoGame.LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) object;
        return Double.compare(getReturnRate(), that.getReturnRate()) == 0 && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, returnRate);
    }
}
