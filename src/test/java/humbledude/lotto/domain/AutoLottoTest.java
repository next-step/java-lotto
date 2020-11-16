package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTest {

    @Test
    public void autoLotto() {
        LottoTicket ticket = AutoLotto.buildTicket();

        assertThat(ticket.getNumbers())
                .isInstanceOf(Set.class)
                .hasSize(6)
                .allSatisfy(n -> assertThat(n.getNumber()).isBetween(1, 45));
    }

}
