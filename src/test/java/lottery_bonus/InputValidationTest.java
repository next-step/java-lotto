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

}