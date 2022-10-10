package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallTest {

    @Test
    @DisplayName("같은 숫자를 가진 로또볼은 같은 볼이다.")
    void is_equals_to_lotto_ball() {
        LottoBall lottoBall1 = new LottoBall(1);
        LottoBall lottoBall2 = new LottoBall(2);
        LottoBall lottoBall3 = new LottoBall(1);

        assertThat(lottoBall1.equals(lottoBall2)).isFalse();
        assertThat(lottoBall1.equals(lottoBall3)).isTrue();
    }

    @Test
    @DisplayName("정해진 범위를 넘어가는 숫자의 로또볼 생성 시 예외 발생.")
    void fail_to_init_lotto_ball_by_invalid_number() {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> new LottoBall(111));
    }
}