package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationUnitTest {

    @Test
    @DisplayName("지원하지 않는 연산자를 입력하는 경우 IllegalArgumentException 이 발생")
    public void enter_unsupportedOperand_throwsIllegalArgumentException() {
        assertThatThrownBy(() -> new OperationUnit(1, '&', 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지원하지 않는 연산자 입니다.");
    }

}