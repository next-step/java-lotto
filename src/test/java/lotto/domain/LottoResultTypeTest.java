package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또의 매칭된 결과에 대한 타입 `LottoResultType`에 대한 테스트")
class LottoResultTypeTest {

    @DisplayName("로또와 숫자를 매칭한 결과 타입 찾기")
    @Test
    void findLottoResultTypeWithoutBonusTest() {
        // Given
        int matchedCount = LottoResultType.SIX_MATCHED.getMatchedCount();
        // When
        LottoResultType lottoResultType = LottoResultType.findByMatchedCountAndBonus(matchedCount, false);
        // Then
        assertThat(lottoResultType).isEqualTo(LottoResultType.SIX_MATCHED);
    }

    @DisplayName("로또와 숫자와 보너스를 매칭한 결과 타입 찾기")
    @Test
    void findLottoResultTypeWithBonusTest() {
        // Given
        int matchedCount = LottoResultType.FIVE_MATCHED.getMatchedCount();
        // When
        LottoResultType lottoResultType = LottoResultType.findByMatchedCountAndBonus(matchedCount, true);
        // Then
        assertThat(lottoResultType).isEqualTo(LottoResultType.FIVE_AND_BONUS_MATCHED);
    }
}
