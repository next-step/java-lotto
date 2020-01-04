package lotto.domain;

import lotto.exception.LottoServiceException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 45})
    void 로또_객체가_잘_생성되는지_확인한다(int arg) {
        assertThat(LottoNumber.of(arg).getValue()).isEqualTo(arg);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_사이즈가_레인지를_벗어나면_에러_발생(int arg) {
        assertThatThrownBy(() -> LottoNumber.of(arg))
                .hasMessage(LottoError.WRONG_LOTTO_RANGE.getDescription())
                .isInstanceOf(LottoServiceException.class);
    }
}
