package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumberTest {

    @DisplayName("음수가 들어갔을 때 예외가 발생하는지 여부")
    @Test
    void minusTest() {
        Number number = new Number("1");
        assertThatThrownBy(() -> number.minusCheck("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("Number 객체 두 개가 같은지 테스트")
    void numberClassTest() {
        Number number1 = new Number("1");
        assertThat(number1.equals(new Number("1"))).isEqualTo(true);
    }


}
