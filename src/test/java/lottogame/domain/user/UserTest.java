package lottogame.domain.user;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lottogame.domain.Money;
import lottogame.domain.TicketMachine;
import lottogame.domain.lotto.LottoNumber;
import lottogame.domain.lotto.LottoNumbers;

class UserTest {

    @ParameterizedTest(name = "정상적인 입력 시 User 객체 생성, 소지액: {0}, 수동 티켓 수: {1}, 티켓 가격: {2}")
    @CsvSource({
        "10000,0,1000",
        "5000,3,1500"
    })
    void create(int money, int manualCount, int ticketPrice) {
        new User(new Money(money), manualCount, new Money(ticketPrice));
    }

    @ParameterizedTest(name = "비정상적인 입력 시 예외 던져짐, 소지액: {0}, 수동 티켓 수: {1}, 티켓 가격: {2}\"")
    @CsvSource({
        "1000,0,2000",
        "1000,-1,1000",
        "3000,1,4000"
    })
    void invalidCreate(int money, int manualCount, int ticketPrice) {
        assertThatThrownBy(() -> new User(new Money(money), manualCount, new Money(ticketPrice)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "충분한 돈을 가지고 있는지 검증, 소유액: {0}, 비교액: {1}")
    @CsvSource(value = {
        "1000,500,true",
        "1000,1000,true",
        "1000,2000,false"
    })
    void hasEnoughMoney(int money1, int money2, boolean expected) {
        assertThat(new User(new Money(money1), Money.ZERO).hasEnoughMoney(new Money(money2))).isEqualTo(expected);
    }

    @ParameterizedTest(name = "티켓 구입 후 남은 돈과 티켓 수 검증, 소유액: {0}, 티켓 가격: {1}, 잔액: {2}")
    @CsvSource(value = {
        "10000,4000,6000",
        "5000,1000,4000"
    })
    void buyTicket(int amount, int ticketPrice, int change) {
        User user = new User(new Money(amount), Money.ZERO);
        TicketMachine ticketMachine = new TicketMachine();

        user.buyTicket(ticketMachine.createLottoTicket(() -> createLottoNumbers(List.of(1, 2, 3, 4, 5, 6))), new Money(ticketPrice));

        assertThat(user.getMoney()).isEqualTo(new Money(change));
        assertThat(user.getLottoTickets().size()).isEqualTo(1);
    }

    private LottoNumbers createLottoNumbers(List<Integer> numbers) {
        return new LottoNumbers(numbers.stream()
            .map(LottoNumber::new)
            .collect(toList()));
    }
}
