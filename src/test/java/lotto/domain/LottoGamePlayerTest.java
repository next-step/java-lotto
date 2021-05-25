package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoGamePlayerTest {

    @Test
    @DisplayName("WinningType count 테스트")
    void getMatchCountResult() {
        WinningType[] winningTypes = {WinningType.FIRST, WinningType.SECOND, WinningType.SECOND, WinningType.SIXTH};
        int[] matchCountResults = new LottoGamePlayer().getMatchCountResult(winningTypes);
        assertThat(matchCountResults).containsExactly(0,1,0,0,0,2,1);
    }
}
