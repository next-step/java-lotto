package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ManualNumberOfTicketTest {

    @Test
    @DisplayName("수동 로또 티켓 수 생성")
    public void create() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(3_000), new LottoTicketPrice(1_000));
        ManualNumberOfTicket manualNumberOfTicket = new ManualNumberOfTicket(3, totalNumberOfTicket);
        assertThat(manualNumberOfTicket).isEqualTo(new ManualNumberOfTicket(3, totalNumberOfTicket));
    }

    @Test
    @DisplayName("수동 로또 티켓 생성 시 수동 로또 티켓 수를 넣는 인자에 숫자로 변환할 수 없는 문자를 넣을 경우 예외가 발생한다.")
    public void create_error() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(3_000), new LottoTicketPrice(1_000));
        assertThatIllegalArgumentException().isThrownBy(() -> new ManualNumberOfTicket("one", totalNumberOfTicket));
    }

    @Test
    @DisplayName("총 구매 가능한 티켓 개수보다 더 값이 큰 수동 로또 티켓의 수를 입력할 경우 예외가 발생한다.")
    public void validateBound() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(3_000), new LottoTicketPrice(1_000));
        assertThatIllegalArgumentException().isThrownBy(() -> new ManualNumberOfTicket(4, totalNumberOfTicket));
    }

    @Test
    @DisplayName("수동 로또 티켓의 수에 음수를 입력할 경우 예외가 발생한다.")
    public void validatePositive() throws Exception {
        TotalNumberOfTicket totalNumberOfTicket = new TotalNumberOfTicket(new PurchaseAmount(3_000), new LottoTicketPrice(1_000));
        assertThatIllegalArgumentException().isThrownBy(() -> new ManualNumberOfTicket(-1, totalNumberOfTicket));
    }
}
