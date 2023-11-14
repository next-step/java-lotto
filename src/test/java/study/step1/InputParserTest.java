package study.step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static study.step1.view.InputParser.parse;

public class InputParserTest {

    @ParameterizedTest
    @NullAndEmptySource
    void null_공백_입력(String string) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> parse(string))
            .withMessage("InputParserError: 입력값 오류(빈 값 혹은 공백)");
    }
}
