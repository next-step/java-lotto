package lotto;

import lotto.model.LotteryNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryNumberTest {
    @Test
    void outOf1to45ShouldThrowError() {
        assertThatThrownBy(() -> new LotteryNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LotteryNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldCreateLotteryNumber() {
        assertThat(new LotteryNumber(1)).isInstanceOf(LotteryNumber.class);
    }
}
