package com.ssabae.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.ssabae.nextstep.lotto.domain.lotto.LottoNumber;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTicket;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTickets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
class LottoTicketsAnalyzerTest {

    LottoTicketsAnalyzer analyzer = new LottoTicketsAnalyzer();

    @Test
    void analyzerTest() {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", "7");
        LottoTickets dummyLottoTickets = getDummyLottoTickets();
        LottoResult lottoResult = analyzer.analyze(dummyLottoTickets, winningNumber);
        assertAll(
                () -> assertThat(lottoResult.getMatchCountMap().getOrDefault(Reward.FIRST, 0)).isEqualTo(1),
                () -> assertThat(lottoResult.getMatchCountMap().getOrDefault(Reward.SECOND, 0)).isEqualTo(1),
                () -> assertThat(lottoResult.getMatchCountMap().getOrDefault(Reward.THIRD, 0)).isEqualTo(1),
                () -> assertThat(lottoResult.getMatchCountMap().getOrDefault(Reward.FOURTH, 0)).isEqualTo(1),
                () -> assertThat(lottoResult.getMatchCountMap().getOrDefault(Reward.FIFTH, 0)).isEqualTo(1),
                () -> assertThat(lottoResult.getMatchCountMap().getOrDefault(Reward.NONE, 0)).isEqualTo(1)
        );
    }

    private LottoTickets getDummyLottoTickets() {
        List<LottoTicket> dummyLottoTicketList = getDummyLottoTicketList();
        return LottoTickets.of(dummyLottoTicketList, 0);
    }

    private List<LottoTicket> getDummyLottoTicketList() {
        List<LottoTicket> dummyLottoTicketList = new ArrayList<>();
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 1, 2, 3, 4, 5, 6 }));  // FIRST
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 1, 2, 3, 4, 5, 7 }));  // SECONDS
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 2, 3, 4, 5, 6, 8 }));  // THIRD
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 3, 4, 5, 6, 7, 8 }));  // FOURTH
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 4, 5, 6, 7, 8, 9 }));  // FIFTH
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 5, 6, 7, 8, 9, 10 })); // NONE
        return dummyLottoTicketList;
    }

    private LottoTicket generateLottoTicketByIntArray(int[] lottoNumberArray) {
        List<LottoNumber> objects = Arrays.stream(lottoNumberArray)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoTicket(objects);
    }
}
