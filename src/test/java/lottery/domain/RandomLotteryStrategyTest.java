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
        List<LotteryNumber> numbers = randomLotteryStrategy.generate().numbers();
        assertThat(numbers).hasSize(Lottery.LENGTH);

        for(LotteryNumber number : numbers) {
            assertThat(number.value()).isBetween(LotteryNumber.MIN, LotteryNumber.MAX);
        }
    }
}
