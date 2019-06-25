package lotto.util;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 4, 3, 2, 1})
    void generate(int value) {
        assertThat(LottoGenerator.generate().size()).isEqualTo(value);
    }

    @Test
    @RepeatedTest(10)
    void name() {
        Random random = new Random();
        assertThat(random.nextInt(45) + 1).isBetween(1,45);
    }
}