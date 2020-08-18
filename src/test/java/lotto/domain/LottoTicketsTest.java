package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private static final LottoTicketMaker LOTTO_TICKET_RANDOM_MAKER = new LottoTicketRandomMaker();

    @DisplayName("로또 랜덤 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5000:5", "20000:20", "210000:210"}, delimiter = ':')
    void create_tickets_random(String lottoMoney, int expectedBuyCount) {
        BuyCount buyCount = BuyCount.of(lottoMoney);
        LottoTickets lottoTickets = LottoTickets.of(buyCount, LOTTO_TICKET_RANDOM_MAKER);

        assertThat(lottoTickets.number()).isEqualTo(expectedBuyCount);
    }
}
