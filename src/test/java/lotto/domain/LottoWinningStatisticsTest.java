package lotto.domain;

import lotto.service.LottoVendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoWinningStatisticsTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );
        Lotto lotto2 = new Lotto(Arrays.asList(
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7),
                LottoNumber.of(8),
                LottoNumber.of(9))
        );
        this.lottos = new Lottos(Arrays.asList(lotto,lotto2));
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,6")
    @DisplayName("로또 6개일치 3개일치 건수 검증")
    void lotto_winningStatistics_matchCount(String winningNumber) {
        //given
        List<LottoResult> lottoResults = LottoVendingMachine.lottoWinningResults(lottos,winningNumber);

        //when
        Map<LottoResult, AtomicInteger> resultMap = LottoWinningStatistics.getStatistics(lottoResults);
        int first = resultMap.get(LottoResult.FIRST).get();
        int fourth = resultMap.get(LottoResult.FOURTH).get();

        //then
        assertAll(
                () -> assertThat(first).isEqualTo(1),
                () -> assertThat(fourth).isEqualTo(1)
        );
    }
}
