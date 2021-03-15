package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void init() {
        lottoStatistics = new LottoStatistics();
    }

    @DisplayName("총 수익을 계산한다.")
    @Test
    void totalProfit() {
        //given
        List<Rank> matchResult = createRankList();

        //when
        int result = lottoStatistics.totalProfit(matchResult);

        //then
        assertThat(result).isEqualTo(1555000);
    }

    @DisplayName("총수익이 0이면 0이다.")
    @Test
    void ZeroProfit() {
        //given
        List<Rank> matchResult = List.of(Rank.MISS);

        //when
        int result = lottoStatistics.totalProfit(matchResult);

        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("수익률은 소수 2번째 자리까지 반올림한다.")
    @Test
    void statistics_소수점() {
        //given
        List<Rank> matchResult = createRankList();

        //when
        BigDecimal statistics = lottoStatistics.statistics(1000, matchResult);

        //then
        assertThat(statistics.scale()).isEqualTo(2);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void statistics_계산() {
        //given
        List<Rank> matchResult = createRankList();

        //when
        BigDecimal statistics = lottoStatistics.statistics(100000, matchResult);

        //then
        assertThat(statistics).isEqualTo(BigDecimal.valueOf(15.55));
    }

    @DisplayName("매칭된 로또들을 그룹화한다.")
    @Test
    void matchOfLotto_계산() {
        //given
        List<Rank> matchResult = createRankList();

        //when
        Map<Integer, List<Rank>> matchGroup = lottoStatistics.groupMatchOfLotto(matchResult);

        //then
        assertThat(matchGroup.get(6).size()).isEqualTo(0);
        assertThat(matchGroup.get(5).size()).isEqualTo(1);
    }

    List<Rank> createRankList() {
        return List.of(Rank.MISS, Rank.FIFTH, Rank.FOURTH, Rank.SECOND);
    }
}