package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> list;

    public LottoTickets(List<LottoTicket> list) {
        this.list = list;
    }

    public Map<LottoPrizeType, Integer> checkResult(WinnerLottoTicket winnerLottoTicket) {
        Map<Integer, List<Integer>> lottoMatchMap = groupingByPrizeWithWinnerLottoTicket(winnerLottoTicket);
        Map<LottoPrizeType, Integer> resultEnumMap = new EnumMap<>(LottoPrizeType.class);
        Arrays.stream(LottoPrizeType.values())
            .forEach(lottoPrizeType -> resultEnumMap.put(lottoPrizeType,
                lottoMatchMap.getOrDefault(lottoPrizeType.getMatch(), Collections.emptyList())
                    .size()));
        return resultEnumMap;
    }

    private Map<Integer, List<Integer>> groupingByPrizeWithWinnerLottoTicket(WinnerLottoTicket winnerLottoTicket) {
        return this.list.stream()
            .map(winnerLottoTicket::checkResult)
            .collect(Collectors.groupingBy(integer -> integer));
    }

    public int size() {
        return this.list.size();
    }

    public List<String> getLottoTicketString() {
        return this.list.stream()
            .map(LottoTicket::joiningResult)
            .collect(Collectors.toList());
    }
}
