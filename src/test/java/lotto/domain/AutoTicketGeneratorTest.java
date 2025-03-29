package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoTicketGeneratorTest {
    @Test
    void generate() {
        assertThat(AutoTicketGenerator.generate()).isInstanceOf(LottoTicket.class);
    }
}
