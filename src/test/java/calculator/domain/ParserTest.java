package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 구분자를_기준으로_숫자를_나눈다() {
        final Parser parser = new Parser();
        assertThat(parser.splitNumberByDelimiter()).isEqualTo(
            Arrays.asList(1,2,3)
        );
    }

    @Test
    void 숫자_이외의_값이_들어가는_경우() {
        final Parser parser = new Parser();
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> parser.splitNumberByDelimiter())
            .withMessage("");
    }

    @Test
    void 음수가_들어가는_경우() {
        final Parser parser = new Parser();
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> parser.splitNumberByDelimiter())
            .withMessage("");
    }
}