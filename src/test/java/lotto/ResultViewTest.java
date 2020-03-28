package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    private ResultView resultView;

    @DisplayName("당첨번호를 입력 받고 유효성을 체크한다. 동일 숫자가 입력되는 경우")
    @Test
    void inputWinningNumbers() {
        String errorInput = "1,2,2,3,4,5";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            resultView = new ResultView(errorInput);
        });

    }
}
