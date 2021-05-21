package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketBoxTest {

    @DisplayName("구매액을 입력 받아 로또티켓 장수 반환")
    @Test
    void return_number_of_tickets() {
        //Given
        TicketBox ticketBox = new TicketBox();
        int purchaseAmount = 14000;

        //When
        int countOfTicket = ticketBox.issueTicket(purchaseAmount);

        //Then
        assertThat(countOfTicket).isEqualTo(purchaseAmount / TicketBox.PRICE_PER_TICKET);
    }

    @DisplayName("구매액을 로또가격으로 나눈 값이 정수가 아닐 경우, IllegalArgumentException 발생")
    @Test
    void throw_exception_when_mod_is_not_zero() {
        //Given
        TicketBox ticketBox = new TicketBox();
        int purchaseAmount = 14500;

        //When + Then
        assertThatThrownBy(() -> ticketBox.issueTicket(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TicketBox.ERROR_AMOUNT_CANNOT_BE_DIVIDED);
    }

    @DisplayName("유효하지 않은 값을 구매액으로 입력한 경우, Exception을 발생시킨다")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @ValueSource(strings = {"0", "100001", "-1"})
    void throw_exception_when_invalid_purchase_amount(String input) {
        //Given
        TicketBox ticketBox = new TicketBox();
        int purchaseAmount = Integer.parseInt(input);

        //When + Then
        assertThatThrownBy(() -> ticketBox.issueTicket(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TicketBox.ERROR_AMOUNT_OUT_OF_RANGE);
    }
}
