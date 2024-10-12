package stringcalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @DisplayName("생성자는 입력이 정수인 경우, 숫자를 생성한다.")
    @Test
    void 생성자_테스트() {
        Number expected = new Number(3);

        assertThat(expected.getNumber()).isEqualTo(3);
    }

    @DisplayName("생성자는 입력이 정수가 아닌경우, 예외를 반환한다.")
    @Test
    void 생성자_예외_테스트() {
        assertThatThrownBy(() -> new Number("a"))
                .isInstanceOf(RuntimeException.class);
    }
}
