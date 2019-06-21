package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    @DisplayName("Splitter는 객체를 생성할 수 있다.")
    void create_Splitter() {
        Splitter splitter = new Splitter();
        assertThat(splitter).isInstanceOf(Splitter.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3",
            "1:2:3",
            "1,2:3",
            "1:2,3"
    })
    @DisplayName("기본 구분자로 결합된 숫자들을 분리한다.")
    void split_NaturalNumbers_WithDefaultSeparators(String input) {
        Splitter splitter = new Splitter();
        assertThat(splitter.split(input)).containsExactly("1", "2", "3");
    }
}
