package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"100, 100", "300, 300", "500, 500", "70000, 70000"})
    @DisplayName("새로운 객체를 생성해도 정상적으로 금액을 비교한다")
    public void equals(int amount, int otherAmount) {
        assertThat(new Money(amount)).isEqualTo(new Money(otherAmount));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100, -500, -1000, -1500})
    @DisplayName("0원 미만의 금액을 인자로 받으면 예외를 던진다")
    public void InvalidMoneyException(int input) {
        assertThatThrownBy(() -> {
            new Money(input);
        }).isInstanceOf(RuntimeException.class);
    }

//    @ParameterizedTest
//    @CsvSource(value = {"1000, 1", "4000, 4", "6000, 6", "10000, 10"})
//    @DisplayName("소지한 금액에서 로또 금액을 나눈 결과로 로또 티켓을 반환한다")
//    public void purchasedTicket(int amount, int expected) {
//        assertThat(new Money(amount).purchasedTicket()).isEqualTo(new Ticket(expected));
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {100, 500, 600, 900, 990, 999})
//    @DisplayName("소지한 금액이 로또 판매금액보다 작으면 예외를 던진다")
//    public void purchasedTicket(int amount) {
//        assertThatThrownBy(() -> {
//            new Money(amount).purchasedTicket();
//        }).isInstanceOf(RuntimeException.class);
//    }

}
