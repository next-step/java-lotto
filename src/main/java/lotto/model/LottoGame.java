package lotto.model;

import lotto.type.Winning;

import java.util.HashMap;
import java.util.Map;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_WINNING_MIN_COUNT = 3;
    private static final int DEFAULT_LOTTO_AMOUNT = 0;

    private int purchaseAmount = 0;
    private int gameCount = 0;
    private WinningNumber winningNumber;

    public LottoTicket getLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket();
        return lottoTicket.generateNumbers(this.gameCount);
    }

    public int getLottoAmount(int purchaseAmount) {
        if (purchaseAmount <= DEFAULT_LOTTO_AMOUNT) {
            return DEFAULT_LOTTO_AMOUNT;
        }
        this.purchaseAmount = purchaseAmount;
        this.gameCount = purchaseAmount / LOTTO_PRICE;
        return this.gameCount;
    }

    public void settingWinningNumber(String numberText) {
        winningNumber = new WinningNumber(numberText);
    }

    public Map<Winning, Integer> setWinningCount(LottoTicket lottoTicket) {
        Map<Winning, Integer> winningCount = new HashMap<>();
        for (LottoNumbers lottoNumbers : lottoTicket.getTicketInfo()) {
            int count = winningNumber.checkOverlapNumber(lottoNumbers.selectedNumber());
            setCount(winningCount, count);
        }
        return winningCount;
    }


    private void setCount(Map<Winning, Integer> winningCount, int overlapCount) {
        int count = 1;
        if (overlapCount < LOTTO_WINNING_MIN_COUNT) {
            return;
        }
        Winning winning = Winning.findByWinning(overlapCount);
        if (winningCount.containsKey(winning)) {
            count = winningCount.get(winning);
            count += 1;
        }
        winningCount.put(winning, count);
    }

    public double getMargin(Map<Winning, Integer> winningCount) {
        double result = 0;
        for (Winning winning : winningCount.keySet()) {
            result += winning.getReward() * winningCount.get(winning).intValue();
        }
        return result / (double) this.purchaseAmount;
    }

}
