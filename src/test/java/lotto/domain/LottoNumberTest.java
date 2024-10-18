package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 45})
    void 로또번호는_1에서_45사이이다(int number) {
        LottoNumber lottoNumber = LottoNumber.valueOf(number);

        assertThat(lottoNumber.toString()).hasToString(String.valueOf(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호는_1미만_45초과일_수_없다(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.valueOf(number))
                .withMessage("1 ~ 45 사이의 숫자만 사용할 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void toString은_숫자를_반환한다(int number) {
        LottoNumber lottoNumber = LottoNumber.valueOf(number);

        assertThat(lottoNumber.toString()).hasToString(String.valueOf(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 25, 37, 45})
    void 객체를_캐싱하여_사용한다(int number) {
        LottoNumber number1 = LottoNumber.valueOf(number);
        LottoNumber number2 = LottoNumber.valueOf(number);

        assertThat(number1).isSameAs(number2);
    }
}
