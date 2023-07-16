package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RankResultsDtoTest {

    @Test
    void 로또_당첨결과_객체_생성_및_값_확인_성공() {
        // given
        RankResultsDto rankResultsDto = new RankResultsDto(
                List.of(Rank.FIRST, Rank.SECOND, Rank.NONE));

        // when
        List<Rank> ranks = rankResultsDto.getRanks();

        // then
        assertThat(ranks)
                .isEqualTo(List.of(Rank.FIRST, Rank.SECOND, Rank.NONE));
    }

    @Test
    void 로또_당첨결과_객체_합쳐서_생성_및_값_확인_성공() {
        // given
        RankResultsDto rankResultsDto = RankResultsDto.add(
                new RankResultsDto(List.of(Rank.FIRST, Rank.SECOND, Rank.NONE)),
                new RankResultsDto(List.of(Rank.FIRST, Rank.THIRD, Rank.NONE)));

        // when, then
        assertThat(rankResultsDto.getRanks()).isEqualTo(
                List.of(Rank.FIRST, Rank.SECOND, Rank.NONE, Rank.FIRST, Rank.THIRD, Rank.NONE));
    }
}
