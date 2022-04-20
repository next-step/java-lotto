package lotto.model;

import lotto.util.RandomNumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGenerationStrategyTest {

    @Test
    @DisplayName("램덤 숫자들을 생성한다")
    void createRandomNumber() {
        Set<Integer> numbers = RandomNumberUtil.generateNumbers(46, 6);
        assertThat(numbers).hasSize(6);
    }

}