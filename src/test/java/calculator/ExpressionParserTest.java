package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionParserTest {

    @DisplayName("입력 값이 공백일 경우")
    @ParameterizedTest
    @NullAndEmptySource
    void 입력값_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExpressionParser.parse(input))
                .withMessageMatching("입력 값이 null이거나 빈 공백 문자 입니다.");
    }

}
