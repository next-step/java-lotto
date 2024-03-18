package caculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;




public class CalculatorTest {

    @Test
    @DisplayName("입력에 따라 연산을 진행한다 - plus test")
    void plusCalculateTest() {

        Calculator calculator = new Calculator("3 + 7");

        Number resultNumber = calculator.run();
        Assertions.assertThat(resultNumber).usingRecursiveComparison().isEqualTo(new Number(10));
    }

}
