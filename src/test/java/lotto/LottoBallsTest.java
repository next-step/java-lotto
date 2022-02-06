package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallsTest {

    @DisplayName("로또 번호는 1부터 45까지의 범위이다.")
    @Test
    void When_로또_공_생성_Then_범위는_1부터_45() {

        // when
        final List<String> balls = LottoBalls.get();

        // then
        for (int i = 1; i <= 45; i++) {
            assertThat(balls.get(i - 1)).isEqualTo(String.valueOf(i));
        }
    }
}
