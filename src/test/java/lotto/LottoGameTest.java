package lotto;

import casino.Casino;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    @Test
    void 일등() {
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(Casino.match(userLotto, winningLotto)).isEqualTo(1);
    }

    @Test
    void 이등() {
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(Casino.match(userLotto, winningLotto)).isEqualTo(2);
    }
}
