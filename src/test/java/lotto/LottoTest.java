package lotto;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    public void generateNumberTest() {
        LottoTickets lottoTickets = new LottoTickets("14000");
        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(14);
        assertThat(lottoTickets.checkValidTickets()).isTrue();
    }
}
