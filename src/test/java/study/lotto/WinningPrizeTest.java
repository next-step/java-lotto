package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningPrizeTest {
    @DisplayName("일치 개수에 따른 당첨금액 확인")
    @Test
    public void winningPrizeTest(){
        WinningPrize winningPrize = new WinningPrize();
        BigDecimal forthWinning = winningPrize.prize(6);
        assertThat(forthWinning).isEqualTo(BigDecimal.valueOf(2000000000));
    }
}
