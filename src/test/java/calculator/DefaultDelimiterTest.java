package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultDelimiterTest {

    @Test
    @DisplayName("split 결과에는 기본 구분자가 포함되어서는 안된다.")
    void defaultDelimiter() {
        // given
        String text = "1,2:3";

        // when
        String[] split = DefaultDelimiter.split(text);

        // then
        for (String s : split) {
            for (DefaultDelimiter delimiter : DefaultDelimiter.values()) {
                assertThat(s).doesNotContain(delimiter.getValue());
            }
        }
    }
}