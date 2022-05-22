package lotto;

import lotto.domain.WinningsType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningsTypeTest {
    @Test
    void 타입찾기() {
        WinningsType winningsType = WinningsType.selectWinningsType(3, false).get();
        assertThat(winningsType).isEqualTo(WinningsType.오등);
    }

    @Test
    void 삼등구분() {
        WinningsType winningsType = WinningsType.selectWinningsType(5, false).get();
        assertThat(winningsType).isEqualTo(WinningsType.삼등);
    }

    @Test
    void 이등구분() {
        WinningsType winningsType = WinningsType.selectWinningsType(5, true).get();
        assertThat(winningsType).isEqualTo(WinningsType.이등);
    }
}
