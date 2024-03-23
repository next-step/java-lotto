package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static autoLotto.model.LottoConstants.INVALID_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {
    private static final int VALID_NUMBER = 1;
    private static final int INVALID_NUMBER = -1;
    private static final int OUT_OF_RANGE_NUMBER = 111;

    @Test
    @DisplayName("로또번호 생성 성공 : 유효한 값")
    void testLottoNumber_ValidNumber_ShouldConstructCorrectLottoNumber() {
        // when
        LottoNumber lottoNumber = new LottoNumber(VALID_NUMBER);
        int number = lottoNumber.getLottoNumber();

        // then
        assertThat(number).isEqualTo(VALID_NUMBER);
    }

    @ParameterizedTest(name = "로또 번호 생성 실패 : 유효하지 않은 값, 또는 범위")
    @ValueSource(ints = {INVALID_NUMBER, OUT_OF_RANGE_NUMBER})
    void testLottoNumber_InvalidNumbers_ShouldThrowException(int number) {
        // when, then
        assertThatThrownBy(() ->  new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }

}
