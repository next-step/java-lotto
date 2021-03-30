package lotto;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @DisplayName("문자열을 잘라 배열로 반환")
    @Test
    void getStringToStringArray() {
        // GIVE
        String[] array = StringUtils.getStringToStringArray("1,2,3,4,5,6");
        // WHEN
        // THAT
        assertThat(array.length).isEqualTo(6);

    }

    @DisplayName("숫자를 문자로 반환")
    @Test
    void getNumToString() {
        // GIVE
        int num = 1;
        // WHEN
        // THAN
        assertThat(StringUtils.getNumToString(num)).isEqualTo("1");
    }
}
