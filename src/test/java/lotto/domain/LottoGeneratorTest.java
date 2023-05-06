package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void generateTest(Integer number) {
        assertThat(new LottoGenerator(number).generate().size())
            .isEqualTo(number);
    }

}