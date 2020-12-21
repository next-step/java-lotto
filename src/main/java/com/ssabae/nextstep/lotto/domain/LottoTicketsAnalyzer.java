package com.ssabae.nextstep.lotto.domain;

import static com.ssabae.nextstep.lotto.Constant.LOTTO_TICKET_PRICE;

import com.ssabae.nextstep.lotto.domain.LottoResult.LottoResultBuilder;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTicket;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTickets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class LottoTicketsAnalyzer {

    public LottoResult analyze(LottoTickets lottoTickets, WinningNumber winningNumber) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();

        Map<Integer, Integer> matchCountMap = mappingCountToMatchCount(lottoTicketList, winningNumber);

        Money spendMoney = LOTTO_TICKET_PRICE.times(lottoTicketList.size());
        Money earnMoney = calculateEarnMoney(matchCountMap);

        return LottoResultBuilder.builder()
                .matchCountMap(matchCountMap)
                .spendMoney(spendMoney)
                .earnMoney(earnMoney)
                .build();
    }

    private Map<Integer, Integer> mappingCountToMatchCount(List<LottoTicket> lottoTicketList, WinningNumber winningNumber) {
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTicketList) {
            int matchCount = getMatchCount(lottoTicket, winningNumber);
            Integer countOfMatchCount = matchCountMap.getOrDefault(matchCount, 0);
            matchCountMap.put(matchCount, countOfMatchCount + 1);
        }
        return matchCountMap;
    }

    private int getMatchCount(LottoTicket lottoTicket, WinningNumber winningNumber) {
        List<Integer> winningNumberList = winningNumber.getWinningNumberList();
        return (int) lottoTicket.getNumbers().stream()
                .filter(lottoNumber -> winningNumberList.contains(lottoNumber.getNumber()))
                .count();
    }

    private Money calculateEarnMoney(Map<Integer, Integer> matchCountMap) {
        Money earnMoney = Money.ZERO;
        for (Reward reward : Reward.getReportableRewards()) {
            Integer countByMatchCount = matchCountMap.getOrDefault(reward.getCountOfMatch(), 0);
            Money earnMoneyByReward = reward.getWinningMoney().times(countByMatchCount);
            earnMoney = earnMoney.plus(earnMoneyByReward);
        }
        return earnMoney;
    }


}
