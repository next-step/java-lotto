package calculator.constant;

import calculator.exception.InvalidSignException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationsTest {

    @Test
    @DisplayName("'+'으로 검색하면 OperationConst.ADD 을 반환한다.")
    void findAdd() {
        assertThat(Operations.findBySign("+")).isEqualTo(Operations.ADD);
    }

    @Test
    @DisplayName("'-'으로 검색하면 OperationConst.MINUS 을 반환한다.")
    void findMinus() {
        assertThat(Operations.findBySign("-")).isEqualTo(Operations.MINUS);
    }

    @Test
    @DisplayName("'*'으로 검색하면 OperationConst.MULTIPLICATION 을 반환한다.")
    void findMultiplication() {
        assertThat(Operations.findBySign("*")).isEqualTo(Operations.MULTIPLICATION);
    }

    @Test
    @DisplayName("'/'으로 검색하면 OperationConst.DIVISION 을 반환한다.")
    void findDivision() {
        assertThat(Operations.findBySign("/")).isEqualTo(Operations.DIVISION);
    }

    @Test
    @DisplayName("입력값으로 '+', '-', '/', '*' 외의 값을 입력하면 InvalidSignException 를 반환한다.")
    void illegalArgumentException() {
        Assertions.assertThatThrownBy(() -> Operations.findBySign("="))
                .isInstanceOf(InvalidSignException.class);
    }
}