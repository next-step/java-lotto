package lotto.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * **************************************
 * lotto.model
 * **************************************
 * Created by on [16/11/2018 | Chris]
 * Task ::
 */
public class WinningLottoTest {
    @Test
    public void 로또_번호_매치() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 20, 21);

        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(winnerNumbers, 7);

        int matchCount = winningLotto.matchCount(lotto);
        assertThat(matchCount).isEqualTo(4);
    }


    @Test
    public void 로또_보너스_번호_매치() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 20, 21);

        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(winnerNumbers, 7);

        assertThat(winningLotto.isBonusMatch(lotto)).isEqualTo(true);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_보너스_번호_중복_입력() throws Exception {
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 20, 21);
        new WinningLotto(winnerNumbers, 1);
    }

}