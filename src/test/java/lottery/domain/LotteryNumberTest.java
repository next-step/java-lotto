package lottery.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumberTest {

    @Test(expected = IllegalArgumentException.class )
    public void test_1보다_작은_숫자_생성_불가능() {
        LotteryNumber.of(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_65보다_큰_숫자_생성_불가능() {
        LotteryNumber.of(66);
    }

    @Test
    public void test_동일성() {
        LotteryNumber lotteryNumber = LotteryNumber.of(5);

        assertThat(lotteryNumber)
                .isSameAs(LotteryNumber.of(5))
                .isEqualTo(LotteryNumber.of(5))
                .hasSameHashCodeAs(LotteryNumber.of(5));
    }

    @Test
    public void test_toString() {
        assertThat(LotteryNumber.of(1))
                .hasToString("1");
    }

    @Test
    public void test_대소비교() {
        LotteryNumber lotteryNumber = LotteryNumber.of(5);

        assertThat(lotteryNumber.compareTo(LotteryNumber.of(6)))
                .isEqualTo(-1);
        assertThat(lotteryNumber.compareTo(LotteryNumber.of(5)))
                .isEqualTo(0);
        assertThat(lotteryNumber.compareTo(LotteryNumber.of(4)))
                .isEqualTo(1);
    }
}
