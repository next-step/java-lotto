package lotto.domain;

import java.util.Objects;

/**
 * 당첨 로또.
 */
public class WinningLotto {
    private final Lotto winningLotto;

    public WinningLotto(final Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    /**
     * 주어진 로또와 새로운 로또를 비교하여 상금을 리턴한다.
     *
     * @param lotto 새로운 로또
     * @return 맞은 갯수에 해당하는 상금
     */
    public Prize getPrizeMatch(final Lotto lotto) {
        int matchCount = winningLotto.getLottoMatchCount(lotto);
        return Prize.of(matchCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lotto=" + winningLotto +
                '}';
    }
}
