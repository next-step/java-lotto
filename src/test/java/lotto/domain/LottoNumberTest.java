package lotto.domain;

import lotto.exception.LottoNumberException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "ㄱ"})
    void 양수가_아닌_값(String input) {
        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new LottoNumber(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void 번호_범위(String input) {
        assertThatExceptionOfType(LottoNumberException.class)
                .isThrownBy(() -> new LottoNumber(input));
    }
}