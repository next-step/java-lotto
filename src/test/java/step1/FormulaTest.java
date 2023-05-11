package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class FormulaTest {

    @DisplayName("빈값 또는 널값 입력시 에러 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void 빈값널_입력(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> {
                    new Formula(input);
                }).withMessageMatching("잘못된 입력값입니다.");
    }

    /*"2 + 3 * 4 / 2"*/
    @Test
    void 큐에서_값만_출력() {
        Formula formula = new Formula("2 + 3 * 4 / 2");
        assertThat(formula.peek()).isEqualTo("2");
    }

    @Test
    void 큐에서_빼고_출력() {
        Formula formula = new Formula("1");
        assertThat(formula.poll()).isEqualTo("1");
    }
}