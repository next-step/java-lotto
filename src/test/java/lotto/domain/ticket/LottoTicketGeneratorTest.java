package lotto.domain.ticket;

import lotto.domain.number.RandomLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {

    @DisplayName("구입 가능한 갯수만큼 로또 티켓을 생성한다.")
    @Test
    void generateLottoTicketsTest() {
        List<List<Integer>> manualPurchaseLottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(3, 4, 5, 6, 7, 8)
        );
        int autoPurchaseLottoTicketCount = 10;

        LottoTickets lottoTickets = LottoTicketGenerator.generateLottoTickets(manualPurchaseLottoNumbers,autoPurchaseLottoTicketCount, new RandomLottoNumberGenerator());

        assertThat(lottoTickets.size()).isEqualTo(manualPurchaseLottoNumbers.size() + autoPurchaseLottoTicketCount);
    }

}
