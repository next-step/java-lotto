package step4.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSheet {
    private static final int LOTTO_TICKET_PRICE = 1000;

    private Map<LottoRank, Integer> resultSheet;

    private ResultSheet(Map<LottoRank, Integer> resultSheet) {
        this.resultSheet = resultSheet;
    }

    public static ResultSheet getResult(LottoTickets lottoTickets, LuckyTicket luckyTicket) {
        Map<LottoRank, Integer> lottoResultMap = new HashMap<>();

        for (LottoTicket ticket : lottoTickets.getLottoTickets()) {
            LottoRank lottoRank = LottoRank.from(ticket, luckyTicket);
            int numberOfTicketsCorrespondingToRank = lottoResultMap.getOrDefault(lottoRank, 0);
            lottoResultMap.put(lottoRank, ++numberOfTicketsCorrespondingToRank);
        }
        return new ResultSheet(lottoResultMap);
    }

    private int getTotalTicketsBought() {
        return resultSheet.values()
                .stream()
                .reduce(Integer::sum)
                .get();
    }

    private int totalMoneySpentForTickets() {
        return getTotalTicketsBought() * LOTTO_TICKET_PRICE;
    }

    private int getNumberOfTicketsCorrespondingToRank(LottoRank lottoRank) {
        return resultSheet.getOrDefault(lottoRank, 0);
    }

    private int getEachPrizeMoney(LottoRank lottoRank) {
        return lottoRank.getPrizeMoney() * this.getNumberOfTicketsCorrespondingToRank(lottoRank);
    }

    private int getTotalPrizeMoney() {
        return resultSheet.keySet()
                .stream()
                .mapToInt(this::getEachPrizeMoney)
                .sum();
    }

    public double getEarningRate() {
        return getTotalPrizeMoney() / totalMoneySpentForTickets();
    }

    public Map<LottoRank, Integer> getResultMap() {
        return resultSheet;
    }
}
