package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryTest {
    @Test
    public void hasNonOverlapping6Numbers() {
        Lottery lottery = Lottery.fromRandom();
        var numbers = lottery.getNumbers();
        assertThat(numbers).hasSize(6);
    }
}
