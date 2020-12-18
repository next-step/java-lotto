package com.ssabae.nextstep.lotto.domain;

import com.ssabae.nextstep.lotto.application.LottoResultDto;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTicket;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTickets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class LottoTicketsAnalyzer {

    public LottoResultDto convertToDto(LottoTickets lottoTickets, WinningNumber winningNumber) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();

        Map<Integer, Integer> matchCountMap = new HashMap<>();
        int countOfTicket = lottoTicketList.size();

        for (LottoTicket lottoTicket : lottoTicketList) {
            int matchCount = getMatchCount(lottoTicket, winningNumber);
            Integer countOfMatchCount = matchCountMap.getOrDefault(matchCount, 0);
            matchCountMap.put(matchCount, countOfMatchCount + 1);
        }
        return new LottoResultDto(matchCountMap, countOfTicket);
    }

    private int getMatchCount(LottoTicket lottoTicket, WinningNumber winningNumber) {
        List<Integer> winningNumberList = winningNumber.getWinningNumberList();
        return (int) Arrays.stream(lottoTicket.getNumbers())
                .filter(lottoNumber -> winningNumberList.contains(lottoNumber.getNumber()))
                .count();
    }

}
