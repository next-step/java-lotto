package calculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class ExpressionTest {

    @Test
    void 입력문자열_공백_예외처리(){
        Expression expression = new Expression();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            expression.parse("");
        });
    }

    @Test
    void 입력문자열_null_예외처리(){
        Expression expression = new Expression();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            expression.parse(null);
        });
    }


}
