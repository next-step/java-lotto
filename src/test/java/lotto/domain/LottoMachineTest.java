package lotto.domain;

import lotto.domain.numbers.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("입력받은 수만큼 로또 티켓들이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {13, 2000000})
    void makeLottoTickets(int count) {
        LottoTickets lottoTickets = new LottoMachine(count).makeLottoTickets();
        assertThat(lottoTickets.getLottoTickets()).hasSize(count);
    }
}
