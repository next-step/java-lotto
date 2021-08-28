package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {

    @Test
    @DisplayName("번호를 랜덤하게 6개 생성할 수 있다.")
    void generateRandomNumbersTest() {

        // when
        List<Number> numbers = RandomNumbersGenerator.generateNumbers();

        // then
        assertThat(numbers.size()).isEqualTo(6);
    }
}