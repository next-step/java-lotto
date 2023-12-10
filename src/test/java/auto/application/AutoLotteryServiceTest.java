package auto.application;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLotteryServiceTest {
    private final AutoLotteryService autoLotteryService = new AutoLotteryService();

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1000, 1", "1100,1"})
    void getLotteryCountTest(int purchaseAmount, int expected) {
        // when
        int lotteryCount = autoLotteryService.getLotteryCount(purchaseAmount);
        // then
        assertThat(lotteryCount).isEqualTo(expected);
    }

    @Test
    @DisplayName("설정한 lotteryCount 만큼 로또 리스트 갯수가 만들어지고" +
                 "각 로또 번호는 1 ~ 45 사이이다.")
    void createLotteryNumbersListTest() {
        // given
        int lotteryCount = 5;
        int MIN_LOTTERY_NUMBER = 1;
        int MAX_LOTTERY_NUMBER = 45;
        // when
        List<List<Integer>> lotteryNumbersList = autoLotteryService.createLotteryNumbersList(lotteryCount);
        // then
        SoftAssertions.assertSoftly((assertions) -> {
            assertions.assertThat(lotteryNumbersList).hasSize(lotteryCount);
            assertLotteryRangeNumbers(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, lotteryNumbersList, assertions);
        });
    }

    private void assertLotteryRangeNumbers(int MIN_LOTTERY_NUMBER, int MAX_LOTTERY_NUMBER, List<List<Integer>> lotteryNumbersList, SoftAssertions assertions) {
        lotteryNumbersList.forEach((lotteryNumbers) -> {
            lotteryNumbers.forEach((lotteryNumber) -> {
                assertions.assertThat(lotteryNumber).isBetween(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER + 1);
            });
        });
    }

    @Test
    void getReturnRateTest() {
        // given
        int totalAmount = 5000;
        int amount = 10000;
        // when
        BigDecimal returnRate = AutoLotteryService.getReturnRate(totalAmount, amount);
        // then
        assertThat(returnRate).isEqualTo(new BigDecimal(0.5));
    }
}
