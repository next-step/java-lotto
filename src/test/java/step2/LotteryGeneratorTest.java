package step2;

import org.junit.jupiter.api.Test;
import step2.domain.util.LotteryGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryGeneratorTest {
    @Test
    void getRandomNumbers() {
        assertThat(LotteryGenerator.pickNumbers().get(0))
                .isGreaterThan(0)
                .isLessThanOrEqualTo(45);
    }
}
