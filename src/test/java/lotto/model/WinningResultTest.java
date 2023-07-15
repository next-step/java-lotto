package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class WinningResultTest {
    @Test
    @DisplayName("수익률 계산 일치 확인")
    void 수익률_계산_일치_확인() {
        Map<Rank, Integer> result = Map.of(Rank.THREE, 1);

        WinningResult winningResult = new WinningResult(result,new LottoMoney(14000));

        assertThat(winningResult.getProfit()).isCloseTo(0.35, within(0.01));
    }

    @Test
    @DisplayName("Rank에 따른 rank수 확인")
    void rank_rank_수_확인(){
        Map<Rank, Integer> result = Map.of(Rank.THREE, 1);
        WinningResult winningResult = new WinningResult(result,new LottoMoney(14000));
        assertThat(winningResult.getRankCount(Rank.THREE)).isEqualTo(1);
    }
}
