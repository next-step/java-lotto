package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ExpressionValidatorTest {

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest(name = "{index} ==> input {0} throw IllegalArgumentException")
    @NullAndEmptySource
    void null_공백문자(String inputString) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validateEmptyExpression(inputString);
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest(name = "{index} ==> input {0} throw IllegalArgumentException")
    @ValueSource(strings = {"?", "@", ".", ";"})
    void 사칙연산_기호(String operation) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validateOperation(operation);
        });
    }

}
