package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    @DisplayName("isExist() 구분자의 값이 있으면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {";", "+"})
    void isExistTrueTest(String input) {
        Delimiter delimiter = Delimiter.custom(input);
        assertThat(delimiter.isExist()).isTrue();
    }

    @DisplayName("isExist() 구분자가 없으면 false를 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isExistFalseTest(String input) {
        Delimiter delimiter = Delimiter.custom(input);
        assertThat(delimiter.isExist()).isFalse();
    }

    @DisplayName("withDefaultDelimiter() 기본 구분자를 반환한다.")
    @Test
    void withDefaultDelimiterTest() {
        Delimiter basicDelimiter = Delimiter.withDefaultDelimiter();
        assertThat(basicDelimiter).isEqualTo(Delimiter.custom(":|,"));
    }

    @DisplayName("addDelimiter()는 delimiter를 합쳐서 반환한다.")
    @Test
    void addDelimiterTest() {
        Delimiter delimiter = Delimiter.custom(":|,");
        Delimiter customDelimiter = Delimiter.custom(";");

        Delimiter result = delimiter.addDelimiter(customDelimiter);

        assertThat(result).isEqualTo(Delimiter.custom(":|,|;"));
    }

}
