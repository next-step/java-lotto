import java.util.List;
import lotto.LottoTicketBall;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    private LottoTicketBall lottoTicketBall = new LottoTicketBall();

    @ParameterizedTest
    @ValueSource(ints = {0,46})
    public void 로또는_1_에서_45_까지의_숫자만_가질_수_있음(int input) {
        assertThat(lottoTicketBall.generateTicket().contains(input)).isFalse();
    }

    @Test
    public void 로또는_6개의_숫자를_가짐() {
        assertThat(lottoTicketBall.generateTicket().size()).isEqualTo(6);
    }

    @Test
    public void 하나의_로또_안에서_숫자가_겹치지_않음() {
        List<Integer> ticket = lottoTicketBall.generateTicket();
        assertThat(ticket.size()).isEqualTo(ticket.stream().distinct().count());

    }
}
