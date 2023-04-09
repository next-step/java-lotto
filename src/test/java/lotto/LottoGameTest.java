package lotto;

import casino.Casino;
import configuration.WinnerType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    public WinnerType winnerType;
    @Test
    void 일등() {
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(Casino.match(userLotto, winningLotto)).isEqualTo(winnerType.FIRST);
    }

    @Test
    void 이등() {
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(Casino.match(userLotto, winningLotto)).isEqualTo(winnerType.SECOND);
    }

    @Test
    void 삼등() {
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 5, 8);
        int bonusNumber = 9;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(Casino.match(userLotto, winningLotto)).isEqualTo(winnerType.THIRD);
    }

    @Test
    void 사등() {
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 4, 6, 9);
        int bonusNumber = 10;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(Casino.match(userLotto, winningLotto)).isEqualTo(winnerType.FORTH);
    }

    @Test
    void 오등() {
        List<Integer> userLottoNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningLottoNumber = List.of(1, 2, 3, 8, 9, 10);
        int bonusNumber = 11;
        Lotto userLotto = LottoFactory.manualLotto(userLottoNumber);
        WinningLotto winningLotto = LottoFactory.manualWinningLotto(winningLottoNumber, bonusNumber);
        assertThat(Casino.match(userLotto, winningLotto)).isEqualTo(winnerType.FIFTH);
    }
}
