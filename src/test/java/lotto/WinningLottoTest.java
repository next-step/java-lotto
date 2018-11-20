package lotto;


import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    // 당첨번호 + 보너스번호 입력받아 1등, 2등 체크가 가능해야함
    // 1등 : 6개 일치 (보너스번호 X)
    // 2등 : 5개 일치 + 보너스번호

    @Test
    public void 일등체크() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2 , 3 , 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        assertThat(winningLotto.getRankByMatchingLotto(lotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 이등체크() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2 , 3 , 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 44)), 6);

        assertThat(winningLotto.getRankByMatchingLotto(lotto)).isEqualTo(Rank.SECOND);
    }
}