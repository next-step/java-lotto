package study.step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step4.util.StringUtil;

public class StringUtilTest {

    @Test
    @DisplayName("문자열 분해 테스트 - 기본 분해")
    public void default_split() {
        String test = "1, 2, 3, 4, 5, 6";
        assertThat(StringUtil.split(test)).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("문자열 분해 테스트")
    public void split() {
        String test = "1:2:3:4:5:6";
        assertThat(StringUtil.split(":", test)).containsExactly("1", "2", "3", "4", "5", "6");
    }
}

