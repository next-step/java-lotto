package step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SafeNumberTest {

    @Test
    void 숫자만들기() {
        SafeNumber safeNumber = new SafeNumber("1");
        assertThat(safeNumber).isEqualTo(new SafeNumber("1"));
    }

    @Test
    void 음수일경우_RuntimeException() {
        assertThatThrownBy(() -> new SafeNumber("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("-1 : 음수는 허용되지 않습니다.");
    }

    @Test
    void 숫자가_아닌_문자_입력시() {
        assertThatThrownBy(() -> new SafeNumber("일"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("일 는 숫자가 아닙니다.");
    }
}
