package lotto.model;

import lotto.LottoTicketMaker;
import lotto.constant.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketListTest {

    private LottoTicketList lottoTicketList;
    private WinningInfo winningInfo;

    @BeforeEach
    void setUp() {
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
    void getLottoTickets() {
        assertThat(lottoTicketList.getLottoTickets().size()).isEqualTo(6);
    }

    @Test
    void initLottoMap() {
        Map<LottoRank, Integer> map = lottoTicketList.initLottoMap();
        assertThat(map.size()).isEqualTo(6);
        assertThat(map.values().stream()
                .filter(o -> o != 0).count())
                .isEqualTo(0);
    }

    @Test
    void scratchLottoList() {
        Map<LottoRank, Integer> map = lottoTicketList.scratchLottoList(winningInfo);
        assertThat(map.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(map.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(map.get(LottoRank.THIRD)).isEqualTo(0);
        assertThat(map.get(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(map.get(LottoRank.FIFTH)).isEqualTo(2);
    }
}