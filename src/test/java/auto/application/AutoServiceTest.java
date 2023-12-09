package auto.application;

import auto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class AutoServiceTest {
    private final AutoService autoService = new AutoService();

    @Test
    @DisplayName("설정한 lottoCount 만큼 로또 리스트 갯수가 만들어지고" +
                 "각 로또 번호는 1 ~ 45 사이이다.")
    void createLottoNumbersListTest() {
        // given
        int lottoCount = 5;
        int MIN_LOTTO_NUMBER = 1;
        int MAX_LOTTO_NUMBER = 45;
        // when
        List<Lotto> lottoNumbersList = autoService.createLottoNumbersList(lottoCount);
        // then
        SoftAssertions.assertSoftly((assertions) -> {
            assertions.assertThat(lottoNumbersList).hasSize(lottoCount);
            lottoNumbersList.forEach((lottoNumbers) -> {
                lottoNumbers.getNumbers()
                            .forEach((lottoNumber) -> {
                                assertions.assertThat(lottoNumber).isBetween(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1);
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
