package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RankResultsTest {

    @Test
    void 로또_당첨결과_객체_생성_및_값_확인_성공() {
        // given
        RankResults rankResults = new RankResults(List.of(Rank.FIRST, Rank.SECOND, Rank.NONE));

        // when
        List<Rank> ranks = rankResults.getRanks();
        
        // then
        assertThat(ranks)
                .isEqualTo(List.of(Rank.FIRST, Rank.SECOND, Rank.NONE));
    }

    @Test
    void 로또_당첨결과_객체_합쳐서_생성_및_값_확인_성공() {
        // given
        RankResults rankResults = new RankResults(
                new RankResults(List.of(Rank.FIRST, Rank.SECOND, Rank.NONE)),
                new RankResults(List.of(Rank.FIRST, Rank.THIRD, Rank.NONE)));

        // when, then
        assertThat(rankResults.getRanks()).isEqualTo(
                List.of(Rank.FIRST, Rank.SECOND, Rank.NONE, Rank.FIRST, Rank.THIRD, Rank.NONE));
    }

    @Test
    void 로또_당첨결과_객체_통계_반환_성공() {
        // given
        RankResults rankResults = new RankResults(List.of(Rank.FIRST, Rank.SECOND, Rank.NONE));

        // when
        Map<Rank, Long> counts = rankResults.getRanksCounts();

        // then
        assertThat(counts).contains(
                entry(Rank.FIRST, 1L),
                entry(Rank.SECOND, 1L),
                entry(Rank.NONE, 1L)
        );

    }
}
