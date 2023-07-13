package lotto.model.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.model.domain.Rank.*;
import static org.assertj.core.api.Assertions.*;

class RanksTest {

    @Test
    void Ranks_객체_생성_성공() {
        assertThatNoException().isThrownBy(() -> Ranks.of(List.of()));
    }

    @Test
    void Rank의_개수_계산_성공() {
        // given
        final Ranks ranks = Ranks.of(List.of(FIFTH, FOURTH, FIFTH, FIRST, NONE));

        // when
        final Map<Rank, Integer> ranksCount = ranks.allCounts();

        // then
        SoftAssertions.assertSoftly(softAssertions -> {
                    softAssertions.assertThat(ranksCount.get(FIRST)).isEqualTo(1);
                    softAssertions.assertThat(ranksCount.get(SECOND)).isNull();
                    softAssertions.assertThat(ranksCount.get(THIRD)).isNull();
                    softAssertions.assertThat(ranksCount.get(FOURTH)).isEqualTo(1);
                    softAssertions.assertThat(ranksCount.get(FIFTH)).isEqualTo(2);
                    softAssertions.assertThat(ranksCount.get(NONE)).isEqualTo(1);
                }
        );
    }
}
