package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {"1", "45"})
    void of(int lottoNumber) {
        assertThatCode(() -> LottoNumber.of(lottoNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {"0", "46"})
    void ofWithException(int lottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(lottoNumber));
    }
}
