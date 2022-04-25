package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7})
    @DisplayName("input 개수 만큼의 로또 티켓 생성")
    void createLottoTickets(int input) {
        // given
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(new LottoNumberGenerator(new RandomGenerateStrategy()));
        // when
        List<LottoTicket> lottoTickets = lottoTicketGenerator.generateLottoTickets(input);
        // then
        assertThat(lottoTickets).hasSize(input);
    }

}