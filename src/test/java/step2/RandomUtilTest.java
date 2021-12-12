package step2;

import org.junit.jupiter.api.Test;
import step2.domain.util.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {
    @Test
    void getRandomNumbers() {
        assertThat(RandomUtil.getRandomNumbers().get(0))
                .isGreaterThan(0)
                .isLessThanOrEqualTo(45);
    }
}
