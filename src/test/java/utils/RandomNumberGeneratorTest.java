package utils;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;

import lotto.utils.RandomNumberGenerator;

import java.util.List;

public class RandomNumberGeneratorTest {
    
    @Test
    public void 랜덤숫자_여섯자리_검증() {
        List<Integer> numbers = RandomNumberGenerator.generate(1, 45, 6);

        assertUniqueNumber(numbers);
        assertNumberOfRange(numbers);
    }

    private void assertNumberOfRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            assertThat(number).isBetween(1, 45);
        });
    }

    private void assertUniqueNumber(List<Integer> numbers) {
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }
}
