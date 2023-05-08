package lotto.domain;

import lotto.dto.LottoStatisticsDto;

import java.util.List;

public class LottoTicketMachine {

    public static final int LOTTO_PRICE = 1000;

    public LottoTickets lottoTicketsTotal;
    public int autoPurchaseCount;

    public LottoTicketMachine(int manualPurchaseCount, int purchaseAmount) {
        validateManualPurchaseCount(manualPurchaseCount, purchaseAmount);
        this.autoPurchaseCount
                = calculateAutoPurchaseCount(manualPurchaseCount, purchaseAmount);
    }

    private int calculateAutoPurchaseCount(int manualPurchaseCount, int purchaseAmount) {
        return (purchaseAmount - LOTTO_PRICE * manualPurchaseCount) / LOTTO_PRICE;
    }

    private void validateManualPurchaseCount(int manualPurchaseCount, int purchaseAmount) {
        if (purchaseAmount < manualPurchaseCount * LOTTO_PRICE) {
            throw new IllegalArgumentException("구입할 금액을 초과합니다.");
        }
    }

    public void createLottoTickets(List<List<Integer>> tickets) {
        if(autoPurchaseCount == 0) {
            createManualLottoTickets(tickets);
            return;
        }
        if (tickets.size() == 0) {
            createAutoLottoTickets(autoPurchaseCount);
            return;
        }
        createManualLottoTickets(tickets);
        createAutoLottoTickets(autoPurchaseCount);
    }

    private void createAutoLottoTickets(int autoPurchaseCount) {
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

    private void createManualLottoTickets(List<List<Integer>> tickets) {
        NumberCreationStrategy strategy = new ManualNumberCreation(tickets);
        setLottoTicketsTotal(strategy);
    }

    public LottoTickets getLottoTicketsTotal() {
        return lottoTicketsTotal;
    }

    public int getAutoPurchaseCount() {
        return autoPurchaseCount;
    }
}
