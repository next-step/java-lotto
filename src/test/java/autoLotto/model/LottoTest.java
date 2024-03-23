package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static autoLotto.model.LottoConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final String VALID_NUMBERS_AS_STRING = "1,2,3,4,5,6";
    private static final String INVALID_NUMBERS_AS_STRING = "-1,2,3,4,5,111";
    private static final String INVALID_COUNT_OF_NUMBERS_AS_STRING = "1,2,3,4,5,6,7";

    @Test
    @DisplayName("String 인자로 로또 생성 성공")
    void testLotto_ValidNumbersAsString_ShouldConstructCorrectLotto() {
        // when
        Lotto lotto = Lotto.createLottoFrom(VALID_NUMBERS_AS_STRING);
        Set<LottoNumber> lottoNumbers = lotto.getLotto();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(VALID_LOTTO_LENGTH);
        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.getLottoNumber()).isBetween(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
        }
    }

    @Test
    @DisplayName("String 인자로 로또 생성 실패 : 잘못된 값")
    void testLotto_InValidNumbersAsString_ShouldThrowException() {
        // when, then
        assertThatThrownBy(() -> Lotto.createLottoFrom(INVALID_NUMBERS_AS_STRING))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }

    @Test
    @DisplayName("String 인자로 로또 생성 실패 : 잘못된 번호 개수")
    void testLotto_InValidCountOfNumbersAsString_ShouldThrowException() {
        // when, then
        assertThatThrownBy(() -> Lotto.createLottoFrom(INVALID_COUNT_OF_NUMBERS_AS_STRING))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }
}
