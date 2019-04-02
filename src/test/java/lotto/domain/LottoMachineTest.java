package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void 로또생성() {
        String[] lottoNumber = {"1", "2", "3", "4", "5", "6"};
        LottoMachine lottoMachine = new LottoMachine(1, 0, null);
        List<Lotto> lottos = lottoMachine.autoCreateLotto();
        assertThat(lottos).hasSize(1);
    }

    @Test
    public void n장로또생성() {
        String[] lottoNumber = {"1", "2", "3", "4", "5", "6"};
        LottoMachine lottoMachine = new LottoMachine(5, 0, null);
        List<Lotto> lottos = lottoMachine.autoCreateLotto();
        assertThat(lottos).hasSize(5);
    }

    @Test
    public void 수동로또생성() {
        String lottonumber = "1, 2, 3, 4, 5, 6";
        List<String> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(lottonumber);
        LottoMachine lottoMachine = new LottoMachine(1, 1, lottoNumbers);
        List<Lotto> lottos = lottoMachine.getAllLotto();
        assertThat(lottos).hasSize(1);
    }
}
