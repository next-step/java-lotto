package lotto.domain;

import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("유효하지 않은 로또 번호(1~45)가 아닐 때 예외 발생")
    void getNumber_fail() {
        // expected
        assertThatThrownBy(() -> new LottoNumber(77))
                .isInstanceOf(InvalidInputException.class);
    }
}
