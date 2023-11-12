package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    @DisplayName("findByCount의 입력으로 일치하는 개수를 넣으면, 해당하는 LottoRank 객체를 반환한다.")
    void testFindByCount() {
        assertThat(LottoRank.findByCount(3)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.findByCount(4)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.findByCount(5)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.findByCount(6)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("hasMatchingCount를 사용하면, 각 LottoRank의 matchingCount가 0 초과인지 확인한다.")
    void testHasMatchingCount() {
        assertThat(LottoRank.OTHER.hasMatchingCount()).isFalse();
        
        assertThat(LottoRank.FOURTH.hasMatchingCount()).isTrue();
        assertThat(LottoRank.THIRD.hasMatchingCount()).isTrue();
        assertThat(LottoRank.SECOND.hasMatchingCount()).isTrue();
        assertThat(LottoRank.FIRST.hasMatchingCount()).isTrue();
    }
}
