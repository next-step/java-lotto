package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    void 문자열로_숫자_생성() {
        // given
        String number = "1";
        // when
        Number num = new Number(number);
        // then
        assertThat(num).isEqualTo(new Number(1));
    }
    
    @Test
    void 숫자로_숫자_생성() {
        // given
        int number = 1;
        // when
        Number num = new Number(number);
        // then
        assertThat(num).isEqualTo(new Number("1"));
    }
    
    @Test
    void 숫자가_공백() {
        // given
        String number = "";
        // when

        // then
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_NULL() {
        // given
        String number = null;
        // when

        // then
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
