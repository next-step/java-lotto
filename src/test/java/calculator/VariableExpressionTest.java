package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.VariableExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VariableExpressionTest {

    @DisplayName("캐릭터를 정수로 바꿉니다.")
    @Test
    void transformCharacterToInteger(){
        VariableExpression variableExpression = new VariableExpression("1");
        int result = variableExpression.value();
        assertThat(result).isEqualTo(1);
    }

}
