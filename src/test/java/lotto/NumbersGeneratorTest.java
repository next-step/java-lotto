package lotto;

import lotto.domain.NumbersGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersGeneratorTest {

    @Test
    void numbersGenerator() {
        // GIVE
        NumbersGenerator numbersGenerator = new NumbersGenerator();
        // WHEN
        // THAT
        assertThat(numbersGenerator.getNumbers().size()).isEqualTo(6);
    }
}
