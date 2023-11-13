import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("덧셈 확인")
    @CsvSource(value={"1|2"},delimiter = '|')
    void add_확인(int a, int b) {
        assertThat(calculator.add(a,b)).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("뺄셈 확인")
    @CsvSource(value={"1|2"},delimiter = '|')
    void substract_확인(int a, int b) {
        assertThat(calculator.substract(a,b)).isEqualTo(-1);
    }

    @ParameterizedTest
    @DisplayName("곱셈 확인")
    @CsvSource(value={"1|2"},delimiter = '|')
    void multiply_확인(int a, int b) {
        assertThat(calculator.multiply(a,b)).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 확인")
    @CsvSource(value={"5|2"},delimiter = '|')
    void divide_확인(int a, int b) {
        assertThat(calculator.divide(a,b)).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 분모 0 확인")
    @CsvSource(value={"5|0"},delimiter = '|')
    void divide_분모0확인(int a, int b) {
        assertThatThrownBy(()-> calculator.divide(a,b))
                .isInstanceOf(ArithmeticException.class);
                //.hasMessageContaining("0 으로 나눌 수 없습니다.");
    }

    @Test
    void test(){
        String trgStr = "abc";
        assertThatThrownBy(() -> trgStr.charAt(trgStr.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.valueOf(trgStr.length()));
    }
}