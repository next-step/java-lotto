package LottoTest;

import lotto.domain.LottoMatchNumbers;
import lotto.domain.LottoStats;
import lotto.domain.Rank;
import lotto.domain.RankingRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoStatsTest {
    @Test
    @DisplayName("LottoStats 인스턴스 생성 테스트")
    void Given_LottoGameResults_When_New_Then_StatsInstanceCreated() {
        //given
        List<LottoMatchNumbers> lottoNumberMatches = Arrays.asList(
                new LottoMatchNumbers(3)
        );

        //when then
        assertDoesNotThrow(() -> new LottoStats(lottoNumberMatches));
    }

    @Test
    @DisplayName("등수 별 당첨자 수가 정확한지 테스트")
    void When_Rank_Then_RankReturn() {
        //given
        List<LottoMatchNumbers> lottoNumberMatches = Arrays.asList(
                new LottoMatchNumbers(3),
                new LottoMatchNumbers(3),
                new LottoMatchNumbers(6)
        );

        LottoStats lottoStats = new LottoStats(lottoNumberMatches);

        //when
        RankingRecord rank = lottoStats.record(Rank.FORTH);

        //then
        assertThat(rank.winners()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 수익율 계산 테스트")
    void Given_LottoGameResults_When_Yield_Then_CalculatedYield() {
        //gvien
        List<LottoMatchNumbers> lottoNumberMatches = Arrays.asList(
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(0),
                new LottoMatchNumbers(3)
        );
        LottoStats lottoStats = new LottoStats(lottoNumberMatches);


        //when
        double yield = lottoStats.yield();
        double expect = (double) 5000 / (lottoNumberMatches.size() * 1000);

        //then
        assertThat(yield).isEqualTo(expect);
    }

}
