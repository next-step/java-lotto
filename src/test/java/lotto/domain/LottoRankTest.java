package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또의 매칭된 결과에 대한 타입 `LottoRank`에 대한 테스트")
class LottoRankTest {

    @DisplayName("로또와 숫자를 매칭한 결과 타입 찾기")
    @Test
    void findLottoResultTypeWithoutBonusTest() {
        // Given
        int matchedCount = LottoRank.FIRST.getMatchedCount();
        // When
        LottoRank lottoRank = LottoRank.findByMatchedCountAndBonus(matchedCount, false);
        // Then
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("로또와 숫자와 보너스를 매칭한 결과 타입 찾기")
    @Test
    void findLottoResultTypeWithBonusTest() {
        // Given
        int matchedCount = LottoRank.THIRD.getMatchedCount();
        // When
        LottoRank lottoRank = LottoRank.findByMatchedCountAndBonus(matchedCount, true);
        // Then
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }
}
