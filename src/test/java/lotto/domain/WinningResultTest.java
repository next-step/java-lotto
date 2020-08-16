package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningResultTest {

    @DisplayName("WinningResult null 입력 생성 테스트")
    @Test
    void create_null() {
        String expectedMessage = "";

        assertThatThrownBy(() -> WinningResult.of(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(expectedMessage);

    }

    @DisplayName("당첨 수익률 계산 테스트")
    @Test
    void calculateWinningRate() {
        // 구입 금액 : 7_000, 당첨 금액 : 1_550_000
        double expectedWinningRate = 221.42D;

        Map<LottoRank, Integer> lottoResultByRank = new HashMap<>();
        lottoResultByRank.put(LottoRank.FIRST, 0);
        lottoResultByRank.put(LottoRank.SECOND, 1);
        lottoResultByRank.put(LottoRank.THIRD, 1);
        lottoResultByRank.put(LottoRank.FOURTH, 0);
        lottoResultByRank.put(LottoRank.DROP, 5);

        WinningResult winningResult = WinningResult.of(lottoResultByRank);
        assertThat(winningResult.calculateWinningRate()).isEqualTo(expectedWinningRate);
    }
}
