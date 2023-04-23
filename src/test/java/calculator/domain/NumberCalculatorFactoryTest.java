package calculator.domain;

import static calculator.domain.constant.OperatorsConstant.DIVIDE;
import static calculator.domain.constant.OperatorsConstant.MINUS;
import static calculator.domain.constant.OperatorsConstant.MULTIPLY;
import static calculator.domain.constant.OperatorsConstant.PLUS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberCalculatorFactoryTest {

    private static final NumberCalculatorFactory factory = new NumberCalculatorFactory();

    @Test
    @DisplayName("+ 연산자에 맞는 인스턴스를 반환한다.")
    void plusInstanceTest() {
        assertThat(factory.getHandlerBySymbol(PLUS.getSymbol())).isInstanceOf(AddTwoNumbers.class);
    }

    @Test
    @DisplayName("- 연산자에 맞는 인스턴스를 반환한다.")
    void minusInstanceTest() {
        assertThat(factory.getHandlerBySymbol(MINUS.getSymbol())).isInstanceOf(
                MinusTwoNumbers.class);
    }

    @Test
    @DisplayName("* 연산자에 맞는 인스턴스를 반환한다.")
    void multiplyInstanceTest() {
        assertThat(factory.getHandlerBySymbol(MULTIPLY.getSymbol())).isInstanceOf(
                MultiplyTwoNumbers.class);
    }

    @Test
    @DisplayName("/ 연산자에 맞는 인스턴스를 반환한다.")
    void divideInstanceTest() {
        assertThat(factory.getHandlerBySymbol(DIVIDE.getSymbol()))
                .isInstanceOf(DivideTwoNumbers.class);
    }
}