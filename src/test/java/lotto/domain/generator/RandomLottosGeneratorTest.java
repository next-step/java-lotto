package lotto.domain.generator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RandomLottosGeneratorTest {

    @ParameterizedTest(name = "로또리스트 추출 검증. lottoCount={0}")
    @ValueSource(ints = {0, 1})
    void generate(int lottoCount) {

        RandomLottosGenerator randomLottosGenerator = new RandomLottosGenerator();
        assertThat(randomLottosGenerator.generate(lottoCount)).hasSize(lottoCount);
    }

    @Test
    void generateWithNegative() {

        RandomLottosGenerator randomLottosGenerator = new RandomLottosGenerator();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> randomLottosGenerator.generate(-1));
    }
}