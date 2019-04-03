package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void 자동로또생성() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.autoCreateLotto(1);
        assertThat(lottos).hasSize(1);
    }

    @Test
    public void n장자동로또생성() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.autoCreateLotto(5);
        assertThat(lottos).hasSize(5);
    }

    @Test
    public void 수동로또생성() {
        String lottonumber = "1, 2, 3, 4, 5, 6";
        List<String> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(lottonumber);
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.getAllLotto(0, lottoNumbers);
        assertThat(lottos).hasSize(1);
    }
}
