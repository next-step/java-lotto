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

    @DisplayName("5000원 구매시 등수별 정상 카운트 확인(통계데이터 생성)")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,43,44,45:42:5000:3:false:5", "1,2,3,4,44,45:43:5000:4:false:5", "1,2,3,4,5,45:44:5000:5:false:5",
            "1,2,3,4,5,45:6:5000:5:true:5", "1,2,3,4,5,6:7:5000:6:false:5"}, delimiter = ':')
    void makeStatisticsResult(String purchaseNumber, int bonusNum, int amount, int matchCount, boolean matchBonus, int rankCount) {
        // given
        Lottos lottos = Lottos.of(new TestLottoNumberGenerator(), Money.from(amount));
        Set<Integer> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(",")))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());

        Lotto prizeLotto = Lotto.from(numbers);
        LottoStatistics lottoStatistics = LottoStatistics.from(amount);
        Number bonusNumber = Number.from(bonusNum);

        // when
        lottoStatistics.makeStatisticsResult(lottos, bonusNumber, prizeLotto);
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoStatistics.getLottoPrizeResult().get(rank)).isEqualTo(rankCount);
    }

    @DisplayName("1000원 구매시 당첨등수별 수익률 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,43,44,45:42:1000:5.00", "1,2,3,4,44,45:43:1000:50.00", "1,2,3,4,5,45:44:1000:1500.00",
            "1,2,3,4,5,45:6:1000:30000.00", "1,2,3,4,5,6:7:1000:2000000.00"}, delimiter = ':')
    void getRevenueRate(String purchaseNumber, int bonusNum, int amount, String expectedRevenueRate) {
        // given
        Lottos lottos = Lottos.of(new TestLottoNumberGenerator(), Money.from(amount));
        Set<Integer> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(",")))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());

        Lotto prizeLotto = Lotto.from(numbers);
        LottoStatistics lottoStatistics = LottoStatistics.from(amount);
        Number bonusNumber = Number.from(bonusNum);

        // when
        lottoStatistics.makeStatisticsResult(lottos, bonusNumber, prizeLotto);
        BigDecimal revenueRate = lottoStatistics.getRevenueRate();

        // then
        assertThat(revenueRate).isEqualTo(new BigDecimal(expectedRevenueRate));
    }
}
