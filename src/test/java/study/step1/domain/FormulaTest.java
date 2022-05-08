package study.step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FormulaTest {
    @Test
    void 사용자가_입력하는_문자열에_사칙연산자_아닌_값을_입력하는_경우() {
        assertThatThrownBy(() -> Formula.from("2 ( 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_입력하는_문자열에_슷자가_아닌_값을_입력하는_경우() {
        assertThatThrownBy(() -> Formula.from("가 + 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
