package step5.domain;

import java.util.List;

public class LottoGame {

    public static Rank match(Lotto userLotto, WinningLotto winningLotto) {
        return winningLotto.match(userLotto);
    }

    public static Rank match(List<Integer> userLotto, WinningLotto winningLotto) {
        return winningLotto.match(new Lotto(userLotto));
    }

}
