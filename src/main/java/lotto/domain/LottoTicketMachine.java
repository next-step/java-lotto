package lotto.domain;

import lotto.dto.LottoStatisticsDto;

import java.util.List;

public class LottoTicketMachine {

    public static final int LOTTO_PRICE = 1000;

    public LottoTickets lottoTicketsTotal;

    public LottoTicketMachine() {
    }

    public LottoTicketMachine(LottoTickets lottoTicketsTotal) {
        this.lottoTicketsTotal = lottoTicketsTotal;
    }

    public void createAutoLottoTickets(int autoPurchaseCount) {
        NumberCreationStrategy strategy = new RandomNumberCreation(autoPurchaseCount);
        setLottoTicketsTotal(strategy);
    }

    private void setLottoTicketsTotal(NumberCreationStrategy strategy) {
        if (lottoTicketsTotal == null) {
            lottoTicketsTotal = new LottoTickets(strategy);
            return;
        }
        lottoTicketsTotal.addLottoTickets(strategy);
    }

    public void createManualLottoTickets(List<List<Integer>> tickets) {
        NumberCreationStrategy strategy = new ManualNumberCreation(tickets);
        setLottoTicketsTotal(strategy);
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
