package lotto;

import lotto.util.InputValidator;
import lotto.exception.IllegalExpressionElementSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    @DisplayName("[실패] 입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest(name = "{index} ==> input {0} throw IllegalArgumentException")
    @NullAndEmptySource
    void null_공백문자(String inputString) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputValidator.validateEmptyExpression(inputString);
        });
    }

    @Test
    @DisplayName("[실패] 입력 값이 화이트스페이스인 경우 IllegalArgumentException 이 발생한다.")
    void 화이트스페이스_문자() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputValidator.validateEmptyExpression("   ");
        });
    }

    @Test
    @DisplayName("[실패] 분리된 문자열 개수가 짝수개인 경우 IllegalExpressionElementSizeException 이 발생한다.")
    void 항_개수() {
        int size = 4;
        assertThatThrownBy(() -> {
            InputValidator.validateElementSize(size);
        }).isInstanceOf(IllegalExpressionElementSizeException.class)
                .hasMessage(MessageFormat.format("수식 항의 개수가 홀수가 아닙니다. (입력된 항 개수: {0})", size));
    }

}
