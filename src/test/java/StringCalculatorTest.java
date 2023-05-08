import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = null;

    @BeforeEach
    public void StringCalculator(){
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("입력 받은 문자열에 공백이 있는지 테스트")
    public void StringInputTest(){
        assertThat(stringCalculator.isFirstNumber("2 + 3 * 4 / 2")).isEqualTo("2 + 3 * 4 / 2");
        assertThat(stringCalculator.isFirstNumber("2")).isEqualTo("2");
        assertThat(stringCalculator.isFirstNumber("-3")).isEqualTo("-3");
        assertThat(stringCalculator.isFirstNumber("+")).isEqualTo("0");
        assertThat(stringCalculator.isFirstNumber("2 +")).isEqualTo("2 +");
        assertThat(stringCalculator.isFirstNumber("2 3")).isEqualTo("2 3");
        assertThat(stringCalculator.isFirstNumber("+ -")).isEqualTo("+ -");
    }

    @Test
    @DisplayName("문자열에 2번째가 숫자로 시작하는지 테스트 / 2번째가 기호인지 확인")
    public void StringInputTest3(){
        assertThat(stringCalculator.isSecondCharacterNumber("2 + 3 * 4 / 2")).isEqualTo("2 + 3 * 4 / 2");
        assertThat(stringCalculator.isSecondCharacterNumber("2 3 + /")).isEqualTo("0");
        assertThat(stringCalculator.isSecondCharacterNumber("2 3 +")).isEqualTo("0");
        assertThat(stringCalculator.isSecondCharacterNumber("4 7")).isEqualTo("0");
    }

    @Test
    @DisplayName("[1차 리뷰 후 추가] 입력값이 null이거나 빈 공백인지 확인")
    public void testInputisNullOrBlank(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.isNullOrBlank("");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.isNullOrBlank(null);
        });
    }

    @Test
    @DisplayName("[1차 리뷰 후 추가] 사친연산 기호가 맞는지 확인")
    public void testStringisArthimetic(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.validateSymbol('3');
            stringCalculator.validateSymbol('(');
        });
    }

    @Test
    @DisplayName("문자열을 (숫+기+숫) 1set 테스트")
    public void oneSetTest(){
        assertThat(stringCalculator.calculateOneSet("2 + 3", 0, 0)).isEqualTo(5);
        assertThat(stringCalculator.calculateOneSet("10 / 5", 0, 0)).isEqualTo(2);
        assertThat(stringCalculator.calculateOneSet("2 + -", 0, 0)).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열 계산기 최종 테스트")
    public void doFinalTest(){
        assertThat(stringCalculator.doStringCalculator("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
