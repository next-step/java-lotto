package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @Test
    void generateAuto() {
        List<Lotto> lottos = LottoMachine.generate(5);
        assertThat(lottos).hasSize(5);
    }

}