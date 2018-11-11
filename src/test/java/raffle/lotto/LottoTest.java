package raffle.lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또입력확인(){
        List<Integer> number = Arrays.asList(1, 6 , 5 , 44 , 22 , 15);
        Lotto lotto = new Lotto(number);

        assertThat(lotto.getLottoNumber().size()).isEqualTo(6);
    }

    @Test
    public void 로또등수4등(){
        List<Integer> number = Arrays.asList(1, 6 , 5 , 44 , 22 , 15);
        Lotto lotto = new Lotto(number);

        List<Integer> lastWeekLotto = Arrays.asList(1, 2 , 5 , 11 , 22 , 15);
        Lotto lottoWin = new Lotto(lastWeekLotto);

        assertThat(lotto.getWinCount(lottoWin)).isEqualTo(4);
    }

    @Test
    public void 로또등수_보너스볼_여부(){
        List<Integer> number = Arrays.asList(1, 6 , 5 , 44 , 22 , 15);
        Lotto lotto = new Lotto(number);

        LottoNo bonusLotto = new LottoNo(22);

        assertThat(lotto.hasBonus(bonusLotto)).isTrue();
    }

}