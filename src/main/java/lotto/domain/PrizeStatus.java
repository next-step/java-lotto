package lotto.domain;

import java.util.HashMap;

public class PrizeStatus {

    private HashMap<Integer, Integer> prizeStatus = new HashMap<>();

    public PrizeStatus(LottoTickets lottoTickets, WinnerNumbers winnerNumbers) {
        setupPrizeStatus();

        for (int i = 0; i < lottoTickets.numberOfPurchasedTicket(); i++) {
            int totalMatchedCount = winnerNumbers.calculateTotalMatchedCount(lottoTickets.tickets().get(i));
            updatePrizeStatus(totalMatchedCount);
        }
    }

    private void updatePrizeStatus(int totalMatchedCount) {
        if (totalMatchedCount >= 3) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount);
            this.prizeStatus.put(totalMatchedCount, currentNumOfPrize + 1);
        }
    }

    public int getCurrentNumOfPrize(int totalMatchedCount) {
        return prizeStatus.get(totalMatchedCount);
    }

    private void setupPrizeStatus() {
        prizeStatus.put(3, 0);
        prizeStatus.put(4, 0);
        prizeStatus.put(5, 0);
        prizeStatus.put(6, 0);
    }
}
