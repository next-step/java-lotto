package lotto.domain2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 생성() {
        final LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine).isEqualTo(new LottoMachine());
    }
}
