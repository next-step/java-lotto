package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @ValueSource(ints = {3})
    @ParameterizedTest
    void 로또횟수에_따른_로또번호가_정상호출(int ints) {
        assertThat(new LottoMachine(ints));
    }

}