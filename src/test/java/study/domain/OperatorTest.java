package study.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    Operator operator;

    @BeforeEach
    void setup() {
        operator = Operator.PLUS;
    }

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        // When & Then
        assertEquals(3, operator.calculate(1, 2));
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractTest() {
        // When & Then
        assertEquals(1, Operator.MINUS.calculate(2, 1));
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplyTest() {
        // When & Then
        assertEquals(6, Operator.MULTIPLY.calculate(2, 3));
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideTest() {
        // When & Then
        assertEquals(2, Operator.DIVIDE.calculate(4, 2));
    }

    @Test
    @DisplayName("나눗셈 예외 테스트")
    void divideExceptionTest() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> Operator.DIVIDE.calculate(4, 0));
    }

    @Test
    @DisplayName("사칙연산 기호 테스트")
    void getSymbolTest() {
        // When & Then
        assertAll(
                () -> assertEquals(Operator.PLUS, operator.getSymbol("+")),
                () -> assertEquals(Operator.MINUS, operator.getSymbol("-")),
                () -> assertEquals(Operator.MULTIPLY, operator.getSymbol("*")),
                () -> assertEquals(Operator.DIVIDE, operator.getSymbol("/"))
        );
    }

    @Test
    @DisplayName("사칙연산 기호 예외 테스트")
    void getSymbolExceptionTest() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> operator.getSymbol("%"));
    }
}