package camp.nextstep.edu.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryApplicationTest {

    private LotteryApplication lotteryApplication;

    @BeforeEach
    void setup() {
        lotteryApplication = new LotteryApplication();
    }

    @Test
    @DisplayName("0원 미만을 입력할 경우 IllegalArgumentException 을 발생시킵니다")
    void calculateNumberOfAvailableLottery_throwsIllegalArgumentException() {
        // given
        final int investment = -1;
        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryApplication.calculateNumberOfAvailableLotteries(investment));
    }

    @Test
    @DisplayName("1000원 이상을 입력할 경우 입력한 값을 1000원으로 나눈 몫을 반환합니다")
    void calculateNumberOfAvailableLottery() {
        // given
        final int investment = 14000;
        // when
        final int numberOfLotteries = lotteryApplication.calculateNumberOfAvailableLotteries(investment);
        // then
        assertThat(numberOfLotteries).isEqualTo(14);
    }
}