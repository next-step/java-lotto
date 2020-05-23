package calculator.domain.splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("CommaAndColonSplitter 클래스 테스트")
public class CommaAndColonSplitterTest {
    CommaAndColonSplitter commaAndColonSplitter;

    @BeforeEach
    void setUp() {
        commaAndColonSplitter = new CommaAndColonSplitter();
    }


    @DisplayName("쉼표(,) 구분자로 문자열을 분리할 수 있다.")
    @Test
    void split_comma() {
        String input = "1,2";

        String[] actual = commaAndColonSplitter.split(input);

        assertAll(
                () -> assertThat(actual).contains("1"),
                () -> assertThat(actual).hasSize(input.split(",").length)
        );
    }

    @DisplayName("콜론(:) 구분자로 문자열을 분리할 수 있다.")
    @Test
    void split_colon() {
        String input = "1:2";

        String[] actual = commaAndColonSplitter.split(input);

        assertAll(
                () -> assertThat(actual).contains("1"),
                () -> assertThat(actual).hasSize(input.split(":").length)
        );
    }

    @DisplayName("쉼표(,), 콜론(:) 구분자로 문자열을 분리할 수 있다.")
    @Test
    void split_comma_colon() {
        String input = "1:2,3";

        String[] actual = commaAndColonSplitter.split(input);

        assertAll(
                () -> assertThat(actual).contains("1"),
                () -> assertThat(actual).hasSize(input.split("[,:]").length)
        );
    }
}
