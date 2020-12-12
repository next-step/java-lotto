package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("입력한 금액만큼 로또 티켓들이 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"13000:13", "2000000000:2000000"}, delimiter = ':')
    void makeLottoTickets(long money, int expectedSize) {
        LottoTickets lottoTickets = new LottoMachine(money).makeLottoTickets();
        assertThat(lottoTickets.getLottoTickets()).hasSize(expectedSize);
    }
}
