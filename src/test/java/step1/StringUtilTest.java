package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 공백 문자열을 공백으로 분리한다. O
- 문자형을 정수형으로 변환. O
*/
public class StringUtilTest {

    @DisplayName("공백으로 숫자 기호를 분리한다.")
    @Test
    void divideBlankTest() {
        String str = "2 + 3 * 4 / 2";
        String[] strArr = StringUtil.splitBlank(str);

        assertThat(strArr)
                .containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @DisplayName("문자형을 정수형으로 변환한다.")
    @Test
    void toIntTest() {
        String str = "2";

        assertThat(StringUtil.toInt(str)).isEqualTo(2);
    }

}
