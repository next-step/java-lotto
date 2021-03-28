package stringAddCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void initializeTest() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("음수")
    void negativeNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> stringAddCalculator.calculate("-1,2"));
    }


    @Test
    @DisplayName("null_또는_빈문자")
    public void nullEmptyTest() {
        int result = stringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("문자 테스트")
    void stringTest1() {
        assertThatIllegalArgumentException().isThrownBy(() -> stringAddCalculator.calculate("test"));
    }

    @Test
    @DisplayName("문자 테스트")
    void stringTest2() {
        assertThatIllegalArgumentException().isThrownBy(() -> stringAddCalculator.calculate("test,2"));
    }

    @Test
    @DisplayName("숫자 1개 ")
    void singleNumbewrTest() {
        int result = stringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열 ")
    void commaTest() {
        int result = stringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표, 콜론으로 구분된 문자열 ")
    void commaColonTest() {
        int result = stringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 설정")
    void customDelimetetTest() {
        int result = stringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}