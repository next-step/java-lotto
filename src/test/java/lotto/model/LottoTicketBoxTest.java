package lotto.model;

import lotto.util.LottoTicketBox;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketBoxTest {

    @Test
    void buy() {
        assertThat(LottoTicketBox.buy(10000).size()).isEqualTo(5);
    }
}
