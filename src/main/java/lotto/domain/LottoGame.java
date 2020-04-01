package lotto.domain;

import java.util.List;

public class LottoGame {
    public static int match(List<Integer> userLotto, List<Integer> winningLottoNos, int bonusNo) {
        WinningLotto winningLotto = new WinningLotto(Lotto.of(winningLottoNos), bonusNo);
        return winningLotto.match(Lotto.of(userLotto));
    }
}
