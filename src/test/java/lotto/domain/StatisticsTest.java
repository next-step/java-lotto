package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    private final List<LottoRank> givenRanks = new ArrayList<LottoRank>() {
        {
            add(LottoRank.FIRST);
            add(LottoRank.FAIL);
            add(LottoRank.THIRD);
            add(LottoRank.SECOND);
            add(LottoRank.SECOND);
        }
    };
    private final LottoRanks lottoRanks = new LottoRanks(givenRanks);

    @DisplayName("정상적인 매개변수를 받아 객체를 생성할 때 예외가 발생하지 않는다.")
    @Test
    void When__Then_() {
        // then
        Assertions.assertDoesNotThrow(() -> new Statistics(lottoRanks));
    }

    @DisplayName("로또 등수 리스트에서 등수별 당첨 수를 구한다.")
    @Test
    void Given_로또_등수_리스트_When_등수별_당첨수_구하기_Then_당첨수_반환() {
        // given
        final Statistics statistics = new Statistics(lottoRanks);

        // when
        final Map<LottoRank, Integer> rankCounts = statistics.getResult()
                .getNumberOfRanks().get();

        // then
        assertThat(rankCounts.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.SECOND)).isEqualTo(2);
        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.FIFTH)).isEqualTo(0);
    }

    @DisplayName("로또 당첨등수 리스트에서 총 수익률을 구한다.")
    @Test
    void Given_로또_등수_리스트_When_수익률_구하기_Then_수익률_반환() {
        // given
        final Statistics statistics = new Statistics(lottoRanks);

        final double rate = statistics.getResult().getProfitRate();
        final double expected = (LottoRank.FIRST.getAmount() + LottoRank.SECOND.getAmount() * 2
                + LottoRank.THIRD.getAmount()) / (givenRanks.size() * 1000);

        assertThat(rate).isEqualTo(expected);
    }
}
