package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.domain.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @CsvSource(value = {
            "1,2,3",
            "2,3,5",
            "0,2,2",
            "-1,5,4",
    })
    @DisplayName("입력값을 기준으로 덧셈 연산 후 결과 값을 반환한다.")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    void test01(int a, int b, int expected) {
        Operation operation = Operation.findType(ADD);
        int actual = operation.calculate(a, b);
        assertThat(actual).isSameAs(expected);
    }

    @CsvSource(value = {
            "3,2,1",
            "5,3,2",
            "0,2,-2",
            "-1,5,-6",
    })
    @DisplayName("입력값을 기준으로 뺄셈 연산 후 결과 값을 반환한다.")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    void test02(int a, int b, int expected) {
        Operation operation = Operation.findType(SUB);
        int actual = operation.calculate(a, b);
        assertThat(actual).isSameAs(expected);
    }

    @CsvSource(value = {
            "3,2,6",
            "5,3,15",
            "0,2,0",
            "-1,5,-5",
    })
    @DisplayName("입력값을 기준으로 곱셈 연산 후 결과 값을 반환한다.")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    void test03(int a, int b, int expected) {
        Operation operation = Operation.findType(MUL);
        int actual = operation.calculate(a, b);
        assertThat(actual).isSameAs(expected);
    }

    @CsvSource(value = {
            "3,2,1",
            "6,3,2",
            "0,2,0",
            "9,2,4",
            "-1,5,0",
            "-10,2,-5",
            "15,-2,-7",
            "-30,-3,10",
    })
    @DisplayName("입력값을 기준으로 나눗셈 연산 후 결과 값을 반환한다.")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    void test04(int a, int b, int expected) {
        Operation operation = Operation.findType(DIV);
        int actual = operation.calculate(a, b);
        assertThat(actual).isSameAs(expected);
    }

}