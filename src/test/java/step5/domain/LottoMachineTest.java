package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    @DisplayName("6개의 로또 번호가 발행되는지 확인")
    @Test
    void issue() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> issuedLotto = lottoMachine.issue();
        Assertions.assertThat(issuedLotto.size()).isEqualTo(6);
    }
}