package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 번호는 1 미만 입력불가")
    void minNumberTest() {
        //Given
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new LottoNumber(0))
          .withMessage(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.message());
    }
}
