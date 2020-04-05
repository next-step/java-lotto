package lotto.domain;

public class LottoGame {
    public static Rank match(Lotto lotto, Lotto winningLotto) {
        return Rank.valueOf(lotto.match(winningLotto));
    }
}
