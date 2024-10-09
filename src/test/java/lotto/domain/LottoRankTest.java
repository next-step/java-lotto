package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoRank.FIRST_RANK_MATCH_NUMBER;
import static lotto.domain.LottoRank.first;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    @DisplayName("당첨 된 번호 개수를 넘기면 그에 맞는 랭크가 반환된다.")
    void shouldReturnCorrectRank() {
        final LottoRank lottoRankByMatchedCount = LottoRank.findLottoRankByMatchedCount(FIRST_RANK_MATCH_NUMBER);
        assertThat(lottoRankByMatchedCount).isEqualTo(first());
    }
}