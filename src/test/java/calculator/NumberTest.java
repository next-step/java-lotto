package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void Number_생성() {
        int num = new Number("1").intValue();
        assertThat(num).isEqualTo(1);
    }

    @Test
    void 숫자가_아닌경우_예외처리() {
        assertThatThrownBy(() -> {
            new Number("/");
        }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자가 아닙니다.");
    }
}
