package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호")
class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("숫자로 로또 번호 정상 생성")
    @ValueSource(ints = {1, 45})
    void instance(int number) {
        assertThatNoException().isThrownBy(() -> LottoNumber.from(number));
    }

    @ParameterizedTest
    @DisplayName("문자로 로또 번호 정상 생성")
    @ValueSource(strings = {"1", "45"})
    void instance(String number) {
        assertThatNoException().isThrownBy(() -> LottoNumber.from(number));
    }

    @Test
    @DisplayName("반드시 숫자 형태")
    void instance_invalidFormat_thrownNumberFormatException() {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> LottoNumber.from("abc"));
    }

    @ParameterizedTest(name = "[{index}] {0} 로 로또 번호 생성 불가")
    @DisplayName("로또 번호는 반드시 1에서 45 사이")
    @ValueSource(ints = {0, 46})
    void instance_outOrRange_thrownIllegalArgumentsException(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.from(number));
    }

    @Test
    @DisplayName("주어진 숫자대로 반환")
    void number() {
        //given
        int number = 1;
        //when, then
        assertThat(LottoNumber.from(number).number()).isEqualTo(number);
    }
}
