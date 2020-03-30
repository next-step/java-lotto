import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("입력된 문자열을 콤마를 기준으로 구분하여 나누어진 문자열 배열로 리턴한다")
    public void splitByCommaReturnsArrayOfStrings() {
        String[] result = StringAddCalculator.split("1,2");

        assertThat(result).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    @DisplayName("입력된 문자열을 콜론을 기준으로 구분하여 나누어진 문자열 배열로 리턴한다")
    public void splitByColonReturnsArrayOfStrings() {
        String[] result = StringAddCalculator.split("1:2");

        assertThat(result).isEqualTo(new String[]{"1", "2"});
    }

    @Test
    @DisplayName("입력된 문자열 배열에 있는 숫자들의 합을 구한다")
    public void sumReturnsSumOfNumbers() {
        int result = StringAddCalculator.sum(new String[]{"1", "2"});

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마 또는 콜론 구분자를 기준으로 분리한 각 숫자의 합을 리턴한다")
    public void sumAndSplitReturnsSumOfNumbersInString() {
        int result = StringAddCalculator.sumAndSplit("1,2:3");

        assertThat(result).isEqualTo(6);
    }
}
