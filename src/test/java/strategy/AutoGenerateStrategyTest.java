package strategy;

import lotto.domain.LotteryTicket;
import lotto.strategy.AutoGenerateStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoGenerateStrategyTest {
    @Test
    void generate_lottery_ticket() {
        assertThat(new AutoGenerateStrategy().generate()).isInstanceOf(LotteryTicket.class);
    }
}
