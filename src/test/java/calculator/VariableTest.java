package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Variable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VariableTest {

    @DisplayName("String을 정수로 바꿉니다.")
    @Test
    void transformCharacterToInteger(){
        Variable variable = Variable.of("1");
        int result = variable.value();
        assertThat(result).isEqualTo(1);
    }

}
