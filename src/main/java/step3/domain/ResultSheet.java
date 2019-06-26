package step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            ++numberOfTicketsCorrespondingToRank;
            lottoResultMap.put(lottoRank, numberOfTicketsCorrespondingToRank);
        }
        return new ResultSheet(lottoResultMap);
    }
}
