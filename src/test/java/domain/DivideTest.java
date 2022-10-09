package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DivideTest {

    private static final int ZERO = 0;
    private Divide divide;

    @BeforeEach
    void setUp() {
        divide = new Divide();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("0으로 나눌시 0을 반환하는지 확인한다")
    void zeroDivisionTest(int input) {

        int result = divide.calculateWithSymbol(input, ZERO);

        assertThat(result).isEqualTo(ZERO);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("계산 종료 후 정수값을 반환하는지 확인한다")
    void returnIntegerValueTest(int input) {

        int result = divide.calculateWithSymbol(input, ZERO);

        assertInstanceOf(Integer.class, result);
    }
}