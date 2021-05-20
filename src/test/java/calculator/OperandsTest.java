package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandsTest {


    @DisplayName("contains()를 통해 Operands에 일치하는 숫자가 있는지 테스트한다")
    @Test
    void contains_true_when_same_number_exist() {
        //Given
        Operands operands = new Operands(new String[]{"3","4","5"});

        //When
        Operand input = new Operand("3");

        //Then
        assertThat(operands.contains(input)).isTrue();
    }

    @DisplayName("피연산자의 합계를 구한다")
    @Test
    void return_sum_value() {
        //Given
        Operands operands = new Operands(new String[]{"3","4","5"});

        //When + Then
        assertThat(operands.sum()).isEqualTo(12);
    }   
}
