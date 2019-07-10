package domain;

import org.junit.Test;

public class LottoGameTest {

    @Test(expected = IllegalArgumentException.class)
    public void 수동_로또는_구입한_로또수보다_클_수_없다() {
        new LottoGame(3000, 4);
    }
}
