package lottery.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLotteryStrategyTest {
    LotteryStrategy randomLotteryStrategy;

    @BeforeEach
    void setUp() {
        randomLotteryStrategy = new RandomLotteryStrategy();
    }

    @Test
    void generate() {
        List<Integer> numbers = randomLotteryStrategy.generate().numbers();
        assertThat(numbers).hasSize(Lotteries.LOTTERY_LENGTH);

        for(Integer number : numbers) {
            assertThat(number).isBetween(Lotteries.MIN_LOTTERY_NUMBER, Lotteries.MAX_LOTTERY_NUMBER);
        }
    }
}
