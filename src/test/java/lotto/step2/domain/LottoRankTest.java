package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    @DisplayName("findByCount의 입력으로 일치하는 개수를 넣으면, 해당하는 LottoRank 객체를 반환한다.")
    void testFindByCount() {
        assertThat(LottoRank.findByCountAndBonusMatching(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.findByCountAndBonusMatching(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.findByCountAndBonusMatching(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.findByCountAndBonusMatching(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.findByCountAndBonusMatching(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("hasMatchingCount를 사용하면, 각 LottoRank의 matchingCount가 0 초과인지 확인한다.")
    void testHasMatchingCount() {
        assertThat(LottoRank.OTHER.hasMatchingCount()).isFalse();

        assertThat(LottoRank.FIFTH.hasMatchingCount()).isTrue();
        assertThat(LottoRank.FOURTH.hasMatchingCount()).isTrue();
        assertThat(LottoRank.THIRD.hasMatchingCount()).isTrue();
        assertThat(LottoRank.SECOND.hasMatchingCount()).isTrue();
        assertThat(LottoRank.FIRST.hasMatchingCount()).isTrue();
    }
}
