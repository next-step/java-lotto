package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void create() {
        LottoMachine lottoMachine = new LottoMachine();

        List<LottoNumber> lottoNumbers = lottoMachine.createLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }
}
