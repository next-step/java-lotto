package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("init Class")
    @ParameterizedTest
    @CsvSource(value = {"45:6", "100:5", "25:7"}, delimiter = ':')
    public void testClassInitialize(int lottoMaxLimit, int lottoDrawLimit) {

        Lotto lotto = Lotto.of(lottoMaxLimit, lottoDrawLimit);

        assertThat(lotto.getNumbers().size()).isEqualTo(lottoDrawLimit);

    }

}
