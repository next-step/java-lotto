package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MultiplyTest {

    private static final int ZERO = 0;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("계산 종료 후 정수값을 반환하는지 확인한다")
    void returnIntegerValueTest(int input) {

        Multiply multiply = new Multiply();

        int result = multiply.calculateWithSymbol(input, ZERO);

        assertInstanceOf(Integer.class, result);
    }

}