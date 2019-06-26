package step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSheet {

    private Map<LottoRank, Integer> resultSheet;

    private ResultSheet(Map<LottoRank, Integer> resultSheet) {
        this.resultSheet = resultSheet;
    }

    public static ResultSheet getResult(List<LottoTicket> lottoTickets, LottoTicket luckyNumber, int bonusNumber) {
        Map<LottoRank, Integer> lottoResultMap = new HashMap<>();

        for (LottoTicket ticket : lottoTickets) {
            LottoRank lottoRank = LottoRank.from(ticket.getNumberOfMatchedToLuckyNumber(luckyNumber), ticket.isBonusNumberMatched(bonusNumber));
            int numberOfTicketsCorrespondingToRank = lottoResultMap.getOrDefault(lottoRank, 0);
            lottoResultMap.put(lottoRank, ++numberOfTicketsCorrespondingToRank);
        }
        return new ResultSheet(lottoResultMap);
    }

    public int getTotalPrizeMoney() {
        return resultSheet.keySet()
                .stream()
                .map(LottoRank::getPrizeMoney)
                .reduce(Integer::sum)
                .get();
    }

    public int getTotalTicketsBought() {
        return (int) resultSheet.values()
                .stream()
                .count();
    }

    public Map<LottoRank, Integer> getResultMap() {
        return resultSheet;
    }
}
