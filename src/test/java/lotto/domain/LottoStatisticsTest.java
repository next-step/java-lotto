package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @DisplayName("수익률 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,10,11,12:5.00", "1,2,3,4,10,11:50.00", "1,2,3,4,5,7:1500.00", "1,2,3,4,5,6:2000000.00"}, delimiter = ':')
    void getRevenueRate(String winnerLottoNumbers, String expected) {
        // given
        LottoGame lottoGame = LottoGame.init(1000);
        lottoGame.buyLotto(new TestLottoNumberGenerator());

        Lotto winnerLotto = Lotto.from(new HashSet<>(Arrays.asList(winnerLottoNumbers.split(",")))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toSet()));

        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.init(lottoGame, winnerLotto);

        // when
        BigDecimal revenueRate = lottoStatistics.getRevenueRate();

        // then
        assertThat(revenueRate).isEqualTo(new BigDecimal(String.valueOf(expected)));
    }
}