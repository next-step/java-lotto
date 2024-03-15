package lotto;

import lotto.domain.ExpressionValidator;
import lotto.exception.IllegalExpressionElementSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.*;

public class ExpressionValidatorTest {

    @DisplayName("[실패] 입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest(name = "{index} ==> input {0} throw IllegalArgumentException")
    @NullAndEmptySource
    void null_공백문자(String inputString) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validateEmptyExpression(inputString);
        });
    }

    @DisplayName("[실패] 사칙연산 기호가 아닌 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest(name = "{index} ==> input {0} throw IllegalArgumentException")
    @ValueSource(strings = {"?", "@", ".", ";"})
    void 사칙연산_기호(String operation) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ExpressionValidator.validateOperation(operation);
        });
    }

    @Test
    @DisplayName("[실패] 분리된 문자열 개수가 짝수개인 경우 IllegalExpressionElementSizeException 이 발생한다.")
    void 항_개수() {
        int size = 4;
        assertThatThrownBy(() -> {
            ExpressionValidator.validateElementSize(size);
        }).isInstanceOf(IllegalExpressionElementSizeException.class)
                .hasMessage(MessageFormat.format("수식 항의 개수가 홀수가 아닙니다. (입력된 항 개수: {0})", size));
    }

}
