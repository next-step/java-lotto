package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    @DisplayName("주어진 개수만큼 로또를 발급한다")
    void shouldDrawLottoNumbers() {
        LottoMachine lottoMachine = new LottoMachine(6);

        assertThat(lottoMachine.lottos().getValues().size()).isEqualTo(6);
    }
}