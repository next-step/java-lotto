package stringcalc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ArithmeticOperationTest {

    @Test
    void createTest() {
        assertThat(ArithmeticOperation.values()).containsExactly(ArithmeticOperation.PLUS, ArithmeticOperation.MINUS, ArithmeticOperation.MULTIPLY, ArithmeticOperation.DIVISION);

        ArithmeticOperation arithmeticOperation = ArithmeticOperation.valueOf("PLUS");

        assertThat(arithmeticOperation).isNotNull();
    }

}