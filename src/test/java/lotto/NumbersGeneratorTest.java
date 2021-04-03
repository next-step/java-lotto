package lotto;

import lotto.domain.NumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersGeneratorTest {

    @DisplayName("NumbersGenerator 객체 생성 시 랜덤의 숫자 6가지 반환")
    @Test
    void numbersGenerator() {
        // GIVE
        NumbersGenerator numbersGenerator = new NumbersGenerator();
        // WHEN
        // THAT
        assertThat(numbersGenerator.getNumbers().size()).isEqualTo(6);
    }
}
