package textcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @DisplayName("두 매개변수의 덧셈이 가능하다")
    @Test
    void plus(){
        int result = Operator.PLUS.apply(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("두 매개변수의 뺄셈이 가능하다")
    @Test
    void minus(){
        int result = Operator.MINUS.apply(1, 2);

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("두 매개변수의 곱셈이 가능하다")
    @Test
    void times(){
        int result = Operator.TIMES.apply(1, 2);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("두 매개변수의 나눗셈의 몫을 구할 수 있다")
    @Test
    void divide(){
        int result = Operator.DIVIDE.apply(1, 2);

        assertThat(result).isEqualTo(0);
    }
    
    @DisplayName("0으로는 나눗셈을 할 수 없다")
    @Test
    void divideByZero(){
        assertThatThrownBy(() -> Operator.DIVIDE.apply(10, 0))
            .isInstanceOf(ArithmeticException.class)
            .hasMessage("0으로 나눌 수 없습니다");
    }



}
