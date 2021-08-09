package lotto.step2;

import lotto.step2.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @Test
    @DisplayName("입력한 당첨 번호가 리스트가 생성 되는지 검증")
    void WinningNumberTest() {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,3,4,5,6,10));
        assertThat(winningNumber.getWinningNumbers()).containsExactly(1,3,4,5,6,10);
    }

}