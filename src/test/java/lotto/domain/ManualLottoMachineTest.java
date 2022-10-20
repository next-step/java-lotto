package lotto.domain;

import static lotto.domain.LottoBallsHelper.numbersToBalls;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import lotto.domain.exception.InvalidManualLottoPurchasePriceException;
import lotto.domain.number.LottoBalls;
import lotto.domain.number.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualLottoMachineTest {

    @Test
    @DisplayName("주어진 로또볼들로 로또티켓 발행")
    void issue_ticket_by_input_lotto_balls() {
        List<LottoBalls> inputLottoBalls = List.of(
                numbersToBalls(List.of(1, 2, 3, 4, 5, 6)),
                numbersToBalls(List.of(11, 12, 13, 14, 15, 16)),
                numbersToBalls(List.of(21, 22, 23, 24, 25, 26))
        );
        PurchasePrice purchasePrice = new PurchasePrice(Ticket.getPrice() * inputLottoBalls.size());

        ManualLottoMachine lottoMachine = new ManualLottoMachine();
        lottoMachine.markLottoBalls(inputLottoBalls.get(0));
        lottoMachine.markLottoBalls(inputLottoBalls.get(1));
        lottoMachine.markLottoBalls(inputLottoBalls.get(2));
        TicketBox ticketBox = lottoMachine.issueTickets(purchasePrice);

        assertThatEqualsBalls(inputLottoBalls, ticketBox);
    }

    @Test
    @DisplayName("작성한 티켓들의 총 값이 투입금액과 일치하지 않을 경우 예외 발생")
    void fail_to_issue_ticket_not_equals_price() {
        ManualLottoMachine lottoMachine = new ManualLottoMachine();
        lottoMachine.markLottoBalls(numbersToBalls(List.of(1, 2, 3, 4, 5, 6)));

        assertThatExceptionOfType(InvalidManualLottoPurchasePriceException.class)
                .isThrownBy(() -> lottoMachine.issueTickets(new PurchasePrice(10000)));
    }


    private void assertThatEqualsBalls(List<LottoBalls> inputLottoBalls, TicketBox ticketBox) {
        for (int i = 0; i < ticketBox.getSize(); i++) {
            Ticket ticket = ticketBox.getTickets().get(i);
            LottoBalls inputLottoBall = inputLottoBalls.get(i);
            assertThat(getMatchCount(ticket, inputLottoBall)).isEqualTo(LottoBalls.getBallsSize());
        }
    }

    private long getMatchCount(Ticket ticket, LottoBalls inputLottoBall) {
        return ticket.getLottoBalls()
                .getBalls()
                .stream()
                .filter(inputLottoBall::isContain)
                .count();
    }

}