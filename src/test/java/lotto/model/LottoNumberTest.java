package lotto.model;

import lotto.factory.LottoNumberFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"8", "21", "23", "41", "42", "43"})
    @DisplayName("로또 번호 생성 테스트")
    void constructor(int input) {
        LottoNumber lottoNumber = LottoNumberFactory.manualCreateNumber(input);
        assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
    }

    @Test
    @DisplayName("로또 번호가 같으면 같은 객체")
    void equals() {
        LottoNumber lottoNumber = LottoNumberFactory.manualCreateNumber(8);
        assertThat(lottoNumber).isEqualTo(LottoNumberFactory.manualCreateNumber("8"));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("생성된 로또 번호 1~45 사이가 아닐 경우 예외 발생")
    void invalid(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumberFactory.manualCreateNumber(input));
    }

    @Test
    @DisplayName("랜덤 숫자가 1~45 사이의 값인지 테스트")
    void randomNumber() {
        LottoNumber lottoNumber = LottoNumberFactory.autoCreateNumber(() -> 45);
        assertThat(lottoNumber.getNumber())
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(45);
    }
}