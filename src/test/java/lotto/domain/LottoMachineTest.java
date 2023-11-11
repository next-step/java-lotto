package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또의 기본금액이 1,000으로 14,000원을 입력시 14개의 로또가 생성된다.")
    void createLottoMachine() {
        LottoMachine lottoMachine = new LottoMachine(new Money(14_000));
        Lottos lottos = lottoMachine.getLottoTickets();

        assertThat(lottos.getLottos()).hasSize(14);
    }
}