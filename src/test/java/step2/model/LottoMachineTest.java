package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.exception.NotEnoughMoneyException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    private static final LottoMachine LOTTO_MACHINE = LottoMachine.create(LottoTicketPrice.PRICE_1000);

    @DisplayName("create() 정적 생성자는 LottoMachine 인스턴스를 반환한다")
    @Test
    void create_TicketPrice_MachineInstance() {
        assertThat(LOTTO_MACHINE).isInstanceOf(LottoMachine.class);
    }

    @DisplayName("create() 정적 생성자에 Null을 입력하면 예외가 발생한다")
    @Test
    void create_Null_ExceptionThrown() {
        assertThatThrownBy(() -> LottoMachine.create(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("buyTicket() 메소드는 입력한 금액으로 구매할 수 있는 최대 티켓 장수를 반환한다")
    @MethodSource("provideMoneyForBuyTicket")
    @ParameterizedTest(name = "금액을 ''{0}'' 입력하면 ''{1}''장을 반환한다")
    void buyTicket_Money_LottoTickets(MoneyAmount moneyAmount, int expectedTicketCount) {
        LottoTickets lottoTickets = LOTTO_MACHINE.buyTicket(moneyAmount);

        assertThat(lottoTickets.getTicketCount()).isEqualTo(expectedTicketCount);
    }

    private static Stream<Arguments> provideMoneyForBuyTicket() {
        return Stream.of(
                Arguments.of(LottoData.createMoneyAmount(1_000), 1),
                Arguments.of(LottoData.createMoneyAmount(4_500), 4),
                Arguments.of(LottoData.createMoneyAmount(10_000), 10),
                Arguments.of(LottoData.createMoneyAmount(10_500), 10)
        );
    }

    @DisplayName("buyTicket() 메소드는 입력한 금액이 티켓 가격보다 적으면 예외가 발생한다")
    @Test
    void buyTicket_LackMoney_ExceptionThrown() {
        assertThatThrownBy(() -> LOTTO_MACHINE.buyTicket(LottoData.createMoneyAmount(999)))
                .isInstanceOf(NotEnoughMoneyException.class);
    }
}
