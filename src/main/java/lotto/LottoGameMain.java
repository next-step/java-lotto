package lotto;

import lotto.domain.*;

import java.util.Arrays;

public class LottoGameMain {
    public static void main(String[] args) {
        LottoGame game = new LottoGame(new Money(10_000));
        WinningLotto winningLotto =
                new WinningLotto(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        LottoResult result = game.match(winningLotto);
    }
}
