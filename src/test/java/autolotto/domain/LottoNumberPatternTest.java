package autolotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberPatternTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    void lottoNumberGiven_ReturnTrue(String number) {
        assertThat(LottoNumberPattern.match(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void notLottoNumberGiven_ReturnFalse(String number) {
        assertThat(LottoNumberPattern.match(number)).isFalse();
    }
}
