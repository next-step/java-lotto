package lotto.domain;

public class LottoGame {
    public static Rank match(Lotto lotto, Lotto winningLotto) {
        int match = lotto.match(winningLotto);
        return Rank.rank(match);
    }
}
