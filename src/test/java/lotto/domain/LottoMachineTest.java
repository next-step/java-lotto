package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    void 로또번호_생성() {
        List<LottoNumber> results = LottoMachine.createLotto(new LottoPrice(5000));
        assertThat(results).hasSize(5);
    }
}
