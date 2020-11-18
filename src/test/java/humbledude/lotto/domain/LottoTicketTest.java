package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {

    @Test
    public void validNumbers() {
        assertThat(new LottoTicket(TestHelper.setOf(1, 2, 3 ,4 ,5, 6)))
                .isInstanceOf(LottoTicket.class);
    }

    @Test
    public void duplicatedNumbers() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoTicket(TestHelper.setOf(1, 2, 3 ,4 ,6, 6)));
    }
}
