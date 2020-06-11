package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    private static final LottoMachine LOTTO_MACHINE = LottoMachine.create(LottoTicketPrice.PRICE_1000);

    @DisplayName("정적 생성자는 LottoMachine 인스턴스 반환")
    @Test
    void create() {
        LottoMachine lottoMachine = LottoMachine.create(LottoTicketPrice.PRICE_1000);
        assertThat(lottoMachine).isInstanceOf(LottoMachine.class);
    }

    @DisplayName("정적 생성자는 null을 입력하면 예외 발생")
    @Test
    void createExceptionThrown() {
        assertThatThrownBy(() -> LottoMachine.create(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액으로 구매할 수 있는 최대 티켓 장수를 반환")
    @MethodSource("provideMoneyForBuyTicket")
    @ParameterizedTest(name = "금액을 ''{0}'' 입력하면 ''{1}''장 반환")
    void buyTicket(MoneyAmount moneyAmount, int expectedTicketCount) {
        LottoTicket lottoTicket = LOTTO_MACHINE.buyTicket(moneyAmount, ManualLottoNumbers.empty());

        assertThat(lottoTicket.getAutoCount()).isEqualTo(expectedTicketCount);
    }

    private static Stream<Arguments> provideMoneyForBuyTicket() {
        return Stream.of(
                Arguments.of(LottoData.createMoneyAmount(1_000), 1),
                Arguments.of(LottoData.createMoneyAmount(4_500), 4),
                Arguments.of(LottoData.createMoneyAmount(10_000), 10),
                Arguments.of(LottoData.createMoneyAmount(10_500), 10)
        );
    }

    @DisplayName("입력한 금액이 티켓 가격보다 적으면 예외 발생")
    @Test
    void buyTicketExceptionThrown() {
        assertThatThrownBy(() -> LOTTO_MACHINE.buyTicket(LottoData.createMoneyAmount(999), ManualLottoNumbers.empty()))
                .isInstanceOf(NotEnoughMoneyException.class);
    }
}
