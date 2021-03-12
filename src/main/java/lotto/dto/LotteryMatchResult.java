package lotto.dto;

import lotto.domain.LotteryTicket;

import java.util.*;

public class LotteryMatchResult {

    private Map<Integer, List<LotteryTicketDto>> matchingCountWithLotteryTicketListMap = new HashMap<>();

    public void addResult(int matchingCount, LotteryTicket lotteryTicket) {
        if (!matchingCountWithLotteryTicketListMap.containsKey(matchingCount)) {
            matchingCountWithLotteryTicketListMap.put(matchingCount, new ArrayList<>());
        }
        List<LotteryTicketDto> lotteryTicketList = matchingCountWithLotteryTicketListMap.get(matchingCount);
        lotteryTicketList.add(new LotteryTicketDto(lotteryTicket));
    }


    public List<LotteryTicketDto> getLotteryTicketListByMatchingCount(int matchingCount) {
        if (matchingCountWithLotteryTicketListMap.containsKey(matchingCount)) {
            return matchingCountWithLotteryTicketListMap.get(matchingCount);
        }
        return Collections.emptyList();
    }

    public int getLotteryTicketListCountByMatchingCount(int matchingCount) {
        return getLotteryTicketListByMatchingCount(matchingCount).size();
    }
}
