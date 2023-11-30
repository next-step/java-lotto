package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    @DisplayName("1 ~ 45 사이의 중복되지 않은 6개의 숫자를 선택한다")
    void random_generate() {
        RandomGenerator randomGenerator = new RandomGenerator();

        List<Integer> random = randomGenerator.generate();
        assertThat(random).hasSize(6);
        for (Integer value : random) {
            assertThat(value).isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(45);
        }
        assertThat(new HashSet<>(random)).hasSize(6);
    }
}