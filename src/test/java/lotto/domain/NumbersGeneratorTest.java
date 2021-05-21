package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersGeneratorTest {

    @Test
    @DisplayName("6개의 임의의 숫자를 생성한다")
    void validLottoNumbersLengthTest() {
        NumbersGenerator numberGenerator = new RandomNumbersGenerator();
        List<Integer> numbers = numberGenerator.generate();
        assertThat(numbers).hasSize(6);
    }
}
