package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    @DisplayName("돈을 받아 로또켓을 주는 테스트")
    @Test
    void buyLottoTickets() {
        assertThat(new LottoTickets(new Money(14000)).size()).isEqualTo(14);
        assertThat(new LottoTickets(new Money(13500)).size()).isEqualTo(13);
        assertThat(new LottoTickets(new Money(1000)).size()).isEqualTo(1);
    }

    @DisplayName("로또티켓을 실제 구매금액 테스트")
    @Test
    void 로또티켓가격() {
        assertThat(new LottoTickets(new Money(14500)).calcInvestment()).isEqualTo(new Money(14000));
        assertThat(new LottoTickets(new Money(1234)).calcInvestment()).isEqualTo(new Money(1000));
    }
}
