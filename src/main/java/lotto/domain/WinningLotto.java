package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static WinningLotto of(List<Integer> numbers) {
        return new WinningLotto(Lotto.of(numbers));
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
