package textcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {


    @DisplayName("두 매개변수의 덧셈이 가능하다")
    @Test
    void plus(){
        int result = Operator.PLUS.apply(1, 2);

        assertThat(result).isEqualTo(3);
    }

}
