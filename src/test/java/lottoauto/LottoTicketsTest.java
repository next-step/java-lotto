package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    LottoTickets lottoTickets = new LottoTickets();

    @DisplayName("돈을 받아 lotto티켓을 주는 테스트")
    @Test
    void buyLottoTickets() {
        assertThat(lottoTickets.giveLottoTickets(new Money(14000)).size()).isEqualTo(14);
        assertThat(lottoTickets.giveLottoTickets(new Money(13500)).size()).isEqualTo(13);
        assertThat(lottoTickets.giveLottoTickets(new Money(1000)).size()).isEqualTo(1);
    }

    @DisplayName("로또티켓 가격 테스트")
    @Test
    void 로또티켓가격() {
        assertThat(lottoTickets.calcInvestment(14)).isEqualTo(new Money(14000));
        assertThat(lottoTickets.calcInvestment(1)).isEqualTo(new Money(1000));
    }
}
