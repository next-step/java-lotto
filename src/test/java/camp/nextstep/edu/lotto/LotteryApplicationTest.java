package camp.nextstep.edu.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryApplicationTest {

    private LotteryApplication lotteryApplication;

    @BeforeEach
    void setup() {
        lotteryApplication = new LotteryApplication();
    }

    @Test
    @DisplayName("0원 미만을 입력할 경우 IllegalArgumentException 을 발생시킵니다")
    void calculateNumberOfAvailableLottery() {
        // given
        final int investment = -1;
        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryApplication.calculateNumberOfAvailableLottery(investment));
    }
}