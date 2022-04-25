package calculator.constant;

import calculator.exception.InvalidSignException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationConstTest {

    @Test
    @DisplayName("'+'으로 검색하면 OperationConst.ADD 을 반환한다.")
    void findAdd() {
        assertThat(OperationConst.findBySign("+")).isEqualTo(OperationConst.ADD);
    }

    @Test
    @DisplayName("'-'으로 검색하면 OperationConst.MINUS 을 반환한다.")
    void findMinus() {
        assertThat(OperationConst.findBySign("-")).isEqualTo(OperationConst.MINUS);
    }

    @Test
    @DisplayName("'*'으로 검색하면 OperationConst.MULTIPLICATION 을 반환한다.")
    void findMultiplication() {
        assertThat(OperationConst.findBySign("*")).isEqualTo(OperationConst.MULTIPLICATION);
    }

    @Test
    @DisplayName("'/'으로 검색하면 OperationConst.DIVISION 을 반환한다.")
    void findDivision() {
        assertThat(OperationConst.findBySign("/")).isEqualTo(OperationConst.DIVISION);
    }

    @Test
    @DisplayName("입력값으로 '+', '-', '/', '*' 외의 값을 입력하면 InvalidSignException 를 반환한다.")
    void illegalArgumentException() {
        Assertions.assertThatThrownBy(() -> OperationConst.findBySign("="))
                .isInstanceOf(InvalidSignException.class);
    }
}