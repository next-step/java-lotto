package lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void 로또생성() {
        List<Lotto> lottos = LottoMachine.createLotto(1);
        assertThat(lottos).hasSize(1);
    }

    @Test
    public void n장로또생성() {
        List<Lotto> lottos = LottoMachine.createLotto(5);
        assertThat(lottos).hasSize(5);
    }
}
