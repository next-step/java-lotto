package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class FormulaTest {

    @Test
    void 빈값_입력() {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> {
                    new Formula("");
                }).withMessageMatching("잘못된 입력값입니다.");
    }

    @Test
    void 널값_입력() {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> {
                    new Formula(null);
                }).withMessageMatching("잘못된 입력값입니다.");
    }

    @Test
    void 큐에서_빼기() {
        Formula formula = new Formula("1");
        assertThat(formula.poll()).isEqualTo("1");
    }
}