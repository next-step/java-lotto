package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    void 생성() {
        BasicNumberGenerator numberGenerator = new BasicNumberGenerator();
        assertThat(numberGenerator).isEqualTo(new BasicNumberGenerator());
    }

    @Test
    void 로또번호추출() {
        BasicNumberGenerator numberGenerator = new BasicNumberGenerator();
        List<Integer> numbers = numberGenerator.generate();
        assertThat(numbers).containsAnyOf(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45
        );
    }
}
