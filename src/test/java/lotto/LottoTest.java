package lotto;


import lotto.domain.WinningToLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("일등 당첨금 테스트")
    @Test
    public void 일등(){
        assertThat(WinningToLotto.getWinningAmount(6)).isEqualTo(WinningToLotto.SIX.price());
    }
}
