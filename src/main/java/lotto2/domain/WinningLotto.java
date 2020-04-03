package lotto2.domain;

public class WinningLotto {
    private final Lotto lotto;

    public WinningLotto(final Lotto lotto) {
        this.lotto = lotto;
    }

    public Prize match(Lotto lotto) {
        int matchCount = lotto.getMatchCount(this.lotto);

        return Prize.of(matchCount);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lotto=" + lotto +
                '}';
    }
}
