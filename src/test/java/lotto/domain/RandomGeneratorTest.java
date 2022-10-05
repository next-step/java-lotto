package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class RandomGeneratorTest {

    @DisplayName("중복된 번호는 생성되지 않는다.")
    @Test
    void set() {
        int size = 5;
        Set<Integer> numbers = RandomGenerator.randomNumbers(size, 1, 5);

        assertThat(numbers).hasSize(size);
    }

    @DisplayName("범위보다 큰 사이즈를 입력하면 예외가 발생한다.")
    @Test
    void setException() {
        assertThatThrownBy(() -> RandomGenerator.randomNumbers(6, 1, 5)).isInstanceOf(IllegalArgumentException.class);
    }
}