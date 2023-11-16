package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningMachineTest {
    private Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private LottoWinningMachine winningMachine = new LottoWinningMachine(winningLotto);

    @Test
    @DisplayName("당첨 숫자와 로또 번호를 비교해 당첨 개수를 반환한다.")
    void match_user_lotto_and_winning_lotto() {
        int count = winningMachine.checkCount(winningLotto, new Lotto(List.of(2, 1, 3, 5, 4, 6)));
        assertThat(count).isEqualTo(6);

        int count2 = winningMachine.checkCount(winningLotto, new Lotto(List.of(2, 10, 3, 5, 4, 23)));
        assertThat(count2).isEqualTo(4);

        int count3 = winningMachine.checkCount(winningLotto, new Lotto(List.of(32, 10, 3, 5, 4, 23)));
        assertThat(count3).isEqualTo(3);
    }
}
