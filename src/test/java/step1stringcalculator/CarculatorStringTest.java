package step1stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarculatorStringTest {

    private Calculator calculator;
    private CalculatorString mathExpression;

    @BeforeEach
    public void init() {
         calculator = new Calculator();

    }


    @ParameterizedTest()
    @NullAndEmptySource()
    public void 빈값_null_테스트(String requestMathExpression) {
        mathExpression = new CalculatorString(requestMathExpression);
        assertThatThrownBy(() -> {
            mathExpression.checkNullAndEmpty();
        }).isInstanceOf(IllegalArgumentException.class);


    }


}






