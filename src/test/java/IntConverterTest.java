import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntConverterTest {

    @DisplayName("숫자로 된 문자열을 정수형 타입으로 변환한다.")
    @Test
    public void shouldConvertStringToInt() {
        // given
        String intValue = "1";
        int expectedResult = 1;
        IntConverter intConverter = new IntConverter();

        // when
        int result = intConverter.convertStringToInt(intValue);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("숫자로 된 문자열이 정수형인지 판별한다.")
    @Test
    public void shouldStringToInt() {
        // given
        String intValue = "1";
        IntConverter intConverter = new IntConverter();

        // when
        boolean result = intConverter.isConvertibleToInt(intValue);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("숫자로 된 문자열이 정수형인지 판별한다.")
    @Test
    public void shouldStringToInt2() {
        // given
        String intValue = "일";
        IntConverter intConverter = new IntConverter();

        // when
        boolean result = intConverter.isConvertibleToInt(intValue);

        // then
        assertThat(result).isFalse();
    }
}
