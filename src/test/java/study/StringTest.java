package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 분리되는지 확인")
    void splitByComma() {
        // given & when
        String[] test = "1,2".split(",");
        // then
        assertThat(test).contains("1");
        assertThat(test).contains("1", "2");
        assertThat(test).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void singleStringSplitByComma() {
        // given & when
        String[] test = "1".split(",");
        // then
        assertThat(test).contains("1");
        assertThat(test).containsExactly("1");
    }
}
