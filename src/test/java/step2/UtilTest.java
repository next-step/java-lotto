package step2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.Conversion;

class UtilTest {

    @DisplayName("숫자 포맷이 아닌 경우 예외를 던진다.")
    @Test
    void test1() throws Exception {
        String str = "1,3,5,f,8";

        assertThatThrownBy(() ->
            Conversion.stringToInt(str)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
