package lotto;

import lotto.domain.LotteryNo;
import org.junit.Test;

public class LotteryNoTest {

    @Test(expected = IllegalArgumentException.class)
    public void  사십오의_이상의_숫자_입력시_에러_검사() {
        new LotteryNo(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void  일이하의_숫자_입력시_에러_검사() {
        new LotteryNo(-1);
    }
}
