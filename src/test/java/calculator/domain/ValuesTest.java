package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValuesTest {

    @DisplayName("값 문자열을 입력하면 기본 구분자에 따라서 split 된다")
    @ParameterizedTest
    @CsvSource(value = {"1!1", "1,2!2", "1,2:3!3"}, delimiter = '!')
    void test(String input, int expectedSize) {
        // given
        Values values = Values.init(input);

        // when
        int valuesSize = values.getValues().size();

        // then
        assertThat(valuesSize).isEqualTo(expectedSize);
    }
}
