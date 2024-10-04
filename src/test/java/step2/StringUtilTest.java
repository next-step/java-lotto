package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.util.StringUtil;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 콤마를 기준으로 문자열을 분리한다.
*/
public class StringUtilTest {

    @DisplayName("콤마를 기준으로 문자열을 분리한다.")
    @Test
    void deviceCommaTest() {
        String str = "1,2,3,4,5,6";
        assertThat(StringUtil.divideNum(str))
                .containsExactly("1", "2", "3", "4", "5", "6");
    }
}
