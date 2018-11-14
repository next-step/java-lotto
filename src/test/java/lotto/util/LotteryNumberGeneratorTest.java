package lotto.util;

import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LotteryNumberGeneratorTest {

    @Test
    public void generate_번호_개수() {
        assertThat(LotteryNumberGenerator.generate().size()).isEqualTo(6);
    }

    @Test
    public void generate_번호_범위() {
        for (int number : LotteryNumberGenerator.generate()) {
            assertThat(number).isLessThanOrEqualTo(45);
            assertThat(number).isGreaterThanOrEqualTo(1);
        }
    }
}
