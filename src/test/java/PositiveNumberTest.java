import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveNumberTest {
    @DisplayName("값은 양의 정수를 생성자의 인자로 받아 생성된 객체는 같다.")
    @Test
    void createTest() {
        assertThat(new PositiveNumber(1)).isEqualTo(new PositiveNumber(1));
    }
}
