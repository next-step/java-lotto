package lotto.model.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RankResultsTest {

    @Test
    void 로또_당첨결과_객체_생성_및_값_확인_성공() {
        // given, when, then
        assertThat(new RankResults(List.of(Rank.FIRST, Rank.SECOND, Rank.NONE)).getRanks())
                .isEqualTo(List.of(Rank.FIRST, Rank.SECOND, Rank.NONE));
    }
}
