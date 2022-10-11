package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExpressionParserTest {

    @Test
    @DisplayName("입력된 식의 파싱 성공")
    void parsingExpressionSuccess() {
        String expression = "5 + 3 - 2";
        String[] parsedExpression = new String[5];
        parsedExpression[0] = "5";
        parsedExpression[1] = "+";
        parsedExpression[2] = "3";
        parsedExpression[3] = "-";
        parsedExpression[4] = "2";

        assertThat(new ExpressionParser(expression))
                .isEqualTo(parsedExpression);
    }

    @Test
    @DisplayName("빈 값을 입력해 실패")
    void parsingExpressionFailByEmptyValue() {
        String expression = "";
        assertThatNullPointerException()
                .isThrownBy(() -> new ExpressionParser(expression));
    }

    @Test
    @DisplayName("null값을 입력해 실패")
    void parsingExpressionFailByNullValue() {
        assertThatNullPointerException()
                .isThrownBy(() -> new ExpressionParser(null));
    }

    @Test
    @DisplayName("숫자와 사칙연산 기호 외 다른 문자 입력으로 실패")
    void parsingExpressionFailByNotAllowableCharacter() {
        String expression = "5 + 3 ! 2";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ExpressionParser(expression));
    }

}
