package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberGeneratorTest {

    @Test
    void 원하는범위의_숫자리스트를_생성한다() {
        List<Integer> numbers = NumberGenerator.generateBasicNumber(1, 45);

        assertThat(numbers).size().isEqualTo(45);
        assertThat(numbers.get(0)).isEqualTo(1);
        assertThat(numbers.get(44)).isEqualTo(45);

        assertThatThrownBy(() -> numbers.get(45))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

}