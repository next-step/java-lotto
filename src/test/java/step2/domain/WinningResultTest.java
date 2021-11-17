package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WinningResultTest {

    @Test
    void 당첨_통계를_생성한다() {
        //given
        WinningResult winningResult = WinningResult.create();
        //when
        //then
        assertNotNull(winningResult);
        assertThat(winningResult.getWinningResult())
                .containsKeys(WinningType.FIRST, WinningType.SECOND,
                        WinningType.THIRD, WinningType.FOURTH);
        assertThat(winningResult.getWinningResult()).containsValues(0);
    }

    @Test
    void 당첨_결과를_추가한다() {
        //given
        WinningResult winningResult = WinningResult.create();
        //when
        WinningType first = WinningType.FIRST;
        winningResult.addCount(first);
        //then
        Map<WinningType, Integer> winningResultMap = winningResult.getWinningResult();
        assertThat(winningResultMap.get(first)).isEqualTo(1);
    }
}
