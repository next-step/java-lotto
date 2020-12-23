package lotto.domain;

import lotto.domain.numbers.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("입력받은 수만큼 로또 티켓들이 자동으로 생성된다.")
    @Test
    void makeLottoTickets() {
        LottoTickets autoLottoTickets = new LottoMachine(13).makeAutoLottoTickets();
        assertThat(autoLottoTickets.getCount()).isEqualTo(13);
    }
}
