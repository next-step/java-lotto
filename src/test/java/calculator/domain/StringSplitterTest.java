package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @DisplayName("문자열 분리 테스트")
    @Test
    void split_test() {
        String input = "3:4:5";
        String delimiter = ",|:";

        assertThat(StringSplitter.split(input, delimiter)).hasSize(3);
    }

}
