package camp.nextstep.edu.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryApplicationTest {

    private LotteryApplication lotteryApplication;

    @BeforeEach
    void setup() {
        lotteryApplication = new LotteryApplication();
    }

    @Test
    @DisplayName("1000원 이상을 입력할 경우 입력한 값을 1000원으로 나눈 몫을 반환합니다")
    void calculateNumberOfAvailableLottery() {
        // given
        final NaturalNumber investment = NaturalNumber.from(14000);
        // when
        final NaturalNumber numberOfLotteries = lotteryApplication.calculateNumberOfAvailableLotteries(investment);
        // then
        assertThat(numberOfLotteries).isEqualTo(NaturalNumber.from(14));
    }
}