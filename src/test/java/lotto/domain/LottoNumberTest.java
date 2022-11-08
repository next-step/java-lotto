package lotto.domain;

import exception.CustomException;
import lotto.domain.LottoNumber;
import lotto.exception.LottoErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("int 타입으로 로또 숫자를 생성한다")
    void fromInt() {
        final int number = 5;
        LottoNumber lottoNumber = LottoNumber.from(number);
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("로도 숫자 객체로 로또 숫자를 생성한다")
    void fromLottoNumber() {
        LottoNumber lottoNumber = LottoNumber.from(5);
        LottoNumber fromLottoNumber = LottoNumber.from(lottoNumber);
        assertThat(lottoNumber).isEqualTo(fromLottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 55})
    @DisplayName("로또 숫자의 범위를 넘어서는 수로는 로또 숫자를 생성할 수 없다")
    void maxValueFail(int num) {
        assertThatThrownBy(() -> LottoNumber.from(num))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_NUMBER_BAD_REQUEST.getMessage());
    }
}
