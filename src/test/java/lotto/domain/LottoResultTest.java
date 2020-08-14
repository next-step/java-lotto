package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("당첨결과 매칭 시 전체상금 추가")
    void getTotalPrize_addMatch_returnSum() {
        // given
        LottoResult result = new LottoResult(1000);
        // when
        result.addRanking(LottoRanking.THIRD);
        // then
        assertThat(result.getTotalPrize()).isEqualTo(LottoRanking.THIRD.prize());
    }

    @Test
    @DisplayName("당첨결과 매칭 시 수익률 계산")
    void getSaveOfReturn_addMatch_return() {
        // given
        LottoResult result = new LottoResult(10000);
        // when
        result.addRanking(LottoRanking.FOURTH);
        // then
        assertThat(result.getSaveOfReturn()).isEqualTo(0.5);
    }
}
