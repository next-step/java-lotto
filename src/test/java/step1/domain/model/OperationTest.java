package step1.domain.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.exception.OperationIllegalStateException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperationTest {

    @ParameterizedTest
    @ValueSource(strings = {"1a","2y","3f","4j","6k"," ",})
    public void 숫자_문자입력시_유효성테스트(String number) {
        assertThatThrownBy(() -> Operation.from(number))
                .isInstanceOf(OperationIllegalStateException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:+:2:3","4:-:2:2","4:*:2:8","4:/:2:2"}, delimiter = ':')
    public void 숫자_유효성성공테스트(String leftNumber, String operation, String rightNumber, String expected) {
        assertThat(Integer.parseInt(Operation.from(operation).calculator(leftNumber, rightNumber)))
                .isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:+:2:5","4:-:2:10","4:*:2:223","4:/:2:111"}, delimiter = ':')
    public void 숫자_유효성실패테스트(String leftNumber, String operation, String rightNumber, String expected) {
        assertThat(Integer.parseInt(Operation.from(operation).calculator(leftNumber, rightNumber)))
                .isNotEqualTo(Integer.parseInt(expected));
    }
}
