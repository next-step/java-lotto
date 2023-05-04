package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionParserTest {

    @DisplayName("입력 값이 null일 경우")
    @Test
    void 입력값_NULL_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExpressionParser.parse(null))
                .withMessageMatching("입력 값이 null이거나 빈 공백 문자 입니다.");
    }

    @DisplayName("입력 값이 공백일 경우")
    @Test
    @EmptySource
    void 입력값_공백_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExpressionParser.parse(""))
                .withMessageMatching("입력 값이 null이거나 빈 공백 문자 입니다.");
    }

}
