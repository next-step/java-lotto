package camp.nextstep.edu.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    @DisplayName("0을 입력할 경우 0개의 로또를 반환합니다")
    void purchase_zero() {
        // given
        final NaturalNumber naturalNumber = NaturalNumber.from(0);
        // when
        final List<Lottery> lottery = lotteryApplication.purchase(naturalNumber);
        // then
        assertThat(lottery).hasSize(0);
    }

    @Test
    @DisplayName("양수를 입력할 경우 해당 숫자만큼의 로또를 반환합니다")
    void purchase() {
        // given
        final NaturalNumber naturalNumber = NaturalNumber.from(14);
        // when
        final List<Lottery> lottery = lotteryApplication.purchase(naturalNumber);
        // then
        assertThat(lottery).hasSize(14);
    }

    @Test
    @DisplayName("당첨 로또가 null 이면 IllegalArgumentException 을 발생시킵니다")
    void score1() {
        // given
        final Lottery lottery = Lottery.randomizedInstance();
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryApplication.score(lottery, null))
                // then
                .withMessageContaining("must not be null");
    }

    @Test
    @DisplayName("구매한 로또가 null 이면 IllegalArgumentException 을 발생시킵니다")
    void score2() {
        // given
        final Lottery lottery = Lottery.randomizedInstance();
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryApplication.score(null, lottery))
                // then
                .withMessageContaining("must not be null");
    }
}