package lotto.step2.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @Test
    @DisplayName("findByCount의 입력으로 일치하는 개수를 넣으면, 해당하는 LottoRank 객체를 반환한다.")
    void testFindByCount() {
        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(LottoRank.findByCountAndBonusMatching(3, false)).isEqualTo(LottoRank.FIFTH);
                    softly.assertThat(LottoRank.findByCountAndBonusMatching(4, false)).isEqualTo(LottoRank.FOURTH);
                    softly.assertThat(LottoRank.findByCountAndBonusMatching(5, false)).isEqualTo(LottoRank.THIRD);
                    softly.assertThat(LottoRank.findByCountAndBonusMatching(5, true)).isEqualTo(LottoRank.SECOND);
                    softly.assertThat(LottoRank.findByCountAndBonusMatching(6, false)).isEqualTo(LottoRank.FIRST);
                }
        );
    }

    @Test
    @DisplayName("hasMatchingCount를 사용하면, 각 LottoRank의 matchingCount가 0 초과인지 확인한다.")
    void testHasMatchingCount() {
        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(LottoRank.OTHER.hasMatchingCount()).isFalse();

                    softly.assertThat(LottoRank.FIFTH.hasMatchingCount()).isTrue();
                    softly.assertThat(LottoRank.FOURTH.hasMatchingCount()).isTrue();
                    softly.assertThat(LottoRank.THIRD.hasMatchingCount()).isTrue();
                    softly.assertThat(LottoRank.SECOND.hasMatchingCount()).isTrue();
                    softly.assertThat(LottoRank.FIRST.hasMatchingCount()).isTrue();
                }
        );
    }
}
