package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryResultTest {
    @DisplayName("6개를 초과하는 입력은 예외를 발생한다.")
    @Test
    void moreThen_7() {
        assertThatThrownBy(() -> new LotteryResult().add(7)) //
                .isInstanceOf(OutOfMatchingBoundaryException.class);
    }

    @DisplayName("0개를 미만 입력은 예외를 발생한다.")
    @Test
    void lessThen_0() {
        assertThatThrownBy(() -> new LotteryResult().add(-1)) //
                .isInstanceOf(OutOfMatchingBoundaryException.class);
    }

    @DisplayName("3개 맞췄을 때 수익률을 계산한다.")
    @Test
    void rateOfReturn() {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.add(3);
        for (int i = 0; i < 13; i++) {
            lotteryResult.add(i % 3);
        }
        assertThat(lotteryResult.getRateOfReturn()) //
                .isEqualTo(0.35714287f);
    }

}
