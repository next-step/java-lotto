package lotto.domain;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoBallsTest {
    @Test
    void creativeWinningLottoBalls(){
        WinningLottoBalls winningLottoBalls = new WinningLottoBalls(new LottoBalls(1,3,5,7,9,12), new LottoNumber(22));
        assertThat(winningLottoBalls.getBonusBall()).isEqualTo(new LottoNumber(22));
    }

    @Test
    void testValidateWinningLottoBall(){
        assertThatThrownBy(() -> new WinningLottoBalls(null, null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_BALL);

        assertThatThrownBy(() -> new WinningLottoBalls(new LottoBalls(1,2,3,4,5,6), null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_BALL);

        assertThatThrownBy(() -> new WinningLottoBalls(new LottoBalls(1,2,3,4,5,6), new LottoNumber(1)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_BALL);
    }
}
