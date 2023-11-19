package step1.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionTest {


    @Test
    @DisplayName("연산자와 피연산자의 갯수의 합은 홀수가 아니면 완전한 식이 아니다.")
    void createExpressionFail() {
        String[] tokens = new String[]{"1", "*", "2", "-"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Expression(tokens);
        });
    }

    @Test
    @DisplayName("연산자와 피연산자의 순서가 올바르게 지켜지지 않으면 실패한다.")
    void createExpressionFail2() {
        String[] tokens = new String[]{"1", "2", "-"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Expression(tokens).calculate();
        });
    }

}
