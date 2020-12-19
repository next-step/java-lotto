package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("1에서 45사이의 로또번호 반환")
    void testGetLottoNumberInRange() {
        int number = 1;
        assertThat(LottoNumber.of(number).getValue()).isEqualTo(number);
    }

    @Test
    @DisplayName("1에서 45사이의 로또번호가 아닐 경우 예외 발생")
    void testGetLottoNumberOutOfRange() {
        int number = 46;
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }

    @Test
    @DisplayName("문자열로 로또번호 반환")
    void testGetLottoNumberByString() {
        assertThat(LottoNumber.of("1").getValue()).isEqualTo(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 이나 empty 인 문자열로 번호 생성 시 예외 발생")
    void testGetLottoNumberWithNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(input));
    }

    @Test
    @DisplayName("숫자가 아닌 문자열로 번호 생성 시 예외 발생")
    void testGetLottoNumberWithInvalidNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of("a"));
    }
}
