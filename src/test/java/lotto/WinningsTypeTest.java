package lotto;

import lotto.domain.WinningsType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningsTypeTest {
    @Test
    void 타입찾기() {
        WinningsType winningsType = WinningsType.selectWinningsType(3).get();
        assertThat(winningsType).isEqualTo(WinningsType.사등);
    }
}
