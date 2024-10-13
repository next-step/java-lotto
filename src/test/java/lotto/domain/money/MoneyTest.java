package lotto.domain.money;

import lotto.exception.InvalidMoneyAmountException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("유효한 금액으로 Money 인스턴스 생성한다.")
    @Test
    void createValidMoney() {
        Money money = Money.of(10_000);
        Assertions.assertThat(money.getAmount()).isEqualTo(10_000);
    }

    @DisplayName("유효하지 않은 금액(음수) 생성 시 예외가 발생한다.")
    @Test
    void throwExceptionWhenNegativeAmount() {
        Assertions.assertThatThrownBy(() -> Money.of(-1000))
                .isInstanceOf(InvalidMoneyAmountException.class)
                .hasMessage("구입금액은 양수여야 합니다.");
    }

    @DisplayName("구입 금액으로 구입 가능한 로또 티켓 갯수를 구할 수 있다.")
    @Test
    void calculateAvailableLottoTickets() {
        Money money = Money.of(10_000);
        Assertions.assertThat(money.availableLottoTickets(2000))
                .isEqualTo(5);
    }

    @DisplayName("유효하지 않은 금액(음수) 생성 시 예외가 발생한다.")
    @Test
    void throwExceptionWhenNotEnoughAmount() {
        long lottoTicketPrice = 2000;
        Assertions.assertThatThrownBy(
                        () -> Money.of(1000).availableLottoTickets(lottoTicketPrice)
                )
                .isInstanceOf(InvalidMoneyAmountException.class)
                .hasMessage(String.format("구입금액이 로또 티켓 1개 가격 %d원 보다 작습니다.", lottoTicketPrice));
    }

}
