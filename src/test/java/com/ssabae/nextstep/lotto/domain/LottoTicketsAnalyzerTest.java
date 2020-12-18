package com.ssabae.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.ssabae.nextstep.lotto.application.LottoResultDto;
import com.ssabae.nextstep.lotto.domain.LottoTicketsAnalyzer;
import com.ssabae.nextstep.lotto.domain.WinningNumber;
import com.ssabae.nextstep.lotto.domain.lotto.LottoNumber;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTicket;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTickets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");
        LottoTickets dummyLottoTickets = getDummyLottoTickets();
        LottoResultDto lottoResultDto = analyzer.convertToDto(dummyLottoTickets, winningNumber);

        int countOfTicket = lottoResultDto.getCountOfTicket();

        assertThat(countOfTicket).isEqualTo(dummyLottoTickets.getLottoTickets().size());
        assertThat(lottoResultDto.getCountByMatchCount(6)).isEqualTo(1);
        assertThat(lottoResultDto.getCountByMatchCount(5)).isEqualTo(1);
        assertThat(lottoResultDto.getCountByMatchCount(4)).isEqualTo(1);
        assertThat(lottoResultDto.getCountByMatchCount(3)).isEqualTo(1);
        assertThat(lottoResultDto.getCountByMatchCount(2)).isEqualTo(1);
    }

    private LottoTickets getDummyLottoTickets() {
        List<LottoTicket> dummyLottoTicketList = getDummyLottoTicketList();
        return new LottoTickets(dummyLottoTicketList);
    }

    private List<LottoTicket> getDummyLottoTicketList() {
        List<LottoTicket> dummyLottoTicketList = new ArrayList<>();
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 1, 2, 3, 4, 5, 6 }));  // FIRST
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 2, 3, 4, 5, 6, 7 }));  // SECOND
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 3, 4, 5, 6, 7, 8 }));  // THIRD
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 4, 5, 6, 7, 8, 9 }));  // FOURTH
        dummyLottoTicketList.add(generateLottoTicketByIntArray(new int[]{ 5, 6, 7, 8, 9, 10 })); // NONE
        return dummyLottoTicketList;
    }

    private LottoTicket generateLottoTicketByIntArray(int[] lottoNumberArray) {
        LottoNumber[] objects = Arrays.stream(lottoNumberArray).mapToObj(LottoNumber::of).toArray(LottoNumber[]::new);
        return new LottoTicket(objects);
    }
}
