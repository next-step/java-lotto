package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticTest {
    @Test
    @DisplayName("우승자 통계 테스트")
    void 우승자_통계_테스트() {
        WinningStatistic ws = new WinningStatistic();
        ws.calculateStatistic(2_000_005_000);
        Assertions.assertThat(ws.getStatistic()).containsExactly(1,0,0,1);
    }

}
