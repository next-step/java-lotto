package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @DisplayName("랜덤 숫자를 생성한다")
    @Test
    void random() {
        Number random = Number.random();
        assertThat(random.getNumber()).isGreaterThanOrEqualTo(1);
        assertThat(random.getNumber()).isLessThanOrEqualTo(45);
    }

    @DisplayName("당첨 숫자를 생성한다")
    @Test
    void win() {
        Number win = Number.win(1);
        assertThat(win.getNumber()).isEqualTo(1);
    }
}
