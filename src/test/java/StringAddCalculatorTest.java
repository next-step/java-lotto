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
}
