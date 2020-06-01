package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 뽑기")
    void raffle() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> result = lottoMachine.raffle();

        assertThat(result).hasSize(6);
    }
}
