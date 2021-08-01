package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 숫자")
class LottoNumberTest {

    @DisplayName("[성공] 검증")
    @ParameterizedTest
    @CsvSource(value = {
        "0, false",
        "1, true",
        "45, true",
        "46, false",
    })
    public void isValid(int value, boolean expected) {
        // given

        // when
        boolean isValid = LottoNumber.isValid(value);

        // then
        assertThat(isValid).isEqualTo(expected);
    }
}
