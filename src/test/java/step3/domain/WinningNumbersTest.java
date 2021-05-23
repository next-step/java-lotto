package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.common.ErrorCode;
import step3.common.WinningType;

import static org.assertj.core.api.Assertions.*;

public class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호 생성 테스트")
    void winningNumbersTest_shouldThrowDuplicatedException() {
        assertThatThrownBy(()->new WinningNumbers(new int[] {1, 1, 3, 4, 5, 6}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATED_WINNING_NUMBER.getErrorMessage());
        new WinningNumbers(new int[] {1, 2, 3, 4, 5, 6});
    }

}
