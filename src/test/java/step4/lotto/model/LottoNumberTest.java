package step4.lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.lotto.exception.LottoNumberException;
import step4.lotto.exception.LottoNumberInvalidFormatException;
import step4.lotto.exception.LottoNumberInvalidValueException;

public class LottoNumberTest {

    @Test
    @DisplayName("올바른 로또 번호 입력")
    void givenCorrectLottoNumber_whenCreateLottoNumber_thenSuccess() {
        // given
        String lottoNumber = "1";

        // when
        LottoNumber number = LottoNumber.of(lottoNumber);

        // then
        assertThat(number.value()).isEqualTo(1);
    }

    @Test
    @DisplayName("1보다 작은 로또 번호 입력")
    void givenLessThanOneLottoNumber_whenCreateLottoNumber_thenThrowException() {
        // given
        String lottoNumber = "0";

        // when
        assertThatThrownBy(() -> LottoNumber.of(lottoNumber))

            // then
            .isExactlyInstanceOf(LottoNumberInvalidValueException.class);
    }

    @Test
    @DisplayName("45보다 큰 로또 번호 입력")
    void givenGreaterThanFortyFiveLottoNumber_whenCreateLottoNumber_thenThrowException() {
        // given
        String lottoNumber = "46";

        // when
        assertThatThrownBy(() -> LottoNumber.of(lottoNumber))

            // then
            .isExactlyInstanceOf(LottoNumberInvalidValueException.class);
    }

    @Test
    @DisplayName("정수가 아닌 로또 번호 입력")
    void givenNotIntegerLottoNumber_whenCreateLottoNumber_thenThrowException() {
        // given
        String lottoNumber = "abc";

        // when
        assertThatThrownBy(() -> LottoNumber.of(lottoNumber))

            // then
            .isExactlyInstanceOf(LottoNumberInvalidFormatException.class);
    }

    @Test
    @DisplayName("실수 로또 번호 입력")
    void givenDoubleLottoNumber_whenCreateLottoNumber_thenThrowException() {
        // given
        String lottoNumber = "1.1";

        // when
        assertThatThrownBy(() -> LottoNumber.of(lottoNumber))

            // then
            .isExactlyInstanceOf(LottoNumberInvalidFormatException.class);
    }

}
