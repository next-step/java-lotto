package step3.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSheet {

    private Map<LottoRank, List<LottoTicket>> resultSheet;

    private ResultSheet(Map<LottoRank, List<LottoTicket>> resultSheet) {
        this.resultSheet = resultSheet;
    }

    public static ResultSheet getResult(List<LottoTicket> lottoTickets, LottoTicket luckyNumber) {
        Map<LottoRank, List<LottoTicket>> lottoResultMap = new HashMap<>();

        for (LottoTicket ticket : lottoTickets) {
            LottoRank lottoRank = LottoRank.from(ticket.getNumberOfMatchedToLuckyNumber(luckyNumber));
            List<LottoTicket> ticketsCorrespondingToRank = lottoResultMap.getOrDefault(lottoRank, new ArrayList<>());
            ticketsCorrespondingToRank.add(ticket);
            lottoResultMap.put(lottoRank, ticketsCorrespondingToRank);
        }
        return new ResultSheet(lottoResultMap);
    }
}
