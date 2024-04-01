package calculator.domain;

import static calculator.domain.Operation.findOperator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationTest {

    @Test
    @DisplayName("findOperator 메소드 테스트")
    void findOperatorTest() {
        assertThat(findOperator("+")).isEqualTo(Operation.PLUS);
    }

}