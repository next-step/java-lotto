package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Receipt;
import step2.domain.Ticket;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ReceiptTest {
    @Test
    void constructor() {
        Receipt receipt = new Receipt(0, Arrays.asList(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6))));

        assertThat(receipt.getChange()).isEqualTo(0);
        assertThat(receipt.getTickets().size()).isEqualTo(1);
        assertThat(receipt.getTickets()).isEqualTo(Arrays.asList(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }
}
