package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculationFactoryTest {

    @Test
    @DisplayName("+ 기호를 이용해, Addition 객체를 가져온다.")
    void additionTest() {
        Calculation calculatorByOperator = new CalculationFactory().getCalculatorByOperator("+");
        Assertions.assertThat(calculatorByOperator).isInstanceOf(Addition.class);
    }

    @Test
    @DisplayName("- 기호를 이용해, subtraction 객체를 가져온다.")
    void subtractionTest() {
        Calculation calculatorByOperator = new CalculationFactory().getCalculatorByOperator("-");
        Assertions.assertThat(calculatorByOperator).isInstanceOf(Subtraction.class);
    }

    @Test
    @DisplayName("* 기호를 이용해, Multiplication 객체를 가져온다.")
    void multiplicationTest() {
        Calculation calculatorByOperator = new CalculationFactory().getCalculatorByOperator("*");
        Assertions.assertThat(calculatorByOperator).isInstanceOf(Multiplication.class);
    }

    @Test
    @DisplayName("/ 기호를 이용해, Division 객체를 가져온다.")
    void divisionTest() {
        Calculation calculatorByOperator = new CalculationFactory().getCalculatorByOperator("/");
        Assertions.assertThat(calculatorByOperator).isInstanceOf(Division.class);
    }

}
