package raffle.lotto.win;

import org.junit.Before;
import org.junit.Test;
import raffle.lotto.Lotto;
import raffle.lotto.LottoNo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    Lotto lotto;
    WinningLotto winningLotto;
    LottoNo bonusLotto;

    @Before
    public void setUp(){
        String lottoNo = "1, 23 , 5 , 44 , 22 , 15";
        lotto = new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList()));
        bonusLotto = new LottoNo(22);
    }

    @Test
    public void 로또2등_여부검사() {
        String lottoNo = "1, 6 , 5 , 44 , 22 , 15";
        Lotto lastWeekLotto = new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList()));

        winningLotto = new WinningLotto(lastWeekLotto, bonusLotto);

        assertThat(winningLotto.result(lotto)).isEqualTo(WinLotto.FIVE_WIN_BONUS_LOTTO);

    }

    @Test
    public void 로또3등_여부검사() {
        String lottoNo = "1, 23 , 5 , 22 , 10 , 33";
        Lotto lastWeekLotto = new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList()));

        winningLotto = new WinningLotto(lastWeekLotto, bonusLotto);

        assertThat(winningLotto.result(lotto)).isEqualTo(WinLotto.FOUR_WIN_LOTTO);

    }

    @Test
    public void 로또5등_여부검사() {
        String lottoNo = "1, 6 , 14 , 44 , 36 , 11";
        Lotto lastWeekLotto = new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList()));

        winningLotto = new WinningLotto(lastWeekLotto, bonusLotto);

        assertThat(winningLotto.result(lotto)).isEqualTo(WinLotto.TWO_LOTTO);

    }
}