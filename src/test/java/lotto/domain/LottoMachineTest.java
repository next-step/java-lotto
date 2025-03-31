package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.LottoPriceException;
import lotto.vo.LottoManualTicket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    @Test
    @DisplayName("자동 및 수동 로또 구매 시 로또가 올바르게 생성되는지 테스트")
    void testBuyAllLottos() {
        int money = 6000;
        List<LottoManualTicket> tickets = List.of(
            new LottoManualTicket(List.of(1, 2, 3, 4, 5, 6)),
            new LottoManualTicket(List.of(7, 8, 9, 10, 11, 12))
        );

        LottoMachine lottoMachine = new LottoMachine(money, tickets);
        List<Lotto> lottos = lottoMachine.buyLottos();

        assertThat(lottos).hasSize(6)
            .allSatisfy(lotto -> assertThat(lotto).isNotNull());
    }

    @Test
    @DisplayName("구매금액이 로또 가격보다 적을 때 예외가 발생하는지 테스트")
    void testInsufficientMoney() {
        int money = 500;
        List<LottoManualTicket> tickets = List.of();

        assertThatThrownBy(() -> new LottoMachine(money, tickets))
            .isInstanceOf(LottoPriceException.class);
    }

    @Test
    @DisplayName("구매금액이 1000원 단위가 아닐 때 예외가 발생하는지 테스트")
    void testOddMoney() {
        int money = 1500;
        List<LottoManualTicket> tickets = List.of();

        assertThatThrownBy(() -> new LottoMachine(money, tickets))
            .isInstanceOf(LottoPriceException.class);
    }

    @Test
    @DisplayName("수동 로또 개수가 구매금액보다 많을 때 예외가 발생하는지 테스트")
    void testTooManyManualTickets() {
        int money = 2000;
        List<LottoManualTicket> tickets = List.of(
            new LottoManualTicket(List.of(1, 2, 3, 4, 5, 6)),
            new LottoManualTicket(List.of(7, 8, 9, 10, 11, 12)),
            new LottoManualTicket(List.of(13, 14, 15, 16, 17, 18))
        );

        assertThatThrownBy(() -> new LottoMachine(money, tickets))
            .isInstanceOf(LottoPriceException.class);
    }
}
