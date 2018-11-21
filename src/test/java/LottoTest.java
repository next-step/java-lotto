import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    public void 일등() {
        int bonusNo = 7;
        Lotto lotto = Lotto.from(Arrays.asList(1,2,3,4,5,6));
        Lotto winnginglotto = Lotto.from(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winning = WinningLotto.from(winnginglotto, bonusNo);
        Rank value = winning.matchesNo(lotto);
        assertThat(value).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 이등() {
        int bonusNo = 7;
        Lotto lotto = Lotto.fromCommas("1, 2, 3, 4, 5, 7");
        Lotto winNo = Lotto.from(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = WinningLotto.from(winNo, bonusNo);
        Rank value = winningLotto.matchesNo(lotto);
        assertThat(value).isEqualTo(Rank.SECOND);
    }

    @Test (expected = IllegalArgumentException.class)
    public void 중복값() {
        Lotto lotto = Lotto.from(Arrays.asList(1,2,3,4,5,5));
        Lotto winnginglotto = Lotto.from(Arrays.asList(1,2,3,4,5,6));
        int result = lotto.match(winnginglotto);
        assertThat(result).isEqualTo(6);
    }
}