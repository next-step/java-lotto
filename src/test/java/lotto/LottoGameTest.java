package lotto;

import lotto.constant.LottoRank;
import lotto.model.LottoTicket;
import lotto.model.LottoTicketList;
import lotto.model.WinningInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private LottoGame lottoGame;
    private LottoTicketList lottoTicketList;
    private WinningInfo winningInfo;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
        List<LottoTicket> list = new ArrayList<>();
        list.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)));   // FIRST
        list.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 45)));  // SECOND
        list.add(new LottoTicket(List.of(1, 2, 3, 4, 45, 66))); // FOURTH
        list.add(new LottoTicket(List.of(1, 2, 3, 4, 55, 66))); // FOURTH
        list.add(new LottoTicket(List.of(1, 2, 3, 44, 55, 66)));// FIFTH
        list.add(new LottoTicket(List.of(1, 2, 3, 44, 55, 66)));// FIFTH
        lottoTicketList = new LottoTicketList(list);
        winningInfo = new WinningInfo("1, 2, 3, 4, 5, 6", 45);
    }

    @Test
    void getRateReturn() {
        Map<LottoRank, Integer> map = lottoTicketList.scratchLottoList(winningInfo);
        int totalPrize = map.keySet().stream()
                .map(o -> o.getPrize() * map.get(o))
                .reduce(0, Integer::sum);
        double cost = 100_000_000_000d;
        assertThat(totalPrize).isEqualTo(2_030_110_000);
        assertThat(lottoGame.getRateReturn(map, cost)).isEqualTo(totalPrize / cost);
    }

    @Test
    void getLottoCount() {
        assertThat(lottoGame.getLottoCount(15000)).isEqualTo(15);
        assertThat(lottoGame.getLottoCount(-100)).isEqualTo(0);
        assertThat(lottoGame.getLottoCount(300)).isEqualTo(0);
    }
}
