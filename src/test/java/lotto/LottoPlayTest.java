package lotto;

import lotto.domain.LottoTickets;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPlayTest {

    @Test
    void assertNumberOfPurchasedTicket() {
        int numberOfTickets = 5;
        Random random = new Random();

        LottoTickets lottoTickets = new LottoTickets(numberOfTickets, random);
        assertThat(lottoTickets.numberOfPurchasedTicket()).isEqualTo(5);
    }
}