package study.enums;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestOperation {


    @ParameterizedTest(name = "Operation enum - 유효한 사칙연산 기호 테스트")
    @CsvSource({"+", "-", "*", "/"})
    public void test_operation_text(String operationText) {
        assertThat(Operation.findBy(operationText).getSymbol())
            .isEqualTo(operationText);
    }


    @ParameterizedTest(name = "Operation enum - 유효하지 않은 연산 기호 테스트")
    @CsvSource({"!", "?", "@", "$"})
    public void test_not_valid_operation_text(String operationText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Operation.findBy(operationText))
            .withMessageMatching("유효하지 않은 연산입니다");
    }

    
    
    @ParameterizedTest(name = "Operation enum - '+' 테스트")
    @CsvSource({"1,1,2", "2,3,5"})
    public void test_plus(int x, int y, int resultInt) {
        assertThat(Operation.PLUS.calculate(x, y))
            .isEqualTo(resultInt);
    }


    @ParameterizedTest(name = "Operation enum - '-' 테스트")
    @CsvSource({"1,1,0", "2,3,-1"})
    public void test_minus(int x, int y, int resultInt) {
        assertThat(Operation.MINUS.calculate(x, y))
            .isEqualTo(resultInt);
    }


    @ParameterizedTest(name = "Operation enum - '*' 테스트")
    @CsvSource({"1,1,1", "2,3,6"})
    public void test_multiply(int x, int y, int resultInt) {
        assertThat(Operation.MULTIPLY.calculate(x, y))
            .isEqualTo(resultInt);
    }


    @ParameterizedTest(name = "Operation enum - '/' 테스트")
    @CsvSource({"1,1,1", "2,3,0"})
    public void test_division(int x, int y, int resultInt) {
        assertThat(Operation.DIVISION.calculate(x, y))
            .isEqualTo(resultInt);
    }

}
