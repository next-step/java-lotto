package lotto.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserTest {

    @ParameterizedTest(name = "충분한 돈을 가지고 있는지 검증, 소유액: {0}, 비교액: {1}")
    @CsvSource(value = {
        "1000,500,true",
        "1000,1000,true",
        "1000,2000,false"
    })
    void hasEnoughMoney(int money1, int money2, boolean expected) {
        assertThat(new User(new Money(money1)).hasEnoughMoney(new Money(money2))).isEqualTo(expected);
    }

    @ParameterizedTest(name = "티켓 구입 후 남은 돈과 티켓 수 검증, 소유액: {0}, 티켓 가격: {1}, 잔액: {2}")
    @CsvSource(value = {
        "10000,4000,6000",
        "5000,1000,4000"
    })
    void buyTicket(int amount, int ticketPrice, int change) {
        User user = new User(new Money(amount));
        TicketMachine ticketMachine = new TicketMachine();

        user.buyTicket(ticketMachine.createLottoTicket(() -> createLottoNumbers(List.of(1, 2, 3, 4, 5, 6))), new Money(ticketPrice));

        assertThat(user.getMoney()).isEqualTo(new Money(change));
        assertThat(user.getLottoTickets().size()).isEqualTo(1);
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
            .map(LottoNumber::new)
            .collect(toList());
    }
}
