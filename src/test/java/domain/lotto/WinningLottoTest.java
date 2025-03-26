package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {

    @DisplayName("당첨 번호가 모두 일치하면 당첨")
    @Test
    void isWinningLotto() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean isWinningLotto = lotto.isWinningLotto(winningLotto);

        // then
        Assertions.assertThat(isWinningLotto).isTrue();
    }
}
