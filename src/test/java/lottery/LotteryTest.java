package lottery;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {

    @Test
    void generateLottery_test() {
        //given
        LotteryNumbers lotteryNumbers = new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6));

        //when
        Lottery lottery = new Lottery(new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6)));

        //then
        assertThat(lottery.numbers()).isEqualTo(lotteryNumbers);
        assertThat(lottery.price()).isEqualTo(1000);
    }
}
