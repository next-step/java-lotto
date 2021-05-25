package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoGamePlayerTest {

    @Test
    @DisplayName("WinningType count 테스트")
    void getMatchCountResult() {
        WinningType[] winningTypes = {WinningType.FIRST, WinningType.SECOND, WinningType.SECOND, WinningType.MISS};
        //int[] matchCountResults = new LottoGamePlayer().getMatchCountResult(winningTypes);
        //assertThat(matchCountResults).containsExactly(0,0,1,0,0,0,2,1);
        Map<WinningType, Integer> matchCountResults = new LottoGamePlayer().getGameResult(winningTypes);

        assertThat(matchCountResults.keySet()).containsExactly(WinningType.FIRST, WinningType.SECOND, WinningType.THIRD,
                WinningType.FORTH, WinningType.FIFTH, WinningType.MISS, WinningType.MISS, WinningType.MISS);
        assertThat(matchCountResults.values()).containsExactly(1, 2, 0, 0, 0, 1, 0, 0);

    }
}
