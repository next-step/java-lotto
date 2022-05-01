package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SplitterTest {

    @ParameterizedTest
    @DisplayName("문자열 스플릿 테스트")
    @ValueSource(strings = {"3 + 4", "3 + 4 * 5 / 6"})
    void split(String s) {
        Splitter splitter = new Splitter();
        assertThat(splitter.split(s)).isEqualTo(s.split(" "));
    }
}
