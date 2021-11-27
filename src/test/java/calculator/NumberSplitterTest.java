package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSplitterTest {

    @Test
    @DisplayName("문자열 숫자 추출 2개")
    void split2() {
        String data = "1,2";
        NumberSplitter numberSplitter = new NumberSplitter();

        List<Number> numbers = numberSplitter.split(data);

        assertThat(numbers)
                .containsExactly(new Number(1), new Number(2));
    }

    @Test
    @DisplayName("문자열 숫자 추출 3개")
    void split3() {
        String data = "1,2,3";
        NumberSplitter numberSplitter = new NumberSplitter();

        List<Number> numbers = numberSplitter.split(data);

        assertThat(numbers)
                .containsExactly(new Number(1), new Number(2), new Number(3));
    }

    @Test
    @DisplayName("문자열 숫자 추출 3개, 혼합된 구분자")
    void split3Mix() {
        String data = "1,2:3";
        NumberSplitter numberSplitter = new NumberSplitter();

        List<Number> numbers = numberSplitter.split(data);

        assertThat(numbers)
                .containsExactly(new Number(1), new Number(2), new Number(3));
    }

    @Test
    @DisplayName("커스텀 구분자 추가")
    void splitAnotherSeparator() {
        String data = "1/2,3";
        NumberSplitter numberSplitter = new NumberSplitter();
        numberSplitter.addSeparator("/");

        List<Number> numbers = numberSplitter.split(data);

        assertThat(numbers)
                .containsExactly(new Number(1), new Number(2), new Number(3));
    }

    @ParameterizedTest
    @CsvSource(value = {"null", "''"},
            nullValues = {"null"})
    @DisplayName("커스텀 구분자 null, empty 제외")
    void ignoreNullEmptySeparator(String separator) {
        String data = "1,2,3";
        NumberSplitter numberSplitter = new NumberSplitter();
        numberSplitter.addSeparator(separator);

        List<Number> numbers = numberSplitter.split(data);

        assertThat(numbers)
                .containsExactly(new Number(1), new Number(2), new Number(3));
    }
}
