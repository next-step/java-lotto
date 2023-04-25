package study;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    void split_test() {
        List<String> charList =  StringUtils.split("1 + 2");

        assertThat(charList).containsExactly("1", "+", "2");

    }
}
