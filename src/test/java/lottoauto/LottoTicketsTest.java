package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @DisplayName("돈보다 티켓을 더 요구하는 경우 예외")
    @Test
    void 수동티켓_예외() {
        RequestedManualLottoNumbers requestedManualLottoNumbers = new RequestedManualLottoNumbers(Stream.<String>builder().add("").add("").build().collect(Collectors.toList()));

        assertThatIllegalArgumentException().isThrownBy(()->new LottoTickets(new Money(1000), requestedManualLottoNumbers))
                .withMessage("돈이 부족하여 수동티켓을 줄 수 없습니다.");
    }
}
