package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoBallsTest {
    @Test
    void creativeWinningLottoBalls(){
        WinningLottoBalls winningLottoBalls = new WinningLottoBalls(new LottoBalls(1,3,5,7,9,12), new LottoNumber(22));
        assertThat(winningLottoBalls.getBonusBall()).isEqualTo(new LottoNumber(22));
    }
}
