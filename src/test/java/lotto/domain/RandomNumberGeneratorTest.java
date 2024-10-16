package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static lotto.domain.Lottonumber.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RandomNumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void count_갯수_만큼_숫자를_생성한다(int count) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());
        List<Integer> numbers = generator.generate(count, MIN, MAX);

        assertThat(numbers).hasSize(count);
    }


    @ParameterizedTest
    @ValueSource(ints = {100, 100_000})
    void 중복된_숫자를_포함하면_안된다(int count) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());

        assertThat(generator.generate(count, 1, count)).hasSize(count);
    }

    @ParameterizedTest
    @CsvSource({"1, 45, 45", "1, 1, 1", "0, 10, 11", "-10, -1, 10"})
    void 주어진_범위_내에서_숫자를_생성한다(int min, int max, int expected) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());
        List<Integer> list = generator.generate(max - min + 1, min, max);

        assertThat(list).hasSize(expected);
    }

    @Test
    void 하한은_상한보다_클_수_없다() {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());

        assertThatIllegalArgumentException().isThrownBy(() -> generator.generate(0, MAX, MIN))
                .withMessage("하한값, 상한값을 확인해 주세요.");
    }
}