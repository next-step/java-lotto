package domain;

import org.junit.Test;
import util.WinType;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test
    public void 정답_갯수() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto answer = new Lotto(1, 2, 3, 4, 5, 6);
        WinType type = lotto.lottery(answer);

        assertThat(type).isEqualTo(WinType.SIX);
    }
}