package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertUtilTest {

    @Test
    @DisplayName("문자열을 정수로 변환")
    public void toInt() throws Exception {
        String input = "1";
        assertThat(ConvertUtil.toInt("(은)는 정수로 변환할 수 없는 문자입니다.", input)).isEqualTo(1);
    }
}
