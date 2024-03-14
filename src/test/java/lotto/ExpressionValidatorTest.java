package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ExpressionValidatorTest {

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest(name = "{index} ==> input {0} throw IllegalArgumentException")
    @NullAndEmptySource
    void null_공백문자(String inputString) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validateInputExpression(inputString);
        });
    }

}
