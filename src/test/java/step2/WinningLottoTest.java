package step2;

import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    public void match() {
        Lotto lotto = Lotto.create(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = WinningLotto.create(1, 2, 3, 4, 5, 6);
        assertEquals(winningLotto.match(lotto), Rank.FIRST);
    }
}
