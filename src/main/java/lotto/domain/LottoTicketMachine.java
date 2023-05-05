package lotto.domain;

import lotto.dto.LottoStatisticsDto;

import java.util.List;

public class LottoTicketMachine {

    public static final int LOTTO_PRICE = 1000;

    private static LottoTickets lottoTicketsTotal;

    private LottoTicketMachine() {
    }

    public static LottoTickets createAutoLottoTickets(int autoPurchaseCount) {
        NumberCreationStrategy strategy = new RandomNumberCreation(autoPurchaseCount);
        if (lottoTicketsTotal == null) {
            lottoTicketsTotal = new LottoTickets(strategy);
            return lottoTicketsTotal;
        }
        lottoTicketsTotal.addLottoTickets(strategy);
        return lottoTicketsTotal;
    }

    public static LottoTickets createManualLottoTickets(List<List<Integer>> tickets) {
        NumberCreationStrategy strategy = new ManualNumberCreation(tickets);
        if (lottoTicketsTotal == null) {
            lottoTicketsTotal = new LottoTickets(strategy);
            return lottoTicketsTotal;
        }
        lottoTicketsTotal.addLottoTickets(strategy);
        return lottoTicketsTotal;
    }

    public LottoStatisticsDto calculateLottoStatistics(WinningTicket winningTicket) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        return new LottoStatisticsDto(
                lottoStatistics.calculateMatchingCounts(lottoTicketsTotal, winningTicket),
                lottoStatistics.calculateGrossRateOfEarnings(lottoTicketsTotal.getSize())
        );
    }

    public LottoTickets getLottoTicketsTotal() {
        return lottoTicketsTotal;
    }
}
