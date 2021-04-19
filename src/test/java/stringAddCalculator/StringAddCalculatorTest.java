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
    @DisplayName("invalid param test : negative number")
    void negativeNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> stringAddCalculator.calculate("-1,2"));
    }


    @Test
    @DisplayName("invalid param test : null or empty String")
    public void nullEmptyTest() {
        int result = stringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("invalid param test : not number String")
    void stringTest1() {
        assertThatIllegalArgumentException().isThrownBy(() -> stringAddCalculator.calculate("test"));
    }

    @Test
    @DisplayName("invalid param test : contain not number String")
    void stringTest2() {
        assertThatIllegalArgumentException().isThrownBy(() -> stringAddCalculator.calculate("test,2"));
    }

    @Test
    @DisplayName("single number test")
    void singleNumbewrTest() {
        int result = stringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("number string separated by comma")
    void commaTest() {
        int result = stringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("number string separated by comma and colon")
    void commaColonTest() {
        int result = stringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("number string with custom delimiter test")
    void customDelimiterTest() {
        int result = stringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}