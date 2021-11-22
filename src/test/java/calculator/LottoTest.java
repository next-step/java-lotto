package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * @author han
 */
public class LottoTest {

    class Lotto {
        private final List<PositiveNumber> numbers;

        public Lotto(List<PositiveNumber> numbers) {
            this.numbers = numbers;
        }
    }

    @Test
    @DisplayName("로또 생성")
    void create() {
        List<PositiveNumber> numbers = Arrays.asList(new PositiveNumber("8"), new PositiveNumber("23"), new PositiveNumber("41"), new PositiveNumber("42"), new PositiveNumber("43"));
        Lotto l = new Lotto(numbers);
        assertThat(l.numbers.size()).isEqualTo(5);
    }
}
