package lotto;

import lotto.domain.LotteryNo;
import org.junit.Test;

public class LotteryNoTest {

    @Test(expected = IllegalArgumentException.class)
    public void  일부터_사십오의_숫자_입력시_에러_검사() {
        new LotteryNo(46);
    }
}
