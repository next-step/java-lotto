package lotto.domain;

import lotto.exception.PrizeOverFlowIsNegativeException;
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

    @Test
    @DisplayName("1등 2번 당첨된 경우 오버플로 발생하여 음수가 되는지 확인")
    void 로또_당첨_오버플로() {

        Lottos lottos = new Lottos();
        lottos.buyLotto(2000,() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.convertStringToIntList("1, 2, 3, 4, 5, 6");
        WinningCheck winningCheck = new WinningCheck(lottos,winningNumber);

        Assertions.assertThatThrownBy(
                () -> winningCheck.getWinningPrize()
        ).isInstanceOf(PrizeOverFlowIsNegativeException.class)
                .hasMessage("당첨금 계산 중 오버플로 발생");

    }
    @Test
    @DisplayName("1등 ,3등에 당첨되었을 때 총 상금을 초과하는지 확인")
    void 로또_상금_초과() {

        Lottos lottos = new Lottos();
        lottos.buyLotto(1000,() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.buyLotto(1000,() -> new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.convertStringToIntList("1, 2, 3, 4, 5, 6");
        WinningCheck winningCheck = new WinningCheck(lottos,winningNumber);

        Assertions.assertThatThrownBy(
                () -> winningCheck.getWinningPrize()
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("총 상금 20억을 넘길 순 없음");

    }

}
