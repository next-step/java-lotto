package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorRequestTest {

    @DisplayName("동일한 숫자와 산술 연산자를 가지고 있다면, 동일해야 한다.")
    @Test
    void equalsAndHashCode() {
        CalculatorRequest request1 = new CalculatorRequest(
                List.of(1, 2, 3),
                List.of(ArithmeticOperator.PLUS, ArithmeticOperator.MINUS)
        );
        CalculatorRequest request2 = new CalculatorRequest(
                List.of(1, 2, 3),
                List.of(ArithmeticOperator.PLUS, ArithmeticOperator.MINUS)
        );
        assertThat(request1).isEqualTo(request2);
    }

    @DisplayName("연산할 숫자의 개수와 연산 기호의 개수 + 1이 같지 않으면, 예외가 발생해야 한다.")
    @Test
    void validate() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CalculatorRequest(
                        List.of(1, 2, 3),
                        List.of(ArithmeticOperator.PLUS)
                ));
    }

}
