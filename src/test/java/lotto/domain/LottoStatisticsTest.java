package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import lotto.generator.TestLottoNumberGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @DisplayName("1000원 구매시 당첨등수별 수익률 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,43,44,45:1000:5.00", "1,2,3,4,44,45:1000:50.00", "1,2,3,4,5,45:1000:1500.00",
            "1,2,3,4,5,6:1000:2000000.00"}, delimiter = ':')
    void getRevenueRate(String purchaseNumber, int amount, String expectedRevenueRate) {
        // given
        Lottos lottos = Lottos.of(new TestLottoNumberGenerator(), Money.from(amount));
        Set<Number> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(",")))
                .stream()
                .map(i -> Number.from(Integer.valueOf(i)))
                .collect(Collectors.toSet());

        Lotto prizeLotto = Lotto.from(numbers);
        LottoStatistics lottoStatistics = LottoStatistics.from(amount);

        // when
        BigDecimal revenueRate = lottoStatistics.getRevenueRate(lottos, prizeLotto);

        // then
        assertThat(revenueRate).isEqualTo(new BigDecimal(expectedRevenueRate));
    }
}