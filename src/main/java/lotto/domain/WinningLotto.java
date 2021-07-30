package lotto.domain;

public class WinningLotto {
    private final Lotto value;
    public WinningLotto(Lotto value) {
        this.value = value;
    }

    public LottoRank rank(Lotto lotto) {
        return LottoRank.of(
                this.value.containsCount(lotto)
        );
    }
}
