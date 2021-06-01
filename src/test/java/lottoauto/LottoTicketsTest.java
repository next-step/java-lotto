package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketsTest {
    LottoGenerateStrategy lottoGenerateStrategy = new AutoStrategy();

    @DisplayName("갯수를 받아 자동로또티켓을 주는 테스트")
    @Test
    void buyLottoTickets() {
        assertThat(new LottoTickets(14, lottoGenerateStrategy).size()).isEqualTo(14);
        assertThat(new LottoTickets(13, lottoGenerateStrategy).size()).isEqualTo(13);
        assertThat(new LottoTickets(1, lottoGenerateStrategy).size()).isEqualTo(1);
    }

    @DisplayName("로또티켓을 실제 구매금액 테스트")
    @Test
    void 로또티켓가격() {
        assertThat(new LottoTickets(14, lottoGenerateStrategy).calcInvestment()).isEqualTo(new Money(14000));
        assertThat(new LottoTickets(1, lottoGenerateStrategy).calcInvestment()).isEqualTo(new Money(1000));
    }


}
