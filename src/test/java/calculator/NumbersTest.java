package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumbersTest {
    @DisplayName("sum 함수는 List<Number>의 Number를 총 합한 Number를 반환한다. with default delimiter")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3/6", "2:3,4/9", "3:3/6", "4:4:2/10"}, delimiter = '/')
    void sumWithDefaultDelimiter(String text, String expected) {
        assertThat(new Numbers(text).sum()).isEqualTo(new Number(expected));
    }

    @DisplayName("sum 함수는 List<Number>의 Number를 총 합한 Number를 반환한다. with custom delimiter")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//@\n2@2@2", "//#\n1#1#2#2"})
    void sumWithCustomDelimiter(String text) throws Exception {
        assertThat(new Numbers(text).sum()).isEqualTo(new Number("6"));
    }
}
