package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @Test
    @DisplayName("구입 금액만큼 로또를 발급한다.")
    public void makeLottoTickets() {
        // given
        LottoNumberExtractor lottoNumberExtractor = new LottoNumberRandomExtractor();
        LottoMachine lottoMachine = new LottoMachine(lottoNumberExtractor);

        // when
        LottoTickets lottoTickets = lottoMachine.makeLottoTickets(3000);

        // then
        assertThat(lottoTickets.size()).isEqualTo(3);
    }
}