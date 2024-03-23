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
        System.out.println(lottoTicketBall.getTicket());
        assertThat(lottoTicketBall.getTicket().contains(input)).isFalse();
    }

    @Test
    public void 로또는_6개의_숫자를_가짐() {
        System.out.println(lottoTicketBall.getTicket());
        assertThat(lottoTicketBall.getTicket().size()).isEqualTo(6);
    }
}
