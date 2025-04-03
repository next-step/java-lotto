package lotto.domain;

import lotto.view.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersParserTest {


    @Test
    @DisplayName("쉼표로 구분된 문자열을 WinningNumbers로 변환한다")
    void parseValidInput() {
        String input = "1, 2, 3, 4, 5, 6";
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningNumbers winningNumbers = Parser.parseWinningNumbers(input, bonusNumber);

        assertThat(winningNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자가 6개가 아니면 예외가 발생한다")
    void parseInvalidCount() {
        String input = "1,2,3,4,5"; // 5개만
        int bonusNumber = 7;

        assertThatThrownBy(() -> Parser.parseWinningNumbers(input, new LottoNumber(7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개여야 합니다");
    }

}