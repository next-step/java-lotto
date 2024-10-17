package lotto.domain;

import lotto.enums.Rank;
import lotto.service.LottoGame;

import java.util.Objects;

public class LottoResult {

    private final Ranks ranks;
    private final double returnRate;

    public LottoResult(Ranks ranks, int buyPrice) {
        this.ranks = ranks;
        this.returnRate = Math.round((double) getPriceTotal() / buyPrice * 100.0) / 100.0;
    }

    public double getReturnRate() {
        return returnRate;
    }

    long getPriceTotal() {
        return ranks.getPriceTotal();
    }

    public int getWinnerCount(Rank rank) {
        return ranks.getWinnerCount(rank);
    }

    public static LottoResult getLottoResult(Lottos lottos, WinnerLotto winnerLotto) {
        if (lottos.getSize() == 0) {
            throw new IllegalStateException("구매한 로또가 존재하지 않습니다.");
        }
        return new LottoResult(lottos.getRanks(winnerLotto), lottos.getSize() * LottoGame.LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return Double.compare(returnRate, that.returnRate) == 0 && Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks, returnRate);
    }
}
