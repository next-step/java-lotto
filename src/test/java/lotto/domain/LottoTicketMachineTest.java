package lotto.domain;

import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTicket;
import lotto.domain.strategy.LottoNumberGeneratorStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketMachineTest {

    @Test
    @DisplayName("구매 금액에 따라 티켓을 구매할 수 있다.")
    void shouldGenerateCorrectNumberOfTickets() {
        LottoTicketMachine machine = new LottoTicketMachine();
        int purchaseAmount = 5000;

        List<LottoTicket> tickets = machine.purchaseTickets(purchaseAmount);

        assertThat(tickets).hasSize(5);
    }

    @Test
    @DisplayName("구매 금액이 0원 미만이면 예외를 발생시킨다.")
    void shouldThrowExceptionWhenPurchaseAmountIsNegative() {
        LottoTicketMachine machine = new LottoTicketMachine();
        int purchaseAmount = 0;

        assertThatThrownBy(() -> machine.purchaseTickets(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 0보다 커야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 생성 전략에 따라 로또 티켓을 생성할 수 있다.")
    void shouldGenerateTicketWithExpectedNumberGeneratorStrategy() {
        LottoNumberGeneratorStrategy fixedLottoNumberGeneratorStrategy =
                () -> IntStream.range(0, 6).mapToObj(LottoNumber::new).collect(Collectors.toSet());
        LottoTicketMachine machine = new LottoTicketMachine(fixedLottoNumberGeneratorStrategy);
        int purchaseAmount = 1000;

        List<LottoTicket> tickets = machine.purchaseTickets(purchaseAmount);

        assertThat(tickets).isEqualTo(List.of(new LottoTicket(fixedLottoNumberGeneratorStrategy.generate())));
    }

}
