package lotto.domain;

import lotto.factory.LottoFactory;
import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    private int amount;
    private Lottos lottos;
    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        this.amount = 1000;
        List<Lotto> manualLottos = Collections.emptyList();
        List<Lotto> autoLottos = LottoFactory.buyAutoLottos(new TestLottoNumberGenerator(), Money.from(this.amount));
        this.lottos = Lottos.of(manualLottos, autoLottos);
        this.lottoStatistics = LottoStatistics.from(amount);
    }

    @DisplayName("등수별 정상 카운트 확인(통계데이터 생성)")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,43,44,45:42:3:false:1", "1,2,3,4,44,45:43:4:false:1", "1,2,3,4,5,45:44:5:false:1",
            "1,2,3,4,5,45:6:5:true:1", "1,2,3,4,5,6:7:6:false:1"}, delimiter = ':')
    void makeStatisticsResult(String purchaseNumber, int bonusNum, int matchCount, boolean matchBonus, int rankCount) {
        // given
        Set<Integer> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(","))).stream()
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());

        Lotto prizeLotto = Lotto.from(numbers);
        Number bonusNumber = Number.from(bonusNum);
        WinningLotto winningLotto = WinningLotto.of(prizeLotto, bonusNumber);

        // when
        lottoStatistics.makeStatisticsResult(lottos, winningLotto);
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        assertThat(lottoStatistics.getLottoPrizeResult().get(rank)).isEqualTo(rankCount);
    }

    @DisplayName("당첨등수별 수익률 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,43,44,45:42:5.00", "1,2,3,4,44,45:43:50.00", "1,2,3,4,5,45:44:1500.00",
            "1,2,3,4,5,45:6:30000.00", "1,2,3,4,5,6:7:2000000.00"}, delimiter = ':')
    void getRevenueRate(String purchaseNumber, int bonusNum, String expectedRevenueRate) {
        // given
        Set<Integer> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(","))).stream()
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());

        Lotto prizeLotto = Lotto.from(numbers);
        Number bonusNumber = Number.from(bonusNum);
        WinningLotto winningLotto = WinningLotto.of(prizeLotto, bonusNumber);

        // when
        lottoStatistics.makeStatisticsResult(lottos, winningLotto);
        BigDecimal revenueRate = lottoStatistics.getRevenueRate();

        // then
        assertThat(revenueRate).isEqualTo(new BigDecimal(expectedRevenueRate));
    }
}
