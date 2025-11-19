package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorFactoryTest {


    @Test
    void 덧셈() {
        CalculatorFactory calculator = new CalculatorFactory();

        assertThat(
                calculator.handleWayByOperator(
                        "+",
                        1,
                        2
                )
        ).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        CalculatorFactory calculator = new CalculatorFactory();

        assertThat(
                calculator.handleWayByOperator(
                        "-",
                        2,
                        1
                )
        ).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        CalculatorFactory calculator = new CalculatorFactory();

        assertThat(
                calculator.handleWayByOperator(
                        "*",
                        2,
                        2
                )
        ).isEqualTo(4);
    }

    @Test
    void 나눗셈_나머지가_있는경우도_몫만_반환할_수_있다() {
        CalculatorFactory calculator = new CalculatorFactory();

        assertThat(
                calculator.handleWayByOperator(
                        "/",
                        5,
                        2
                )
        ).isEqualTo(2);
    }

    @Test
    void 나눗셈_나머지가_없는경우도_몫만_반환할_수_있다() {
        CalculatorFactory calculator = new CalculatorFactory();

        assertThat(
                calculator.handleWayByOperator(
                        "/",
                        4,
                        2
                )
        ).isEqualTo(2);
    }
}