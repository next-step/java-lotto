package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoBalls;
import org.junit.jupiter.api.Test;

class LottoBallsTest {

    @Test
    void Lotto_Ball_은_1부터_45_까지이다() {

        // when
        final List<String> balls = LottoBalls.get();

        // then
        for (int i = 1; i <= 45; i++) {
            assertThat(balls.get(i - 1)).isEqualTo(String.valueOf(i));
        }
    }
}
