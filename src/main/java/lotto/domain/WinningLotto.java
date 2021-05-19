package lotto.domain;

import java.util.Objects;

/**
 * 당첨 로또.
 */
public class WinningLotto {
    private final Lotto lotto;

    public WinningLotto(final Lotto lotto) {
        this.lotto = lotto;
    }

    /**
     * 주어진 로또와 새로운 로또를 비교하여 상금을 리턴한다.
     *
     * @param lotto 새로운 로또
     * @return 맞은 갯수에 해당하는 상금
     */
    public Prize getPrizeMatch(final Lotto lotto) {
        int matchCount = lotto.getLottoMatchCount(lotto);
        return Prize.of(matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lotto=" + lotto +
                '}';
    }
}
