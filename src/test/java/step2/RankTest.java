package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Bonus;
import step2.domain.LottoTicket;
import step2.domain.Ranks;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 10, 11, 12));

    @Test
    void sumRewardTest() {
        Ranks ranks = new Ranks();
        ranks.countWinning(lottoTicket, 3, new Bonus(5));

        assertThat(ranks.sumReward()).isEqualTo(5000);
    }
}
