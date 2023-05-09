package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "1999,1", "2000,2"})
    void generateTest(Integer money, Integer expected) {
        assertThat(new LottoGenerator(money).generate()
            .size())
            .isEqualTo(expected);
    }

}
