package lottery.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinPrizeTypeTest {

    @Test
    @DisplayName("당첨 개수에 따른 타입 조회 테스트")
    void fromMatchCountWithBonusMatchTest() {
        assertThat(WinPrizeType.fromMatchCountWithBonusMatch(5L, Boolean.FALSE)).isEqualTo(WinPrizeType.THIRD);
        assertThat(WinPrizeType.fromMatchCountWithBonusMatch(5L, Boolean.TRUE)).isEqualTo(WinPrizeType.SECOND);
    }
}
