package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningCheckTest {

    @Test
    @DisplayName("로또 금액 여부를 확인한다")
    void 로또_당첨_금액_확인() {
        Lottos lottos = new Lottos();
        lottos.buyLotto(1000,() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.convertStringToIntList("1, 2, 3, 4, 5, 6");

        WinningCheck winningCheck = new WinningCheck(lottos,winningNumber);
        Assertions.assertThat(winningCheck.getWinningPrize()).isEqualTo(2_000_000_000);

    }

}
