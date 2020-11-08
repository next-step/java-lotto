package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.PlayslipTest.*;

public class LotteryAgentTest {

    private LotteryAgent lotteryAgent;

    @BeforeEach
    void setUp() {
        lotteryAgent = new LotteryAgent();
    }

    @DisplayName("돈을 받고 티켓과 거스름돈을 반환한다.")
    @Test
    void exchange() {
        Object[] ticketAndChange = lotteryAgent.exchange(1500);
        assertThat(ticketAndChange).isNotNull() //
                .hasSize(2) //
                .hasOnlyElementsOfTypes(LotteryTickets.class, Integer.class);
    }

    @DisplayName("돈이 최소 구입금액에 못미치면 예외가 발생한다.")
    @Test
    void notEnoughMoney() {
        assertThatThrownBy(() -> lotteryAgent.exchange(500)) //
                .isInstanceOf(NotEnoughMoneyException.class);
    }

    @DisplayName("티캣을 구매하고 남은 돈은 거슬러준다.")
    @ParameterizedTest
    @CsvSource({"1000,0", "1234,234", "2000,0"})
    void changes(int money, int change) {
        assertThat(lotteryAgent.exchange(money)[1]).isEqualTo(change);
    }

    @DisplayName("구매액수에 맞는 티캣을 교환해준다.")
    @ParameterizedTest
    @CsvSource({"1000,1", "1234,1", "2000,2"})
    void tickets(int money, int size) {
        LotteryTickets lotteryTickets = (LotteryTickets) lotteryAgent.exchange(money)[0];
        assertThat(lotteryTickets.size()).isEqualTo(size);
    }


    @DisplayName("티캣은 선택한 번호들을 가진다.")
    @Test
    void ticketHasNumbers() {
        LotteryTickets lotteryTickets = (LotteryTickets) lotteryAgent.exchange(1000)[0];
        List<Set<Integer>> numbers = lotteryTickets.getNumbers();
        assertThat(numbers.get(0)).hasSize(6);
    }

    private static class LotteryAgent {
        private static final int PRICE_LOTTERY = 1000;

        public Object[] exchange(int money) {
            if (money < PRICE_LOTTERY) {
                throw new NotEnoughMoneyException();
            }

            Playslip playslip = new Playslip();
            playslip.selectNumbers(money / PRICE_LOTTERY);

            return new Object[]{new LotteryTickets(playslip.listNumbers()), money % PRICE_LOTTERY};
        }
    }

    private static class LotteryTickets {
        private final List<Set<Integer>> numbers;

        public LotteryTickets(List<Set<Integer>> numbers) {
            this.numbers = numbers;
        }

        public int size() {
            return numbers.size();
        }

        public List<Set<Integer>> getNumbers() {
            return numbers;
        }
    }

    private static class NotEnoughMoneyException extends IllegalArgumentException {
    }
}
