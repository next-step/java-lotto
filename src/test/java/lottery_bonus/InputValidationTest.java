package lottery_bonus;

import lottery_bonus.domain.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    @Test
    @DisplayName("금액 입력값 유효성 체크")
    void validateAmount() {
        String amount = "10000";
        assertThat(InputValidation.validateAmount(amount)).isEqualTo(new BigDecimal(10000));
    }
    @Test
    @DisplayName("금액 입력값 예외 체크")
    void validateAmountException() {
        String amount = "test";
        assertThatThrownBy(
                () ->  InputValidation.validateAmount(amount)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1, 2, 3, 4, 5',5", "'1, 2, 3',3"})
    @DisplayName("당첨숫자 입력값 테스트")
    void validateWinningNumber(String numberList, int expectedSize) {
        List<Integer> winningNumbers = InputValidation.validateWinningNumber(numberList);
        assertThat(winningNumbers.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("당첨숫자 입력값 예외 체크")
    void validateWinningNumberException() {
        String amount = "test";
        assertThatThrownBy(
                () ->  InputValidation.validateWinningNumber(amount)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 볼 유효성 체크")
    void parseInteger() {
        String bonusNumber = "1";
        assertThat(InputValidation.parseInteger(bonusNumber)).isEqualTo(1);
    }
}