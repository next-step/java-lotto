package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersParserTest {


    @Test
    @DisplayName("쉼표로 구분된 문자열을 WinningNumbers로 변환한다")
    void parseValidInput() {
        String input = "1, 2, 3, 4, 5, 6";
        WinningNumbers winningNumbers = WinningNumbersParser.parse(input);

        assertThat(winningNumbers.size()).isEqualTo(6);

    }

    @Test
    @DisplayName("숫자가 6개가 아니면 예외가 발생한다")
    void parseInvalidCount() {
        String input = "1,2,3,4,5"; // 5개만

        assertThatThrownBy(() -> WinningNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개여야 합니다");
    }

}