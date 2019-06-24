package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.WinLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoTest {
    @Test
    @DisplayName("입력된 숫자의 총 숫자 갯수가 6개가 아니면 에러")
    void checkWinNumberCountTest() {
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> new WinLotto("1,2,3,4,5"))
            .withMessage(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.message());
    }
    
    @Test
    @DisplayName("입력된 숫자 중 1 ~ 45 범위를 넘어가는 숫자가 있다면 에러")
    void test() {
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> new WinLotto("1,2,3,4,5,46"))
            .withMessage(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.message());
    }
}
