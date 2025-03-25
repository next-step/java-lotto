package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExpressionTest {
    @DisplayName("입력받은 식을 생성 할 수 있다.")
    @Test
    void createExpressionTest() {
        // given
        String expression = "1 + 2";

        // when
        Expression sut = new Expression(expression);

        // then
        assertThat(sut).isNotNull();
    }

    @DisplayName("입력 값이 null 혹은 blank인 경우 IllegalArgumentException을 발생시킨다.")
    @Test
    void createNullOrBlankTest() {
        // given
        String nullStr = null;
        String blankStr = "";

        // when
        // then
        assertAll(() -> assertThatIllegalArgumentException().isThrownBy(() -> new StringCalculator(nullStr))
                        .withMessage("inputStr is null"),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new StringCalculator(blankStr))
                        .withMessage("inputStr is blank"));
    }

    @DisplayName("수와 연산 기호를 분리할 수 있다.")
    @Test
    void splitTest() {
        // given
        Expression expression = new Expression("2 + 3 * 4 / 2");

        // when
        List<String> sut = expression.split();

        // then
        assertAll(() -> assertThat(sut).hasSize(7),
                () -> assertThat(sut).containsExactly("2", "+", "3", "*", "4", "/", "2"));
    }

}
