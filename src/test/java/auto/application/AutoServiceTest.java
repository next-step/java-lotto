package auto.application;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class AutoServiceTest {
    private final AutoService autoService = new AutoService();
    @Test
    @DisplayName("설정한 lotteryCount 만큼 로또 리스트 갯수가 만들어지고" +
                 "각 로또 번호는 1 ~ 45 사이이다.")
    void createLotteryNumbersListTest() {
        // given
        int lotteryCount = 5;
        int MIN_LOTTERY_NUMBER = 1;
        int MAX_LOTTERY_NUMBER = 45;
        // when
        List<List<Integer>> lotteryNumbersList = autoService.createLotteryNumbersList(lotteryCount);
        // then
        SoftAssertions.assertSoftly((assertions) -> {
            assertions.assertThat(lotteryNumbersList).hasSize(lotteryCount);
            lotteryNumbersList.forEach((lotteryNumbers) -> {
                lotteryNumbers.forEach((lotteryNumber) -> {
                    assertions.assertThat(lotteryNumber).isBetween(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER + 1);
                });
            });
        });
    }

    @Test
    void getReturnRateTest() {
        // given
        int totalAmount = 5000;
        int amount = 10000;
        // when
        BigDecimal returnRate = AutoService.getReturnRate(totalAmount, amount);
        // then
        Assertions.assertThat(returnRate).isEqualTo(new BigDecimal(0.5));
    }
}
