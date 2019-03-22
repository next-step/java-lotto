package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumberTest {

    @Test(expected = IllegalArgumentException.class )
    public void test_1보다_작은_숫자_생성_불가능() {
        new LotteryNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_65보다_큰_숫자_생성_불가능() {
        new LotteryNumber(66);
    }

    @Test
    public void test_동일성() {
        LotteryNumber lotteryNumber = new LotteryNumber(5);

        assertThat(lotteryNumber).isEqualTo(new LotteryNumber(5));
        assertThat(lotteryNumber).hasSameHashCodeAs(new LotteryNumber(5));
    }

    @Test
    public void test_toString() {
        assertThat(new LotteryNumber(1))
                .hasToString("1");
    }
}
