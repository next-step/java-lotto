package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @Test
    @DisplayName("공백을 기준으로 문자열 자르기")
    void split() {
        assertThat(Splitter.split("1 + 1")).hasSize(3);
    }
}