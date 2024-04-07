package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("성공 : 1에서 45사이의 범위의 숫자")
    @ParameterizedTest
    @ValueSource(ints = {1,45})
    void 성공_객체생성(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("실패 : 1에서 45사이의 범위가 아닌 숫자")
    @ParameterizedTest(name = "[{index}] 1 미만 45 초과 {0} = error")
    @ValueSource(ints = {0,46})
    void 실패_객체생성(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}