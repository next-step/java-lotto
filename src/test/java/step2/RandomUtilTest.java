package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Number;
import step2.domain.util.RandomUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomUtilTest {
    @Test
    void getRandomNumber() {
        assertThat(RandomUtil.getRandomNumber())
                .isGreaterThan(0)
                .isLessThanOrEqualTo(45);
    }

    @Test
    void getRandomNumbers() {
        assertThat(RandomUtil.getRandomNumbers().get(0))
                .isGreaterThan(0)
                .isLessThanOrEqualTo(45);
    }
}
