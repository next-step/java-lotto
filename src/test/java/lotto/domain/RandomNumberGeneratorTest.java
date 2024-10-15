package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void count_갯수_만큼_숫자를_생성한다(int count) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());
        List<Integer> numbers = generator.generate(count, Lottonumber.MIN, Lottonumber.MAX);

        assertThat(numbers).hasSize(count);
    }


    @ParameterizedTest
    @ValueSource(ints = {100, 1_000_000})
    void 중복된_숫자를_포함하면_안된다(int count) {
        RandomNumberGenerator generator = new RandomNumberGenerator(new Random());

        assertThat(generator.generate(count, 1, count)).hasSize(count);
    }
}