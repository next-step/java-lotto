import Lotto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {


    @Test
    @DisplayName("당첨번호를 입력시 값이 Null이면 예외를반환한다")
    void winningNumberInsertNull() {
        String numbers = "";
        assertThatThrownBy(() -> WinningNumber.of(numbers).getWinningNumbers()).isInstanceOf(IllegalArgumentException.class);

    }
}
