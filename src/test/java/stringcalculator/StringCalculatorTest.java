package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void testPlus() {
        //arrange
        String input = "1 + 4 + 7";

        //act
        int result = StringCalculator.calculate(input);

        //assert
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void testMinus() {
        //arrange
        String input = "1 - 4 - 7";

        //act
        int result = StringCalculator.calculate(input);

        //assert
        assertThat(result).isEqualTo(-10);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void testMultiple() {
        //arrange
        String input = "1 * 4 * 7";

        //act
        int result = StringCalculator.calculate(input);

        //assert
        assertThat(result).isEqualTo(28);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void testDivide() {
        //arrange
        String input = "20 / 2 / 2";

        //act
        int result = StringCalculator.calculate(input);

        //assert
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈값 테스트")
    void testNullAndEmpty(String input) {
        //assert
        assertThatThrownBy(()->StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("이상한 기호 테스트")
    void test_이상한기호() {
        //arrange
        String input = "20 ^ 2 & 2";

        //assert
        assertThatThrownBy(()->StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호를 입력해주세요.");
    }
}
