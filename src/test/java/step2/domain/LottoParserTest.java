package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoParserTest {
    @Test
    @DisplayName("당첨 로또 번호 파싱 확인")
    void parseWinningNumbers() {
        // Given
        String input = "5, 2, 4, 1, 3, 6";

        // When
        List<Integer> result = LottoParser.parseWinningNumbers(input);

        // Then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 로또 번호 문자열에 구분자가 없는경우 확인")
    void parseWinningNumbers_DelimiterNotFound() {
        // Given
        String input = "5 2 4 1 3 6";
        String expectedMessage = "Input string must contain delimiter ','";

        // When, Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoParser.parseWinningNumbers(input))
                .withMessage(expectedMessage);
    }

    @Test
    @DisplayName("당첨 로또 번호 문자열이 공백인 경우")
    void parseWinningNumbers_ShouldThrowExceptionWhenInputStringIsEmpty() {
        // Given
        String input = "";
        String expectedMessage = "Input string must not be null or empty";

        // When, Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoParser.parseWinningNumbers(input))
                .withMessage(expectedMessage);
    }

    @Test
    @DisplayName("당첨 로또 번호 문자열이 NUll인 경우")
    void parseWinningNumbers_ShouldThrowExceptionWhenInputStringIsNull() {
        // Given
        String input = null;
        String expectedMessage = "Input string must not be null or empty";

        // When, Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoParser.parseWinningNumbers(input))
                .withMessage(expectedMessage);
    }

}
