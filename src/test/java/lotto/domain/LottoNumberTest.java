package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    public static final int OUT_OF_LOTTO_NUMBER_RANGE = 46;

    @Test
    @DisplayName("1~45 범위 밖의 숫자를 생성하면, Exception을 throw 한다.")
    void should_throw_illegal_argument_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(OUT_OF_LOTTO_NUMBER_RANGE))
                .withMessage(ErrorMessage.LOTTO_NUMBER_IS_OUT_OF_RANGE);
    }

    @Test
    @DisplayName("주어진 숫자에 대한 LottoNumber를 생성한다.")
    void should_return_lotto_number() {
        //Give
        int number = 22;

        //When
        LottoNumber lottoNumber = new LottoNumber(number);

        //Then
        assertThat(lottoNumber.getValue()).isEqualTo(number);
    }

}