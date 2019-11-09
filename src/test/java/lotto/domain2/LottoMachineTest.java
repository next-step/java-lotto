package lotto.domain2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 생성() {
        final LottoMachine lottoMachine = new BasicLottoMachine();
        assertThat(lottoMachine).isEqualTo(new BasicLottoMachine());
    }

    @ParameterizedTest
    @ValueSource(ints = 10)
    void 로또발급(final int countOfLotto) {
        final LottoMachine lottoMachine = new BasicLottoMachine();
        final Lottos lottos = lottoMachine.issue(countOfLotto, Collections.emptyList());
        assertThat(lottos.count()).isEqualTo(countOfLotto);
    }
}
