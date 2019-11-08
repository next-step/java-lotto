package lotto.domain2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 생성() {
        final LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine).isEqualTo(new LottoMachine());
    }

    @ParameterizedTest
    @ValueSource(ints = 10)
    void 로또발급(final int countOfLotto) {
        final LottoMachine lottoMachine = new LottoMachine();
        final Lottos lottos = lottoMachine.issue(countOfLotto);
        assertThat(lottos.count()).isEqualTo(countOfLotto);
    }
}
