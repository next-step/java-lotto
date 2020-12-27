package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SplitStringDelimiterTest {

    private SplitStringDelimiter splitStringDelimiter;

    @BeforeEach
    void setUp() {
        splitStringDelimiter = new SplitStringDelimiter();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3=1,2,3", "4,5:6=4,5,6"}, delimiter = '=')
    @DisplayName("디폴트 구분자 테스트")
    void splitString(String input, String result) {
        assertThat(splitStringDelimiter.splitString(input)).isEqualTo(result.split(","));
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void customSplitString() {
        String input = "//;\n1;2;3";
        String result = "1,2,3";
        assertThat(splitStringDelimiter.splitString(input)).isEqualTo(result.split(","));
    }
}
