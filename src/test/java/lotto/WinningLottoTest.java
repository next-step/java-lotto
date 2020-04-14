package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    void matchTwoLottoReturnResultRank() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), 7);
        Rank rank = winningLotto.match(userLotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
