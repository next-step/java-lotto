package raffle.lotto.win;

import org.junit.Test;
import raffle.lotto.Lotto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class WinningLottoTest {

    @Test
    public void 로또2등여부검사() {
        List<Integer> lottoNumber = Arrays.asList(1, 23 , 5 , 44 , 22 , 15);
        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> number = Arrays.asList(1, 6 , 5 , 44 , 22 , 15);
        Lotto lastWeekLotto = new Lotto(number);

        List<Integer> number2 = Arrays.asList(23);
        Lotto bonusLotto = new Lotto(number2);

        WinningLotto winningLotto = new WinningLotto(lastWeekLotto, bonusLotto);

        assertThat(winningLotto.result(lotto)).isEqualTo(WinLotto.FIVE_WIN_BONUS_LOTTO);

    }
}