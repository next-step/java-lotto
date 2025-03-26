package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("로또 구매 금액은 0원 이상이어야 한다.")
    void shouldThrowExceptionWhenPurchaseAmountIsLessThanZero() {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        assertThatThrownBy(() -> lottoTicketMachine.purchase(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Amount must be greater than 0");
    }

    @Test
    @DisplayName("로또 구매 금액은 1000원 단위여야 한다.")
    void shouldThrowExceptionWhenPurchaseAmountIsNotMultipleOfThousand() {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        assertThatThrownBy(() -> lottoTicketMachine.purchase(500))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Amount must be a multiple of 1000");
    }

    @ParameterizedTest
    @DisplayName("로또 구매 금액 1000원당 1장의 로또 티켓을 구매할 수 있다.")
    @CsvSource({"1000, 1", "2000, 2", "14000, 14"})
    void shouldReturnCorrectNumberOfTicketsWhenPurchaseAmountIsMultipleOfThousand(int purchaseAmount, int expectedTicketCount) {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        assertThat(lottoTicketMachine.purchase(purchaseAmount)).hasSize(expectedTicketCount);
    }
}
