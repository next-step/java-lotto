package textcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("곱셈, 나눗셈 우선순위랑 상관없이 순서대로 실행된다")
    @Test
    void calculateInOrder(){
        TextCalculator calculator = new TextCalculator("2 + 3 * 4 / 2");

        int result = calculator.calculate();

        assertThat(result).isEqualTo(10);
    }


    @DisplayName("사칙연산을 모두 포함한 계산이 가능하다")
    @Test
    void calculate(){
        TextCalculator calculator = new TextCalculator("2 + 3 - 1 * 4 / 2");

        int result = calculator.calculate();

        assertThat(result).isEqualTo(8);
    }

}

