package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultTest {
    @DisplayName("3개 맞췄을 때 수익률을 계산한다.")
    @Test
    void rateOfReturn() {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.add(Rank.FIFTH);
        for (int i = 0; i < 13; i++) {
            lotteryResult.add(Rank.MISS);
        }

        assertThat(lotteryResult.getRateOfReturn()) //
                .isEqualTo(0.35714287f);
    }

    @DisplayName("투자 없이 이익률만 계산하는 경우")
    @Test
    void zeroInput() {
        assertThat(new LotteryResult().getRateOfReturn()) //
                .isEqualTo(0);
    }

}
