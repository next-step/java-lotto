package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Test
    void 중복_보너스입력_예외() {
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(winningNumber, bonusNumber));
    }

    @Test
    void 당첨_번호_갯수_확인_5등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), 10);
        Rank rank = winningLotto.matchRank(lotto);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨_번호_갯수_확인_2등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)), 6);
        Rank rank = winningLotto.matchRank(lotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

}