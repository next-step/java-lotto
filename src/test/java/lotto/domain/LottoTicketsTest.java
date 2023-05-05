package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    void init() {
        List<List<Integer>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        tickets.add(Arrays.asList(1, 2, 3, 10, 11, 12));
        tickets.add(Arrays.asList(1, 2, 3, 7, 8, 9));
        lottoTickets = new LottoTickets(new ManualNumberCreation(tickets));
    }

    @Test
    void constructor() throws Exception {
        //given

        //when

        //then
        assertDoesNotThrow(() -> {
            new LottoTickets(new RandomNumberCreation(7));
        });
    }

    @Test
    void calculateSameNumberCount() throws Exception {
        //given
        LottoTicket winningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.of(9);

        //when
        Map<LottoRank, Integer> sameNumberCounts
                = lottoTickets.calculateSameNumberCounts(winningTicket, bonusNumber);

        //then
        assertThat(sameNumberCounts).containsKeys(LottoRank.FIFTH, LottoRank.FIRST).containsValues(1, 2);
    }
}
