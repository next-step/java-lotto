package lotto.application;

import lotto.domain.*;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.as;

class LottoWinningStatisticsTest {
    @DisplayName("사용자 로또 번호와 당첨 번호를 매칭하여 당첨 통계 객체를 생성한다.")
    @MethodSource("generateUserLottos")
    @ParameterizedTest(name = "결과= {1}")
    void create(Lottos userLottos, LottoRank lottoRank) {
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        LottoWinningStatistics winningStatistics = new LottoWinningStatistics(userLottos, new WinningLotto(winningLotto, new LottoNumber(13)));

        assertThat(winningStatistics)
                .extracting("values", as(InstanceOfAssertFactories.MAP))
                .extractingByKeys(lottoRank)
                .containsExactly(1);
    }


    static Stream<Arguments> generateUserLottos() {
        return Stream.of(
                Arguments.arguments(new Lottos(new Lotto(1, 2, 9, 10, 11, 12)), LottoRank.NON_RANKED),
                Arguments.arguments(new Lottos(new Lotto(1, 2, 3, 4, 5, 7)), LottoRank.THIRD),
                Arguments.arguments(new Lottos(new Lotto(1, 2, 3, 4, 5, 13)), LottoRank.SECOND),
                Arguments.arguments(new Lottos(new Lotto(1, 2, 3, 4, 5, 6)), LottoRank.FIRST)
        );
    }

    @DisplayName("인자로 전달받은 등수에 해당하는 로또의 갯수를 반환한다.")
    @Test
    void return_lotto_quantity_by_ranking() {
        Map<LottoRank, Integer> statistics = new HashMap<>();
        statistics.put(LottoRank.FIRST, 2);
        LottoWinningStatistics winningStatistics = new LottoWinningStatistics(statistics);

        int result = winningStatistics.getLottoQuantityOfRanking(LottoRank.FIRST);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("로또 구입금액을 전달받아서 로또 당첨금액 계산 후 수익률을 계산하여 반환한다.")
    @Test
    void calculate_returnRate() {
        Map<LottoRank, Integer> statistics = new HashMap<>();
        statistics.put(LottoRank.FIFTH, 2);
        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(statistics);
        LottoPrice lottoPurchaseAmount = new LottoPrice(12000);

        float actual = lottoWinningStatistics.calculateReturnRate(lottoPurchaseAmount);

        assertThat(actual).isEqualTo(0.83f);
    }
}
