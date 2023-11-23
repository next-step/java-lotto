package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자 6개를 생성한다.")
    void create_random_numbers() {
        // given
        RandomNumbersGenerator generator = new RandomNumbersGenerator(numbers());

        // when
        List<Integer> result = generator.createRandomNumbers(numbers -> List.of(1, 21, 26, 31, 40, 42));

        // then
        assertThat(result).isEqualTo(List.of(1, 21, 26, 31, 40, 42));
    }

    private List<Integer> numbers() {
        List<Integer> given = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            given.add(i);
        }
        return given;
    }
}