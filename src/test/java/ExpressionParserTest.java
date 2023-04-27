import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ExpressionParserTest {

    private final String whiteSpace = " ";
    private final ExpressionParser parser = new ExpressionParser(whiteSpace);

    @Nested
    class 공백_delimiter_로_주입받은_파서는 {
        @Test
        void 공백_을_2개_가진_문자열을_3개_로_쪼갠다() {
            String strWithTwoSpaces = "1 2 3";

            List<String> parts = parser.parse(strWithTwoSpaces);

            Assertions.assertThat(parts).hasSize(3);
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_공백만이_존재하는_문자열_에_대해_예외를_던진다(String emptyStr) {

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(emptyStr));
    }

    @Test
    void 정수와_사칙연산자와_공백_외의_글자가_포함된_경우_예외를_던진다() {
        String invalidExpression = "1 + 2 + a";

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(invalidExpression));
    }
}
