package raffle.lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또입력확인(){
        String lottoNo = "1, 6 , 14 , 44 , 36 , 11";
        Lotto lotto = new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList()));

        assertThat(lotto.getLottoNumber().size()).isEqualTo(6);
    }

    @Test
    public void 로또등수4등(){
        String lottoNo = "1, 6 , 5 , 44 , 22 , 15";
        Lotto lotto = new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList()));

        String lastWeekLotto = "1, 2 , 5 , 11 , 22 , 15";
        Lotto lottoWin = new Lotto(Arrays.stream(lastWeekLotto.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList()));

        assertThat(lotto.getWinCount(lottoWin)).isEqualTo(4);
    }

    @Test
    public void 로또등수_보너스볼_여부(){
        String lottoNo = "1, 6 , 5 , 44 , 22 , 15";
        Lotto lotto = new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList()));

        LottoNo bonusLotto = new LottoNo(22);

        assertThat(lotto.hasBonus(bonusLotto)).isTrue();
    }

}