package lotto.domain;

public class LottoGame {
    public static int match(Lotto userLotto, WinningLotto winningLotto) {
        return winningLotto.match(userLotto);
    }
}
