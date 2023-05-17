package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ClerkTest {

    @Test
    void buyTicket() {
        Clerk clerk = new Clerk(new LottoMachine(new LottoGenerator(Collections::shuffle)));
        PurchaseAmount amount = PurchaseAmount.of(10000, 0);
        LottoTicket ticket = clerk.buyTicket(amount, Collections.emptyList());

        assertThat(ticket.getLottos())
                .hasSize(10);
    }
}
