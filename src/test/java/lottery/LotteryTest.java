package lottery;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryTest {
    @Test
    public void hasNonOverlappingSixNumbers() {
        var row = LotteryRow.fromRandom();

        var lottery = new Lottery(row);

        assertThat(new HashSet<>(lottery.getNumbers())).hasSize(6);
    }
}
