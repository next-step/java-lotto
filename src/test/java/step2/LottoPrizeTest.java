package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @Test
    @DisplayName("로또 상금 테스트")
    void lotto_prize_test(){
        LottoPrize lottoPrize = LottoPrize.getPrizeInfo(1);
        assertThat(lottoPrize).isEqualTo(LottoPrize.FIRST);
    }
}
