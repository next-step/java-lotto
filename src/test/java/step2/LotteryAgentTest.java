package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Object[] ticketAndChange = lotteryAgent.exchange(1500);
        assertThat(ticketAndChange).isNotNull() //
                .hasSize(2) //
                .hasOnlyElementsOfTypes(LottoTickets.class, Integer.class);
    }

    @DisplayName("돈이 최소 구입금액에 못미치면 예외가 발생한다.")
    @Test
    void notEnoughMoney() {
        assertThatThrownBy(() -> lotteryAgent.exchange(500)) //
                .isInstanceOf(NotEnoughMoneyException.class);
    }

    private static class LotteryAgent {
        private static final int PRICE_LOTTERY = 1000;

        public Object[] exchange(int money) {
            if (money < PRICE_LOTTERY) {
                throw new NotEnoughMoneyException();
            }

            return new Object[]{new LottoTickets(), 0};
        }
    }

    private static class LottoTickets {
    }

    private static class NotEnoughMoneyException extends IllegalArgumentException {
    }
}
