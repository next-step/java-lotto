package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.WrongLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    @DisplayName("유효한 범위 내의 숫자로 로또번호 생성이 가능하다.")
    void validate_lotto_number_ok(int testIntValue) {
        assertThatCode(() -> new LottoNumber(testIntValue))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,46})
    @DisplayName("유효한 범위 밖의 숫자로 로또번호 생성을 시도할경우, 예외를 던진다.")
    void validate_lotto_number_ng(int testIntValue) {
        assertThatThrownBy(() -> new LottoNumber(testIntValue))
            .isInstanceOf(WrongLottoNumberException.class);
    }

}