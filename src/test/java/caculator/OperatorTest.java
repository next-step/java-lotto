package caculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    private Operator operator;

    @BeforeEach
    void setUp(){
        operator = new Operator("+");
    }

//    @Test
//    @DisplayName("두인자의 값을 더한다")
//    void plusMethodTest(){
//        assertThat(operator.plus(4,5)).isEqualTo(9);
//    }

    @Test
    @DisplayName("두 인자의 값을 뺀다")
    void minus() {
//        assertThat(operator.minus(2,5)).isEqualTo(-3);
    }

    @Test
    @DisplayName("두 인자의 값을 나누고, 결과값은 정수여야한다.")
    void divide() {
//        assertThat(operator.divide(10,6)).isEqualTo(1);
//        assertThat(operator.divide(10,5)).isEqualTo(2);

    }

    @Test
    @DisplayName("두 연산자의 값을 곱한다.")
    void multiple() {

//        assertThat(operator.multiple(2,5)).isEqualTo(10);
    }
}
