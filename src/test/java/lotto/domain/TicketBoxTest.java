package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketBoxTest {

    @Test
    void sell() {
        assertThat(new TicketBox().sell(14000)).isEqualTo(14);
    }
}
