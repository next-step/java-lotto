package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨번호 문자열을 숫자로 파싱하는지 테스트")
    void parseWinningNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        assertThat(winningNumbers.numbers).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}