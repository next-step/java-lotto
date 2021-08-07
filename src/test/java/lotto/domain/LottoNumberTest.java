package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest(name = "로또 숫자는 1에서 45 사이의 값이다. - 실패 테스트")
    @ValueSource(ints = {-1, 0, 46})
    public void lottoNumberCreateFailTest(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(number))
                .withMessageContaining(String.valueOf(number));
    }

    @ParameterizedTest(name = "로또 숫자는 1에서 45 사이의 값이다. - 성공 테스트")
    @ValueSource(ints = {1, 23, 45})
    public void lottoNumberCreateSuccessTest(int number) {
        assertThatCode(() -> LottoNumber.of(number))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "로또 숫자 동등성 테스트")
    @ValueSource(ints = {1, 23, 45})
    public void lottoNumberEqualsAndHashcodeTest(int number) {
        assertThat(LottoNumber.of(number))
                .isEqualTo(LottoNumber.of(number));
    }
}