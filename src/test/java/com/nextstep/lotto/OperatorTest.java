package com.nextstep.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {


    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "3,4,7", "5,6,11"})
    @DisplayName("덧셈 연산자 테스트")
    void plus(int leftOperand, int rightOperand, int answer) {
        assertThat(Operator.PLUS.apply(leftOperand, rightOperand)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,2,1", "7,4,3", "11,6,5"})
    @DisplayName("뺄셈 연산자 테스트")
    void minus(int leftOperand, int rightOperand, int answer) {
        assertThat(Operator.MINUS.apply(leftOperand, rightOperand)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,2", "3,4,12", "5,6,30"})
    @DisplayName("곱셈 연산자 테스트")
    void multiply(int leftOperand, int rightOperand, int answer) {
        assertThat(Operator.MULTIPLY.apply(leftOperand, rightOperand)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,2,1", "7,2,3", "11,3,3"})
    @DisplayName("나눗셈 연산자 테스트")
    void divide(int leftOperand, int rightOperand, int answer) {
        assertThat(Operator.DIVIDE.apply(leftOperand, rightOperand)).isEqualTo(answer);
    }

    @Test
    @DisplayName("잘못된 연산자일때 IllegalArgumentException throw")
    void invalidOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.of("%"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 공백 연산자일 때 IllegalArgumentException throw")
    void nullOrEmptyOperator(String operatorSymbol) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.of(operatorSymbol));
    }
}
