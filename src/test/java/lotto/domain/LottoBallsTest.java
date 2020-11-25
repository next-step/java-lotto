package lotto.domain;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBallsTest {

    @Test
    void testCreateLottoBalls(){
        LottoBalls lottoBalls = new LottoBalls(1,2,3,4,5,6);
        assertThat(lottoBalls.containsCount(lottoBalls)).isEqualTo(LottoBalls.LOTTO_BALL_VALID_COUNT);
    }

    @Test
    void testInvalidLottoBallCount(){
        assertThatThrownBy(() -> new LottoBalls(1)).isInstanceOf(RuntimeException.class)
        .hasMessage(String.format(ErrorMessage.INVALID_BALL_COUNT, LottoBalls.LOTTO_BALL_VALID_COUNT));

        assertThatThrownBy(() -> new LottoBalls(1,2,3,4,5,6,7)).isInstanceOf(RuntimeException.class)
                .hasMessage(String.format(ErrorMessage.INVALID_BALL_COUNT, LottoBalls.LOTTO_BALL_VALID_COUNT));
    }

    @Test
    void testLottoBallsString(){
        LottoBalls lottoBalls = new LottoBalls(4,31,8,3,2,18);
        assertThat(lottoBalls.toString()).isEqualTo("2, 3, 4, 8, 18, 31");
    }

}
