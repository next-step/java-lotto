package step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultSheet {

    private Map<LottoRank, Integer> resultSheet;

    private ResultSheet(Map<LottoRank, Integer> resultSheet) {
        this.resultSheet = resultSheet;
    }

    public static ResultSheet getResult(List<LottoTicket> lottoTickets, LottoTicket luckyNumber) {
        Map<LottoRank, Integer> lottoResultMap = new HashMap<>();

        for (LottoTicket ticket : lottoTickets) {
            LottoRank lottoRank = LottoRank.from(ticket.getNumberOfMatchedToLuckyNumber(luckyNumber));
            int numberOfTicketsCorrespondingToRank = lottoResultMap.getOrDefault(lottoRank, 0);
            lottoResultMap.put(lottoRank, ++numberOfTicketsCorrespondingToRank);
        }
        return new ResultSheet(lottoResultMap);
    }

    public int getTotalPrizeMoney() {
        return resultSheet.keySet()
                .stream()
                .map(LottoRank::getPrizeMoney)
                .reduce(((prize1, prize2) -> prize1 + prize2))
                .get();

    }

    public Map<LottoRank, Integer> getResultMap() {
        return resultSheet;
    }
}
