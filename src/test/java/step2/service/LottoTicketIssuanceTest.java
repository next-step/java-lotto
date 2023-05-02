package step2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.vo.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTicketIssuanceTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "5500:5", "12000:12"}, delimiter = ':')
    void 로또_티켓은_구입금액에서_로또금액을_나눈만큼_발급된다(int money, int quantity) {
        final var tickets = LottoTicketIssuance.issues(new Money(money));

        final var lottoTickets = tickets.getLottoTickets();

        assertThat(lottoTickets).hasSize(quantity);
    }

    @Test
    void 로또_티켓_발급시_구입금액이_로또금액보다_작을경우_예외를_던진다() {
        assertThrows(
                IllegalStateException.class,
                () -> LottoTicketIssuance.issues(new Money(900))
        );
    }
}
