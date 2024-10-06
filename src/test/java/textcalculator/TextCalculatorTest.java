package textcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TextCalculatorTest {

    @DisplayName("+ - * / 연산만 가능하다")
    @Test
    void validateOperator(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TextCalculator("10 % 5 ^ 2"))
                .withMessage("+ - * / 연산자만 가능하며 숫자와 연산자 사이엔 공백이 존재해야 합니다");
    }

    @DisplayName("연산자와 숫자 사이에는 하나의 공백만 있어야 한다")
    @Test
    void validateBlank(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TextCalculator("10    +   5 - 2"))
                .withMessage("+ - * / 연산자만 가능하며 숫자와 연산자 사이엔 공백이 존재해야 합니다");
    }

}

