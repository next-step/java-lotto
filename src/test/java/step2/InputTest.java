package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @DisplayName("당첨번호 입력받기 확인: 6자리 입력")
    @Test
    public void 당첨번호_입력_자릿수_확인() {
        String[] winningNumbers = "30, 2, 12, 22, 45, 8".split(",");
        assertThat(winningNumbers.length).isEqualTo(Lotto.WINNING_NUMBERS_LENGTH);
    }

}
