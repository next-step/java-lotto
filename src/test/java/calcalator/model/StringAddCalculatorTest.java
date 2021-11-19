package calcalator.model;

import calcalator.strategy.CustomDelimiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StringAddCalculatorTest {


    private Numbers numbers;

    @BeforeEach
    void setUp() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            numbers.add(new Number(i));
        }
        this.numbers = new Numbers(numbers);

    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void result() {
        StringAddCalculator calculator = new StringAddCalculator("//;\n1;2;3", new CustomDelimiter());
        Number result = calculator.result();
        assertThat(result).isEqualTo(new Number(6));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null을 입력할 경우 0 반환")
    void empty(String input) {
        StringAddCalculator calculator = new StringAddCalculator(input, new CustomDelimiter());
        Number result = calculator.result();
        assertThat(result).isEqualTo(new Number());

    }


    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "10,10", "101,101"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void singleNumber(String input, String output) {
        StringAddCalculator calculator = new StringAddCalculator(input, (string) -> string.split(","));
        assertThat(calculator.result()).isEqualTo(new Number(output));
    }


    @Test
    @DisplayName("입력값을 여러 구분자로 구분")
    void multiSplit() {
        String regex = "[,:]";
        StringAddCalculator calculator = new StringAddCalculator("1,2:3", (string) -> string.split(regex));
        assertThat(calculator.result()).isEqualTo(new Number(6));
    }


    @ParameterizedTest
    @CsvSource(value = {"2,4:6", "10,12:22", "30,2:32", "101,123:224"}, delimiter = ':')
    @DisplayName("숫자 두개를 컴마(,)로 구분자로 입력헀을 경우 두 숫자의 합을 반환")
    void plusNumbers(String input, int output) {
        StringAddCalculator calculator = new StringAddCalculator(input, (string) -> string.split(","));
        assertThat(calculator.result()).isEqualTo(new Number(output));
    }

    @Test
    @DisplayName("입력값이 음수일 때 RuntimeException 발생")
    void isNegative() {
        assertThatThrownBy(() -> {
            StringAddCalculator calculator = new StringAddCalculator("-1,-2", (string) -> string.split(","));
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("구분자 외의 입력값이 숫자가 아닐 때 RuntimeException 발생")
    void isException() {
        assertThatThrownBy(() -> {
            StringAddCalculator calculator = new StringAddCalculator("1,2", (string) -> string.split(";"));
        }).isInstanceOf(RuntimeException.class);
    }

}