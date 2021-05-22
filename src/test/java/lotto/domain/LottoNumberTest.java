package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("객체 생성 및 동등성 확인")
    @Test
    void equals() {
        // given
        int number = 7;

        // when
        LottoNumber lottoNumber = LottoNumber.from(number);
        LottoNumber expectedLottoNumber = LottoNumber.from(number);

        // then
        assertThat(lottoNumber).isEqualTo(expectedLottoNumber);
    }

    @DisplayName("유효 범위를 벗어난 숫자를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validate_number(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 유효한 범위를 벗어났습니다.");
    }
}
