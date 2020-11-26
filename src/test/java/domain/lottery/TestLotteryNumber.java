package domain.lottery;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class TestLotteryNumber {
    @Test
    void create() {
        LotteryNumber lotteryNumber = new LotteryNumber(1);
        assertThat(lotteryNumber).isEqualTo(new LotteryNumber(1));
    }

    @Test
    void createWithLowerMinNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LotteryNumber lotteryNumber = new LotteryNumber(0);
        });
    }

    @Test
    void createWithBiggerMaxNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           LotteryNumber lotteryNumber = new LotteryNumber(46);
        });
    }

    @Test
    void isContainNumber() {
        LotteryNumber lotteryNumber = new LotteryNumber(1);
        assertThat(lotteryNumber.isContainNumber(new LotteryTicket(Arrays.asList(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        )))).isEqualTo(1);
    }
}
