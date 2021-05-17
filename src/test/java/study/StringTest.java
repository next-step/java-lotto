package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("문자열 분리 테스트")
    void split() {
        // given when
        String[] result = "1,2".split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 분리 테스트 - 단일 문자에 대한 분리")
    void split_singleString() {
        // given when
        String[] result = "1".split(",");

        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("부분 문자열")
    void substring() {
        // given
        String target = "(1,2)";

        // when
        String result = target.substring(1, target.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }
}
