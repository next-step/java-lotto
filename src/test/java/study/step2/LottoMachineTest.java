package study.step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step2.domain.Lotto;
import study.step2.domain.LottoMachine;

public class LottoMachineTest {
    @Test
    @DisplayName("금액에 따른 로또 생성 테스트")
    void purchase() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchase(12000);
        assertThat(lottos.size()).isEqualTo(12);
    }
}
