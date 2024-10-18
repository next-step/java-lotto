package calculator.expression;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class OperationExpressionTest {

    @Test
    public void 올바르지_않은_구조검증_테스트(){
        assertThatIllegalArgumentException().isThrownBy(()-> new OperationExpression(new NumberExpression(5), null) {
            @Override
            protected NumberExpression execute(NumberExpression left, NumberExpression right) {
                return null;
            }
        });
    }

}
