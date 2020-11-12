package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryAgentTest {

    private LotteryAgent lotteryAgent;

    @BeforeEach
    void setUp() {
        lotteryAgent = new LotteryAgent();
    }

    @DisplayName("돈을 받고 티켓과 거스름돈을 반환한다.")
    @Test
    void exchange() {
        LotteryAgent.ExchangeResult ticketAndChange = lotteryAgent.exchange(Money.of(1500));
        assertThat(ticketAndChange).isNotNull();
    }

    @DisplayName("돈이 최소 구입금액에 못미치면 예외가 발생한다.")
    @Test
    void notEnoughMoney() {
        assertThatThrownBy(() -> lotteryAgent.exchange(Money.of(500))) //
                .isInstanceOf(NotEnoughMoneyException.class);
    }

    @DisplayName("티캣을 구매하고 남은 돈은 거슬러준다.")
    @ParameterizedTest
    @CsvSource({"1000,0", "1234,234", "2000,0"})
    void changes(int money, int change) {
        assertThat(lotteryAgent.exchange(Money.of(money)).getChange()).isEqualTo(Money.of(change));
    }

    @DisplayName("구매액수에 맞는 티캣을 교환해준다.")
    @ParameterizedTest
    @CsvSource({"1000,1", "1234,1", "2000,2"})
    void tickets(int money, int size) {
        LotteryTickets lotteryTickets = lotteryAgent.exchange(Money.of(money)).getLotteryTickets();
        assertThat(lotteryTickets.size()).isEqualTo(size);
    }


    @DisplayName("티캣은 선택한 번호들을 가진다.")
    @Test
    void ticketHasNumbers() {
        LotteryTickets lotteryTickets = lotteryAgent.exchange(Money.of(1000)).getLotteryTickets();
        List<LotteryNumber> numbers = lotteryTickets.getNumbers();
        assertThat(numbers.get(0)).isInstanceOf(LotteryNumber.class);
    }

}
