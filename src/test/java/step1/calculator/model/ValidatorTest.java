package step1.calculator.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.calculator.model.Validator;

public class ValidatorTest {

    @Test
    @DisplayName("Validator 테스트 #4 - 잘못된 연산자")
    void run4() {
        // given
        String input = "1 ? 2 > 3 < 4 * 5";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Validator().validate(input));
    }

    @Test
    @DisplayName("Validator 테스트 #5 - 빈 문자열")
    void run5() {
        // given
        String input = "";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Validator().validate(input));
    }

    @Test
    @DisplayName("Validator 테스트 #6 - 공백 문자열")
    void run6() {
        // given
        String input = "    ";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Validator().validate(input));
    }

    @Test
    @DisplayName("Validator 테스트 #7 - 연산자로 끝나는 유효하지 않은 문자열")
    void run7() {
        // given
        String input = "1 + 2 +";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Validator().validate(input));
    }

    @Test
    @DisplayName("Validator 테스트 #8 - 연산자로 시작하는 유효하지 않은 문자열")
    void run8() {
        // given
        String input = "+ 1 + 2";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Validator().validate(input));
    }

    @Test
    @DisplayName("Validator 테스트 #9 - 연산자로 시작하고 연산자로 끝나는 유효하지 않은 문자열")
    void run9() {
        // given
        String input = "+ 1 + 2 +";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Validator().validate(input));
    }

}
