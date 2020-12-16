package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또의 매칭된 결과에 대한 타입 `LottoResultType`에 대한 테스트")
class LottoResultTypeTest {

    @DisplayName("로또와 숫자를 매칭한 결과 타입 찾기")
    @Test
    void findLottoResultTypeTest() {
        // Given
        int matchedCount = LottoResultType.SIX_MATCHED.getMatchedCount();
        // When
        LottoResultType lottoResultType = LottoResultType.findByMatchedCount(matchedCount);
        // Then
        assertThat(lottoResultType).isEqualTo(LottoResultType.SIX_MATCHED);
    }
}
