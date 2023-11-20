package lotto.domain;

public class LottoGame {
    public static int match(Lotto lotto, Lotto winningLotto) {
        int match = lotto.match(winningLotto);
        return rank(match);
    }

    private static int rank(int match) {
        if (match == 6) {
            return 1;
        }
        if (match == 5) {
            return 2;
        }
        if (match == 4) {
            return 3;
        }
        if (match == 3) {
            return 4;
        }
        return 0;
    }
}
