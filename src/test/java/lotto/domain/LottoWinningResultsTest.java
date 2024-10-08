package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningResultsTest {
    @Test
    @DisplayName("LottoWinningResults 객체 생성 시 LottoWinningStatus 필드 개수만큼 winningResults가 초기화 된다.")
    void initLottoWinningResultsTest() {
        LottoWinningResults result = new LottoWinningResults();
        assertThat(result.getWinningResults())
                .hasSize(LottoWinningStatus.values().length);
    }
}