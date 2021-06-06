package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domains.Purchase;
import lotto.domains.Tickets;
import lotto.exceptions.TicketsOutOfBoundsException;

public class ManualTicketsBuilderTest {

    @DisplayName("수동으로 구매 개수와 입력한 티켓 수가 맞지 않으면 에러 발생")
    @Test
    void create_IncorrectTickets_ExceptionThrown() {
        Purchase purchase = new Purchase("3000");
        purchase.selectManualAmount(2);

        assertThatExceptionOfType(TicketsOutOfBoundsException.class).isThrownBy(() -> {
            new ManualTicketsBuilder(purchase).build();
        });
    }

    @DisplayName("수동으로 티켓 생성")
    @Test
    void manualTicketing() {
        Purchase purchase = new Purchase("3000");
        purchase.selectManualAmount(2);

        Tickets tickets = new ManualTicketsBuilder(purchase)
            .newTickets(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
            .build();

        assertThat(tickets.size()).isEqualTo(2);
    }

}
