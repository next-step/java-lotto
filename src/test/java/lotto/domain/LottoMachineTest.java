package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 생성() {
        NumberGenerator numberGenerator = new BasicNumberGenerator();
        LottoMachine lottoMachine = new BasicLottoMachine(numberGenerator);
        assertThat(lottoMachine).isEqualTo(new BasicLottoMachine(numberGenerator));
    }

    @Test
    void 로또_수동_발급() {
        NumberGenerator numberGenerator = new BasicNumberGenerator();
        LottoMachine lottoMachine = new BasicLottoMachine(numberGenerator);
        Lotto directLotto = lottoMachine.issue("1, 2, 3, 4, 5, 6");
        assertThat(directLotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
