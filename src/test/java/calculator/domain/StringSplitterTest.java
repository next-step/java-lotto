package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @DisplayName("문자열 분리 테스트")
    @Test
    void split_test() {
        String input = "3:4:5";
        List<String> delimiter = Arrays.asList(":", "|");
        StringSplitter stringSplitter = StringSplitter.create(input, delimiter);

        assertThat(stringSplitter.split()).hasSize(3);
    }

}
