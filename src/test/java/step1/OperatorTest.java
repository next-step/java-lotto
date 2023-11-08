package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Seperator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class OperatorTest {

    private static final String NOT_OPERATOR_ERROR_MESSAGE = "사칙 연산 기호가 아닙니다";

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 에러를 발생한다")
    public void not_operator_error() {
        Seperator seperator = new Seperator("&");
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                seperator.operators();
            }).withMessageMatching(NOT_OPERATOR_ERROR_MESSAGE);
    }

}
