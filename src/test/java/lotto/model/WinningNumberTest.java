package lotto.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void 중복된_숫자가_들어오면_예외를_발생하는지_확인() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "5");
        assertThatExceptionOfType(RuntimeException.class)
          .isThrownBy(() -> new WinningNumber(numbers, 9));
    }

    @Test
    void 다섯개의_숫자가_들어오면_예외를_발생하는지_확인() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");
        assertThatExceptionOfType(RuntimeException.class)
          .isThrownBy(() -> new WinningNumber(numbers,9));
    }

    @Test
    void 일곱개의_숫자가_들어오면_예외를_발생하는지_확인() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6","7");
        assertThatExceptionOfType(RuntimeException.class)
          .isThrownBy(() -> new WinningNumber(numbers,9));
    }
}