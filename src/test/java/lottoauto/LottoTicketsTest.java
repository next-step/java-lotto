package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    LottoGenerateStrategy lottoGenerateStrategy = new AutoStrategy();

    @DisplayName("돈을 받아 자동 로또티켓을 주는 테스트")
    @Test
    void buyLottoTickets() {
        assertThat(new LottoTickets(new Money(14000), lottoGenerateStrategy).size()).isEqualTo(14);
        assertThat(new LottoTickets(new Money(13500), lottoGenerateStrategy).size()).isEqualTo(13);
        assertThat(new LottoTickets(new Money(1000), lottoGenerateStrategy).size()).isEqualTo(1);
    }

    @DisplayName("로또티켓을 실제 구매금액 테스트")
    @Test
    void 로또티켓가격() {
        assertThat(new LottoTickets(new Money(14500), lottoGenerateStrategy).calcInvestment()).isEqualTo(new Money(14000));
        assertThat(new LottoTickets(new Money(1234), lottoGenerateStrategy).calcInvestment()).isEqualTo(new Money(1000));
    }
}
