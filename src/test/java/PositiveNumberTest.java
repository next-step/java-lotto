import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {
    @DisplayName("값은 양의 정수를 생성자의 인자로 받아 생성된 객체는 같다.")
    @Test
    void createTest() {
        assertThat(new PositiveNumber(1)).isEqualTo(new PositiveNumber(1));
    }

    @DisplayName("음수를 인자로 받아 생성하면 런타임 예외가 발생한다.")
    @Test
    void validateNegativeTest() {
        assertThatThrownBy(() -> {
            new PositiveNumber(-1);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("PositiveNumber 객체와 int 값의 합을 int 타입으로 리턴한다.")
    @Test
    void addTest() {
        assertThat(new PositiveNumber(1).addInt(5)).isEqualTo(6);
    }
}