package calculator.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {

    @DisplayName("null 또는 빈문자열이 들어오면 ','과 ';'을 구분자로 사용한다")
    @ParameterizedTest
    @NullAndEmptySource
    void isDefaultDelimiter(String value) {
        // when
        Delimiter delimiter = Delimiter.from(value);

        // then
        assertThat(Delimiter.isDefaultDelimiter(delimiter)).isTrue();
    }

    @DisplayName("주어진 문자열을 구분자로 쪼갤 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {",", ":", "'", "/", "&", "*", "|"})
    void split(String symbol) {
        // given
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        String value = list.stream().collect(Collectors.joining(symbol));
        Delimiter delimiter = Delimiter.from(symbol);

        // when
        String[] tokens = delimiter.split(value);

        // then
        Assertions.assertAll(
                () -> assertThat(tokens).containsAll(list),
                () -> assertThat(tokens.length).isEqualTo(list.size())
        );
    }
}
