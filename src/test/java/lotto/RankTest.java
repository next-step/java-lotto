package lotto;

import org.junit.jupiter.api.Test;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 10, 11, 12));

    @Test
    void sumRewardTest() {
        List<LottoTicket> lottos = new ArrayList<>();
        lottos.add(lottoTicket);

        LottoTickets lottoTickets = new LottoTickets(lottos);

        Ranks ranks = new Ranks(lottoTickets, Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNum(7));

        assertThat(ranks.sumReward()).isEqualTo(5000);
    }
}
