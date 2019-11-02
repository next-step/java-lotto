package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("입력받은 숫자 리스트를 더한 뒤 합을 반환한다.")
    void calculate() {
        //given
        List<Integer> integers = Arrays.asList(1, 2, 3);

        //when
        int result = Calculator.calculate(integers);

        //then
        assertThat(result).isEqualTo(6);
    }
}
