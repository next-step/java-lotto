package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SeparatedValuesTest {
    @Test
    @DisplayName("SeparatedValues 생성자 테스트")
    public void create() {
        assertThat(new SeparatedValues(Arrays.asList(1, 2))).isEqualTo(new SeparatedValues(Arrays.asList(1, 2)));
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생")
    public void isMinusValue() {
        assertThatThrownBy(() ->
                new SeparatedValues(Arrays.asList(1, -2, 3)).checkMinusValues()
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("separatedValues의 총합을 구한다")
    public void calculateSum() {
        assertThat(new SeparatedValues(Arrays.asList(1, 2, 3)).calculateSum()).isEqualTo(6);
    }
}
