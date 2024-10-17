package calculator.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {

    @Test
    void 숫자가_아닌경우() {
        String str = "aa";
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(str));
    }

    @Test
    void 숫자() {
        String str = "1";
        Number number = new Number(str);
        assertThat(number.getNumber()).isEqualTo(1);
    }

}
