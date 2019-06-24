package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersNumberTest {
    @Test
    @DisplayName("로또 번호는 1 미만 입력불가")
    void minNumberTest() {
        //Given
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new LottoNumber(0))
          .withMessage(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.message());
    }
    
    @Test
    @DisplayName("로또 번호 45 초과 입력불가")
    void maxNumberTest() {
        //Given
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new LottoNumber(46))
          .withMessage(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.message());
    }
    
    @Test
    @DisplayName("성공 : 매개변수로 넘어온 수와 같은 수인지 반환.")
    void isEqualsToSuccessTest() {
        //Given
        LottoNumber lottoNumber = new LottoNumber(1);
        //When
        boolean equals = lottoNumber.isEqualsTo(1);
        //Then
        Assertions.assertThat(equals).isTrue();
    }
    
    @Test
    @DisplayName("실패 : 매개변수로 넘어온 수와 같은 수인지 반환.")
    void isEqualsToFailTest() {
        //Given
        LottoNumber lottoNumber = new LottoNumber(1);
        //When
        boolean equals = lottoNumber.isEqualsTo(2);
        //Then
        Assertions.assertThat(equals).isFalse();
    }
}
