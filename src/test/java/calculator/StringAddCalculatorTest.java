package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("빈 문자열 입력 시 0가 나와야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void sumTest(String text) {
        int result = StringAddCalculator.sum(text);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 문자열 하나만 입력될 경우 그 숫자가 나와야 한다.")
    @Test
    public void sumOnlyOneTest() {
        int result = StringAddCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("구분자가 ,로 된 문자열이 입력될 경우 합한 숫자가 나와야 한다.")
    @Test
    public void sumCommaSeparatorTest()  {
        int result = StringAddCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자가 쉼표와 콜론이 섞였을 경우 합한 숫자가 나와야 한다.")
    @Test
    public void sumCommaAndColonSeparatorTest() {
        int result = StringAddCalculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("구분자가 Custom 구분자 일 때 합한 숫자가 나와야 한다.")
    @Test
    public void sumCustomSeparator() {
        int result = StringAddCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수가 입력되었을 경우 RunTimeException 이 발생한다.")
    @Test
    public void sumNegative() {
        assertThatThrownBy(() -> StringAddCalculator.sum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("잘못된 구분자로 입력이 되었을 때 NumberFormatException 이 발생한다.")
    @Test
    public void sumInvalidateSeparator() {
        assertThatThrownBy(() -> StringAddCalculator.sum("-1/2?3"))
                .isInstanceOf(NumberFormatException.class);
    }
}
