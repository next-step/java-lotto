package auto.application;

import auto.domain.Lotto;
import auto.domain.Lottos;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoServiceTest {
    private final AutoLottoService autoLottoService = new AutoLottoService();

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1000, 1", "1100,1"})
    void getLottoCountTest(int purchaseAmount, int expected) {
        // when
        int lotteryCount = autoLottoService.getLottoCount(purchaseAmount);
        // then
        assertThat(lotteryCount).isEqualTo(expected);
    }

    @Test
    @DisplayName("설정한 lotteryCount 만큼 로또 리스트 갯수가 만들어지고" +
                 "각 로또 번호는 1 ~ 45 사이이다.")
    void createLottoNumbersListTest() {
        // given
        int lotteryCount = 5;
        int MIN_LOTTERY_NUMBER = 1;
        int MAX_LOTTERY_NUMBER = 45;
        // when
        Lottos lotteryNumbersList = Lottos.createLottoNumbersList(lotteryCount);
        // then
        SoftAssertions.assertSoftly((assertions) -> {
            assertions.assertThat(lotteryNumbersList.getLottoList()).hasSize(lotteryCount);
            assertLottoRangeNumbers(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, lotteryNumbersList.getLottoList(), assertions);
        });
    }

    private void assertLottoRangeNumbers(int MIN_LOTTERY_NUMBER, int MAX_LOTTERY_NUMBER, List<Lotto> lotteryNumbersList, SoftAssertions assertions) {
        lotteryNumbersList.forEach((lotteryNumbers) -> {
            lotteryNumbers.getNumbers()
                          .forEach((lotteryNumber) -> {
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
        BigDecimal returnRate = AutoLottoService.getReturnRate(totalAmount, amount);
        // then
        assertThat(returnRate).isEqualTo(new BigDecimal(0.5));
    }
}
