package lotto.model.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        // when & then
        SoftAssertions.assertSoftly(softAssertions -> {
                    softAssertions.assertThat(ranks.count(FIRST)).isEqualTo(1);
                    softAssertions.assertThat(ranks.count(SECOND)).isEqualTo(0);
                    softAssertions.assertThat(ranks.count(THIRD)).isEqualTo(0);
                    softAssertions.assertThat(ranks.count(FOURTH)).isEqualTo(1);
                    softAssertions.assertThat(ranks.count(FIFTH)).isEqualTo(2);
                    softAssertions.assertThat(ranks.count(NONE)).isEqualTo(1);
                }
        );
    }
}
