package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("숫자 문자열을 이용해 LottoNumber을 생성하는지 확인한다.")
    void convertNumber() {
        String number = "6";
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.toString()).isEqualTo(number);
    }

    @Test
    @DisplayName("숫자 이외의 문자열이 들어왔을때 에러가 발생한는지 확인한다.")
    void convertNumberException() {
        String number = "a";
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(number);
        }).hasMessage(LottoNumber.CONVERT_NUMBER_ERROR_MESSAGE)
                .isInstanceOf(NumberFormatException.class);

    }

    @Test
    @DisplayName("1 ~ 45 이외의 숫자 이외의 문자열이 들어왔을때 에러가 발생한는지 확인한다.")
    void checkLottoNumberRange() {
        String number = "50";
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(number);
        }).hasMessage(LottoNumber.OUT_OF_LOTTO_NUMBER_RANGE)
                .isInstanceOf(IllegalArgumentException.class);

    }
}
