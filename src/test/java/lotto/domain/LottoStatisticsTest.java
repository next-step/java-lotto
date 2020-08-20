package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    @DisplayName("당첨 번호와 일치 개수에 따라 당첨 통계를 낸다.")
    void getLottoResult() {
        // given
        LottoTicket winningTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 10, 15, 35));
        LottoTicket lottoTicket1 = LottoTicket.of(Arrays.asList(1, 2, 3, 10, 15, 35));
        LottoTicket lottoTicket2 = LottoTicket.of(Arrays.asList(1, 3, 10, 27, 35, 39));
        LottoTicket lottoTicket3 = LottoTicket.of(Arrays.asList(18, 21, 22, 29, 30, 35));
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3), 3000);

        LottoStatistics lottoStatistics = new LottoStatistics(winningTicket);

        EnumMap<Rank, Integer> expectedResultMap = new EnumMap<Rank, Integer>(Rank.class);
        expectedResultMap.put(Rank.FIRST, 1);
        expectedResultMap.put(Rank.FOURTH, 1);
        expectedResultMap.put(Rank.MISS, 1);

        // when
        LottoResult lottoResult = lottoStatistics.getLottoResult(lottoTickets);

        //then
        assertThat(lottoResult).isEqualTo(new LottoResult(expectedResultMap));
    }

}