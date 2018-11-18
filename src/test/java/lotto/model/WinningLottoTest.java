package lotto.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class WinningLottoTest {

    @Test
    public void 로또_번호_매치() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        Set<Integer> winnerNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 20, 21));

        Lotto lotto = Lotto.from(numbers);
        WinningLotto winningLotto = new WinningLotto(winnerNumbers, LottoNo.from(7));

        int matchCount = winningLotto.matchCount(lotto);
        assertThat(matchCount).isEqualTo(4);
    }


    @Test
    public void 로또_보너스_번호_매치() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        Set<Integer> winnerNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 20, 21));

        Lotto lotto = Lotto.from(numbers);
        WinningLotto winningLotto = new WinningLotto(winnerNumbers, LottoNo.from(7));

        assertThat(winningLotto.isBonusMatch(lotto)).isEqualTo(true);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_보너스_번호_중복_입력() {
        Set<Integer> winnerNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 20, 21));
        new WinningLotto(winnerNumbers, LottoNo.from(1));
    }

}