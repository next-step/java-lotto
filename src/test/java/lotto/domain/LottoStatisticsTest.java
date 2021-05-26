package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @DisplayName("수익률 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,10,11,12:7:5.00", "1,2,3,4,10,11:7:50.00", "1,2,3,4,5,10:7:1500.00",
            "1,2,3,4,5,10:6:30000.00", "1,2,3,4,5,6:7:2000000.00"}, delimiter = ':')
    void getRevenueRate(String winningLottoNumbers, int bonusNumber, String expected) {
        // given
        LottoGame lottoGame = LottoGame.init(1000);
        lottoGame.buyLotto(new TestLottoNumberGenerator(), Collections.EMPTY_LIST);

        Lotto enteredWinningLotto = Lotto.from(Arrays.asList(winningLottoNumbers.split(","))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(toList()));
        LottoNumber lottoBonusNumber = LottoNumber.from(bonusNumber);
        WinningLotto winningLotto = WinningLotto.of(enteredWinningLotto, lottoBonusNumber);

        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.init(lottoGame, winningLotto);

        // when
        BigDecimal revenueRate = lottoStatistics.getRevenueRate();

        // then
        assertThat(revenueRate).isEqualTo(new BigDecimal(String.valueOf(expected)));
    }
}