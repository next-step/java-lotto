package camp.nextstep.edu.lotto.controller;

import camp.nextstep.edu.lotto.domain.Lottery;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteryControllerTest {

    private LotteryController lotteryController;

    @BeforeEach
    void setup() {
        lotteryController = new LotteryController();
    }

    @Test
    @DisplayName("0을 입력할 경우 0개의 로또를 반환합니다")
    void purchase_zero() {
        // given
        final int investment = 0;
        // when
        final List<Lottery> lottery = lotteryController.purchase(0);
        // then
        assertThat(lottery).hasSize(0);
    }

    @Test
    @DisplayName("양수를 입력할 경우 해당 숫자 / 1000 만큼의 로또를 반환합니다")
    void purchase() {
        // given
        final int investment = 14000;
        // when
        final List<Lottery> lottery = lotteryController.purchase(investment);
        // then
        assertThat(lottery).hasSize(14);
    }

    @Test
    @DisplayName("투자원금이 0원 이면 IllegalArgumentException 을 발생시킵니다")
    void calculateEarningsRate1() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryController.calculateEarningsRate(0, 5000));
    }

    @Test
    @DisplayName("수익금이 0원 미만인 경우 IllegalArgumentException 을 발생시킵니다")
    void calculateEarningsRate2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lotteryController.calculateEarningsRate(5000, -1));
    }

    @Test
    @DisplayName("수익금이 0원 이면 0을 반환합니다")
    void calculateEarningsRate3() {
        // given
        final int investment = 5000;
        final long reward = 0;
        // when
        final double actual = lotteryController.calculateEarningsRate(investment, reward);
        // then
        assertThat(actual).isCloseTo(0, Percentage.withPercentage(1));
    }

    @Test
    @DisplayName("투자원금과 수익금을 입력하면 수익금 / 투자원금의 값을 반환합니다")
    void calculateEarningsRate4() {
        // given
        final int investment = 10000;
        final long reward = 100000;
        // when
        final double actual = lotteryController.calculateEarningsRate(investment, reward);
        // then
        assertThat(actual).isCloseTo(10, Percentage.withPercentage(1));
    }
}