package lotto.model;

import lotto.type.Winning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_WINNING_MIN_COUNT = 3;
    private static final int DEFAULT_LOTTO_AMOUNT = 0;
    private static final int MATCHED_BONUS_COUNT = 5;

    private int purchaseAmount = 0;
    private int autoGameCount = 0;
    private int manualGameCount = 0;
    private int totalGameCount = 0;

    private WinningNumbers winningNumbers;

    public LottoTicket getLottoTicket(ManualLottoNumbers manualLottoNumbers) {
        return new LottoTicket(manualLottoNumbers, this.autoGameCount);
    }

    public int getLottoAmount(int purchaseAmount) {
        if (purchaseAmount <= DEFAULT_LOTTO_AMOUNT) {
            return DEFAULT_LOTTO_AMOUNT;
        }
        this.purchaseAmount = purchaseAmount;
        this.totalGameCount = purchaseAmount / LOTTO_PRICE;
        this.autoGameCount = totalGameCount - manualGameCount;
        if (totalGameCount - manualGameCount < 0) {
            return DEFAULT_LOTTO_AMOUNT;
        }

        return this.totalGameCount;
    }

    public void settingWinningNumber(String numberText, int bonusNumber) {
        winningNumbers = new WinningNumbers(numberText, bonusNumber);
    }

    public Map<Winning, Integer> setWinningCount(LottoTicket lottoTicket) {
        Map<Winning, Integer> winningCount = new HashMap<>();
        for (LottoNumbers lottoNumbers : lottoTicket.getLottoTicketInfo()) {
            setCount(winningCount, lottoNumbers);
        }
        return winningCount;
    }

    private boolean matchedBonus(LottoNumbers lottoNumbers, int count) {
        if (count == MATCHED_BONUS_COUNT) {
            return winningNumbers.checkBonusNumber(lottoNumbers.selectedNumber());
        }
        return false;
    }

    private void setCount(Map<Winning, Integer> winningCount, LottoNumbers lottoNumbers) {
        int overlapCount = winningNumbers.checkOverlapNumber(lottoNumbers.selectedNumber());
        if (overlapCount < LOTTO_WINNING_MIN_COUNT) {
            return;
        }
        Winning winning = Winning.findByWinning(overlapCount, matchedBonus(lottoNumbers, overlapCount));
        countUp(winningCount, winning);
    }

    private void countUp(Map<Winning, Integer> winningCount, Winning winning) {
        int count = 1;
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
