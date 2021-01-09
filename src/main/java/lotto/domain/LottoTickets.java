package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> list;

    public LottoTickets(List<LottoTicket> list) {
        this.list = list;
    }

    public Map<LottoPrizeType, List<Integer>> checkResult(WinnerLottoTicket winnerLottoTicket) {
        Map<Integer, List<Integer>> lottoMatchMap = this.list.stream()
            .map(winnerLottoTicket::checkResult)
            .collect(Collectors.groupingBy(integer -> integer));
        Map<LottoPrizeType, List<Integer>> resultEnumMap = new EnumMap<>(LottoPrizeType.class);
        LottoPrizeType[] values = LottoPrizeType.values();
        for (LottoPrizeType value : values) {
            resultEnumMap.put(value, resultEnumMap.getOrDefault(lottoMatchMap.get(value.getPrize()), new ArrayList<>()));
        }
        return resultEnumMap;
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
