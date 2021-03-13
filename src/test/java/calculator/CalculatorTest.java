package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        Parser parser = new Parser();
        calculator = new Calculator(parser);
    }

    @Test
    @DisplayName("기본 구분자 ',' 와 ':' 로 이루어진 문자열에서 숫자를 분리한 다음, 합을 반환한다.")
    void sumListOfIntegerIfStringHasBasicDelimiters() {
        assertThat(calculator.sum("1,2:3")).isEqualTo(6);
    }

}
